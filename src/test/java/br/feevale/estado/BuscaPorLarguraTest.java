package br.feevale.estado;

import br.feevale.busca.BuscaPorLargura;
import br.feevale.quadrado.Quadrado;
import org.junit.jupiter.api.Test;

class BuscaPorLarguraTest {


    @Test
    public void deveBuscarPorLargura(){
        BuscaPorLargura buscaPorLargura = new BuscaPorLargura();

//        var quadrado = new Quadrado("123456708");
//        var objetivo = new Quadrado("123456780");

        var quadrado = new Quadrado("123456078");
        var objetivo = new Quadrado("203451786");

        buscaPorLargura.buscarLargura(quadrado,objetivo);

    }

}
