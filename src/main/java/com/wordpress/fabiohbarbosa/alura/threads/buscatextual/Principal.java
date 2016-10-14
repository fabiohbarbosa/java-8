package com.wordpress.fabiohbarbosa.alura.threads.buscatextual;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        String nome = "da";
        new Thread(() -> readFile("assinaturas1.txt", nome), "Thread Assinaturas 1").start();
        new Thread(() -> readFile("assinaturas2.txt", nome), "Thread Assinaturas 2").start();
        new Thread(() -> readFile("autores.txt", nome), "Thread Autores").start();
    }

    public static void readFile(final String arquivo, final String nome) {
        try {
            System.out.format("Arquivo %s - Thread ID: %s\n", arquivo, Thread.currentThread().getId());
             final Scanner scanner = new Scanner(new File(Principal.class.getClassLoader().getResource(arquivo).getFile()));

            int nroLinha = 1;
            boolean found = false;
            while (scanner.hasNextLine()) {
                final String line = scanner.nextLine();
                if (line.toLowerCase().contains(nome.toLowerCase())) {
                    System.out.format("\033[0;1m%s \033[0;0m- Arquivo \033[0;1m%s \033[0;0m- Linha \033[0;0m%s\n", line, arquivo, nroLinha);
                    found = true;
                }
                nroLinha++;
            }
            if (!found) {
                System.out.format("Não foi encontrado o nome \033[0;1m%s \033[0;0mno arquivo %s\n", nome, arquivo);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
