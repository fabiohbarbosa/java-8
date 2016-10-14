package com.wordpress.fabiohbarbosa.alura.threads.banco;

public class Principal {

    public static void main(String[] args) {

        GerenciadorTransacao tx = new GerenciadorTransacao();
        PoolConexao pool = new PoolConexao();

        new Thread(() -> {
            synchronized (pool) {
                System.out.println("Peguei a chave do pool");
                pool.getConnection();

                synchronized (tx) {
                    System.out.println("Iniciando TX");
                    tx.begin();
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (tx) {
                System.out.println("Começando a TX");
                tx.begin();

                synchronized (pool) {
                    System.out.println("Pegando a conexão");
                    pool.getConnection();

                }
            }
        }).start();


    }

}