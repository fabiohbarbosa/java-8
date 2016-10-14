package com.wordpress.fabiohbarbosa.alura.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Java8 {
    public static void main(String[] args) {
        List<String> palavras = new ArrayList<>();
        palavras.add("aluno online");
        palavras.add("editora casa do código");
        palavras.add("caelum");

        new Thread(() -> System.out.println("Executando um Runnable")).start();

        // sort by
        sortByJava7(palavras);
        sortByJava8(palavras);

        // forearch
        forEachJava7(palavras);
        forEachJava8(palavras);

        // method reference
        comparatorJava8(palavras);
    }

    private static void forEachJava7(final List<String> palavras) {
        for (final String palavra : palavras) {
            System.out.println(palavra);
        }
    }

    private static void forEachJava8(final List<String> palavras) {
        palavras.forEach(s -> System.out.println(s));
    }

    private static void sortByJava7(final List<String> palavras) {
        Comparator<String> comparator = new ComparadorPorTamanho();
        Collections.sort(palavras, comparator);
        System.out.println(palavras);
    }

    private static void sortByJava8(final List<String> palavras) {
        palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
        System.out.println(palavras);
    }

    private static void comparatorJava8(final List<String> palavras) {
        final Comparator<String> caseInsensitiveOrder = String.CASE_INSENSITIVE_ORDER;
        palavras.sort(caseInsensitiveOrder);
        palavras.sort(Comparator.reverseOrder());
        palavras.sort(Comparator.comparing(s -> s.length()));
        palavras.sort(Comparator.comparing(String::length));
    }

}

class ComparadorPorTamanho implements Comparator<String> {
    public int compare(final String s1, final String s2) {
        if (s1.length() < s2.length()) {
            return -1;
        }
        if (s1.length() > s2.length()) {
            return 1;
        }
        return 0;
    }
}