package br.feevale.estado;

import br.feevale.busca.BuscaPorMelhor;
import br.feevale.quadrado.Quadrado;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class BuscarMelhorTest {
    @Test
    public void encontrarMelhor() {

        var quadrado = new Quadrado("123456780");
        var objetivo = new Quadrado("123456708");

        ArrayList<Quadrado> abertos = new ArrayList<>();
        abertos.add(quadrado);
        var buscaPorMelhor = new BuscaPorMelhor(abertos, new ArrayList<>());
        var responta = buscaPorMelhor.buscarMelhor(objetivo);

        System.out.println(responta);
    }
}
