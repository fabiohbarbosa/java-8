package com.wordpress.fabiohbarbosa.alura.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Exercicio4 {
    public static void main(String[] args) {
        List<Curso> cursos = new ArrayList<>();
        cursos.add(new Curso("Python", 45, CursoType.BACKEND));
        cursos.add(new Curso("JavaScript", 150, CursoType.FULLSTACK));
        cursos.add(new Curso("Java 8", 113, CursoType.BACKEND));
        cursos.add(new Curso("C", 55, CursoType.BACKEND));

        orderByAlunos(cursos);
        greaterThan(cursos);
        streamString(cursos);
        methodReference(cursos);
    }

    private static void methodReference(final List<Curso> cursos) {
        cursos.stream()
                .filter(c -> c.getAlunos() > 50)
                .map(Curso::getAlunos)
                .forEach(System.out::println);
    }

    private static void orderByAlunos(final List<Curso> cursos) {
        System.out.println("\n#####################################");
        cursos.sort(Comparator.comparingInt(Curso::getAlunos));
        cursos.forEach(c -> System.out.println(c.getNome()));
    }

    private static void greaterThan(final List<Curso> cursos) {
        cursos.stream()
                .filter(c -> c.getAlunos() > 50)
                .forEach(c -> System.out.println(c.getNome()));
    }

    private static void streamString(final List<Curso> cursos) {
        cursos.stream().map(Curso::getNome);
    }

}
