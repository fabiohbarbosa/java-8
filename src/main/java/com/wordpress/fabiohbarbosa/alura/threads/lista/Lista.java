package com.wordpress.fabiohbarbosa.alura.threads.lista;

public class Lista {
    private String[] elementos = new String[1000];
    private int indice = 0;

    public synchronized void adicionaElementos(final String elemento) {
        elementos[indice] = elemento;
        indice++;

        if (indice == elementos.length) {
            System.out.println("Lista 100% preenchida");
            this.notify();
        }
    }

    public int tamanho() {
        return elementos.length;
    }

    public String pegaElemento(int posicao) {
        return elementos[posicao];
    }

    public boolean estaCheia() {
        return indice == elementos.length;
    }
}
