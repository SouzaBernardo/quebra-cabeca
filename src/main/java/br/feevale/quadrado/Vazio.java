package br.feevale.quadrado;

import lombok.Getter;

@Getter
public class Vazio {

    private int linha;
    private int coluna;

    public Vazio(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }
}
