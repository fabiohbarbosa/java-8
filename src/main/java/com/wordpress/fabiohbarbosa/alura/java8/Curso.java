package com.wordpress.fabiohbarbosa.alura.java8;

public class Curso {
    private String nome;
    private int alunos;
    private CursoType type;

    public Curso(String nome, int alunos, CursoType type) {
        this.nome = nome;
        this.alunos = alunos;
        this.type = type;
    }

    public String getNome() {
        return nome;
    }

    public int getAlunos() {
        return alunos;
    }

    public CursoType getType() {
        return type;
    }
}

enum CursoType {
    BACKEND, FRONTEND, FULLSTACK;
}