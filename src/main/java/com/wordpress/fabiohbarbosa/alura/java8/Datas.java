package com.wordpress.fabiohbarbosa.alura.java8;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Datas {
    public static void main(String[] args) {
        LocalDate hoje = LocalDate.now();
        System.out.println(hoje);

        LocalDate olimpiadas = LocalDate.of(2018, Month.AUGUST, 8);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        olimpiadas.format(formatter);
        System.out.println(olimpiadas);

        final Period periodo = Period.between(hoje, olimpiadas);
        System.out.println(periodo.getDays());
    }
}
