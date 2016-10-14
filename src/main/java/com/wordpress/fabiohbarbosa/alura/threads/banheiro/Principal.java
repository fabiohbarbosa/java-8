package com.wordpress.fabiohbarbosa.alura.threads.banheiro;

public class Principal {

    public static Banheiro banheiro = new Banheiro();

    public static void main(String[] args) {
        new Thread(() -> banheiro.nro1(), "Fábio").start();
        new Thread(() -> banheiro.nro2(), "Pedro").start();
//        new Thread(() -> banheiro.nro1(), "Josy").start();
//        new Thread(() -> banheiro.nro1(), "Bia").start();
//        new Thread(() -> banheiro.nro2(), "Gabriel").start();
        final Thread limpeza = new Thread(() -> {
            while(true) {
                banheiro.limpeza();
                try {
                    Thread.sleep(15000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Limpeza");
        limpeza.setPriority(Thread.MAX_PRIORITY);
        limpeza.setDaemon(true);
        limpeza.start();
    }
}
