package br.feevale.regra;

import br.feevale.quadrado.Quadrado;

import java.util.List;

public interface QuadradoRegras {

    void movimentar(int linha, int coluna);
    List<Quadrado> getEstadosPosiveis();
}
