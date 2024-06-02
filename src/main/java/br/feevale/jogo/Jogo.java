package br.feevale.jogo;

import br.feevale.quadrado.Quadrado;

import java.util.Scanner;

public class Jogo {
    public static void main(String[] args) {

        var input = new Scanner(System.in);
        System.out.print("Inicial: ");
        var inicial = input.nextLine();
        var quadrado = new Quadrado(inicial);
        while (true) {

            System.out.println(quadrado.getEstadosPosiveis());

            System.out.println("Linha: ");
            var linha = input.nextInt();
            System.out.println("Coluna: ");
            var coluna = input.nextInt();
            quadrado.movimentar(linha, coluna);

            if (linha == -1 || coluna == -1) {
                return;
            }

            System.out.println(quadrado);
        }

    }
}
