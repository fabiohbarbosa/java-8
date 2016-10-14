package com.wordpress.fabiohbarbosa.alura.threads.banheiro;

public class Banheiro {
    private boolean isDirty = true;

    public void nro1() {
        String nome = Thread.currentThread().getName();
        System.out.println(nome + " bateu na porta");

        synchronized (this) {
            System.out.println(nome + " entrando no banheiro");

            while (isDirty) {
                waitClean(nome);
            }

            System.out.println(nome + " fazendo coisa rápida");
            wait(5000);

            System.out.println(nome + " dando descarga");
            System.out.println(nome + " lavando a mão");
            System.out.println(nome + " saindo no banheiro");
            isDirty = true;
        }

    }
    public void nro2() {
        String nome = Thread.currentThread().getName();
        System.out.println(nome + " bateu na porta");

        synchronized (this) {
            System.out.println(nome + " entrando no banheiro");

            while (isDirty) {
                waitClean(nome);
            }

            System.out.println(nome + " fazendo coisa demorada");
            wait(10000);

            System.out.println(nome + " dando descarga");
            System.out.println(nome + " lavando a mão");
            System.out.println(nome + " saindo no banheiro");
            isDirty = true;
        }
    }

    public void limpeza() {
        String nome = Thread.currentThread().getName();
        System.out.println(nome + " bateu na porta");

        synchronized (this) {
            System.out.println(nome + " entrando no banheiro");

            if (!isDirty) {
                System.out.println(nome + " saiu do banheiro, pois está limpo");
                return;
            }

            System.out.println(nome + " limpando banheiro");
            wait(10000);
            System.out.println(nome + " saindo no banheiro");

            isDirty = false;
            this.notifyAll();
        }
    }

    private void waitClean(final String nome) {
        System.out.println(nome + " sai do banheiro pois está sujo");
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void wait(final int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
