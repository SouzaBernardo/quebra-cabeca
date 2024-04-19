package br.feevale.quadrado;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class QuadradoTest {

    private Quadrado quadrado;

    @ParameterizedTest
    @ValueSource(strings = {"123456708"})
    public void a(String input) {
        quadrado = new Quadrado(input);

        /*
        * 1 2 3 - 0
        * 4 5 6 - 1
        * 7 0 8 - 2
        * */
        quadrado.movimentar(1, 1);
        Elemento elemento = quadrado.getElemento();
        Assertions.assertEquals("0", elemento.getValor());
        Assertions.assertEquals(1, elemento.getPosicao().getLinha());
        Assertions.assertEquals(1, elemento.getPosicao().getColuna());

        quadrado.movimentar(0, 1);
        elemento = quadrado.getElemento();
        Assertions.assertEquals("0", elemento.getValor());
        Assertions.assertEquals(0, elemento.getPosicao().getLinha());
        Assertions.assertEquals(1, elemento.getPosicao().getColuna());
    }

}