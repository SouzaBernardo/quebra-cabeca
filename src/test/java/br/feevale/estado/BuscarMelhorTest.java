package br.feevale.estado;

import br.feevale.busca.BuscaPorMelhor;
import br.feevale.quadrado.Quadrado;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class BuscarMelhorTest {
    @Test
    public void encontrarMelhor() {

//        var quadrado = new Quadrado("123456708");
//        var objetivo = new Quadrado("123456780");

        var quadrado = new Quadrado("123456078");
        var objetivo = new Quadrado("203451786");

        ArrayList<Quadrado> abertos = new ArrayList<>();
        abertos.add(quadrado);
        var buscaPorMelhor = new BuscaPorMelhor(abertos, new ArrayList<>(), new ArrayList<>());
        var responta = buscaPorMelhor.buscarMelhor(objetivo);

        responta.forEach(it -> System.out.println(it.toString()));
    }

    @Test
    public void valorHeuristica(){
        var quadrado = new Quadrado("213804756");
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

    @Test
    public void refatoraCaminho(){
        var quadradoA = new Quadrado("012783654");
        var quadradoB = new Quadrado("123804767");
        var quadradoC = new Quadrado("123804765");

        ArrayList arrayList = new ArrayList();
        arrayList.add(quadradoA);
        arrayList.add(quadradoB);
        arrayList.add(quadradoC);

        var quadradoD = new Quadrado("123804767");

        var buscaPorMelhor = new BuscaPorMelhor(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());


        System.out.println(arrayList.get(3));
    }
}
