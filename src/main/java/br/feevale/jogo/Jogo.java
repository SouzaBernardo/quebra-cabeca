package br.feevale.jogo;

import br.feevale.quadrado.Quadrado;

import java.util.Scanner;

public class Jogo {
    public static void main(String[] args) {

        var input = new Scanner(System.in);
        System.out.print("Inicial: ");
        var inicial = input.nextLine();
        var quadrado = new Quadrado(inicial);
        quadrado.movimentar(0, 1);
    }
}
