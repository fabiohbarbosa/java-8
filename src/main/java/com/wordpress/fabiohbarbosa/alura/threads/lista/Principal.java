package com.wordpress.fabiohbarbosa.alura.threads.lista;

import java.util.List;
import java.util.Vector;

public class Principal {
    public static void main(String[] args) throws InterruptedException {
//        new Principal().atomicListJavaUtil();
        new Principal().minhaLista();
    }

    private void minhaLista() throws InterruptedException {
        final Lista lista = new Lista();

        for (int i = 0; i < 10; i++) {
            final int threadId = i;
            new Thread(() -> {
                for (int j = 0; j < 100 ; j++) {
                    lista.adicionaElementos(String.format("Thread %s - %s", threadId, j));
                }
            }).start();
        }

        Thread.sleep(1000);

        synchronized(lista) {
            if (!lista.estaCheia()) {
                System.out.println("Esperando Thread...");
                lista.wait();
            }


            for (int i = 0; i < lista.tamanho(); i++) {
                System.out.println(i + " - "+ lista.pegaElemento(i));
            }
        }
    }

    private void atomicListJavaUtil() throws InterruptedException {
        List<String> lista = new Vector<>();

        for (int i = 0; i < 10; i++) {
            final int threadId = i;
            new Thread(() -> {
                for (int j = 0; j < 100 ; j++) {
                    lista.add(String.format("Thread %s - %s", threadId, j));
                }
            }).start();
        }

        Thread.sleep(2000);

        for (int i = 0; i < lista.size(); i++) {
            System.out.println(i + " - "+ lista.get(i));
        }
    }
}
