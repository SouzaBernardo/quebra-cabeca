package br.feevale.estado;

import br.feevale.busca.BuscaPorMelhor;
import br.feevale.quadrado.Quadrado;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class BuscarMelhorTest {
    @Test
    public void encontrarMelhor() {

        var quadrado = new Quadrado("210834756");
        var objetivo = new Quadrado("123804765");

        ArrayList<Quadrado> abertos = new ArrayList<>();
        abertos.add(quadrado);
        var buscaPorMelhor = new BuscaPorMelhor(abertos, new ArrayList<>());
        var responta = buscaPorMelhor.buscarMelhor(objetivo);

        System.out.println(responta);
    }

    @Test
    public void valorHeuristica(){
        var quadrado = new Quadrado("012783654");
        var objetivo = new Quadrado("123804765");

        //012
        //783
        //654

        //123
        //804
        //765
        System.out.println(quadrado.valorHeuristicaPorPosicao(objetivo, 0, 0));
        System.out.println(quadrado.valorHeuristicaPorPosicao(objetivo, 0, 1));
        System.out.println(quadrado.valorHeuristicaPorPosicao(objetivo, 0, 2));
        System.out.println(quadrado.valorHeuristicaPorPosicao(objetivo, 1, 0));
        System.out.println(quadrado.valorHeuristicaPorPosicao(objetivo, 1, 1));
        System.out.println(quadrado.valorHeuristicaPorPosicao(objetivo, 1, 2));
        System.out.println(quadrado.valorHeuristicaPorPosicao(objetivo, 2, 0));
        System.out.println(quadrado.valorHeuristicaPorPosicao(objetivo, 2, 1));
        System.out.println(quadrado.valorHeuristicaPorPosicao(objetivo, 2, 2));




    }
}
