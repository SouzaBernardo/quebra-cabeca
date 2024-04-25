package br.feevale.quadrado;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class QuadradoTest {

    private Quadrado quadrado;

    @Test
    public void deveAndarCorretamentePeloQuadrado() {
        quadrado = new Quadrado("123456708");

        /*
        * 1 2 3
        * 4 5 6
        * 7 0 8
        * */

        // movimenta p cima
        quadrado.movimentar(1, 1);
        Elemento elemento = quadrado.getElemento();
        Assertions.assertEquals("0", elemento.getValor());
        assertPossicao(1, 1, elemento);

        // movimenta pra cima
        quadrado.movimentar(0, 1);
        elemento = quadrado.getElemento();
        Assertions.assertEquals("0", elemento.getValor());
        assertPossicao(0, 1, elemento);

        // movimenta pra algo que n existe
        quadrado.movimentar(-1, 1);
        elemento = quadrado.getElemento();
        Assertions.assertEquals("0", elemento.getValor());
        assertPossicao(0, 1, elemento);

        // tenta pular casas
        quadrado.movimentar(2, 1);
        elemento = quadrado.getElemento();
        Assertions.assertEquals("0", elemento.getValor());
        assertPossicao(0, 1, elemento);
    }

    private static void assertPossicao(int linhaEsperada, int colunaEsperada, Elemento elemento) {
        Assertions.assertEquals(linhaEsperada, elemento.getPosicao().getLinha());
        Assertions.assertEquals(colunaEsperada, elemento.getPosicao().getColuna());
    }

}