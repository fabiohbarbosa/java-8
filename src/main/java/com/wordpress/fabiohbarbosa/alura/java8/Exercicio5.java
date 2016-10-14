package com.wordpress.fabiohbarbosa.alura.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Exercicio5 {
    public static void main(String[] args) {
        List<Curso> cursos = new ArrayList<>();
        cursos.add(new Curso("Python", 45, CursoType.BACKEND));
        cursos.add(new Curso("JavaScript", 150, CursoType.FULLSTACK));
        cursos.add(new Curso("Java 8", 113, CursoType.BACKEND));
        cursos.add(new Curso("C", 55, CursoType.BACKEND));

        groupByType(cursos);
        average(cursos);
        toList(cursos);
    }

    private static void toList(final List<Curso> cursos) {
        final List<Curso> nCursos = cursos.stream()
                .filter(c -> c.getAlunos() > 50)
                .collect(Collectors.toList());

        nCursos.forEach(c -> System.out.println(c.getNome()));

    }

    private static void groupByType(final List<Curso> cursos) {
        cursos.stream()
                .collect(Collectors.toMap(Curso::getType, Curso::getAlunos, Integer::sum))
                .forEach((type, alunos) ->
                        System.out.format("O tipo %s tem %s alunos\n", type, alunos));
    }

    private static void average(final List<Curso> cursos) {
        cursos.stream()
                .mapToInt(Curso::getAlunos)
                .average()
                .ifPresent(avg -> System.out.format("Média de alunos: %s\n", avg));
    }

}
