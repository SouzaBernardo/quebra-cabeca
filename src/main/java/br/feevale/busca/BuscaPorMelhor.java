package br.feevale.busca;

import br.feevale.quadrado.Caminho;
import br.feevale.quadrado.Quadrado;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Boolean.TRUE;

@AllArgsConstructor
public class BuscaPorMelhor {
    private List<Quadrado> abertos;
    private List<Quadrado> fechados;
    private List<Quadrado> caminho;

    public List<Quadrado> buscarMelhor(Quadrado esperado) {
        while (!abertos.isEmpty()) {
            var x = abertos.getFirst();
            if (x.equals(esperado)) {
                return caminho;
            } else {
                caminho.add(x);
                var estadosPossiveis = x.getEstadosPosiveis();
                estadosPossiveis.forEach(estado -> {
                    if (Boolean.FALSE.equals(abertos.contains(estado)) || Boolean.FALSE.equals(fechados.contains(estado))) {
                        estado.valorHeuristico(esperado);
                        abertos.add(estado);
                    } else if (abertos.contains(estado)) {
                        refatoraCaminho(caminho, estado);
                    } else if (fechados.contains(estado)) {
                        if (caminho.contains(estado)) {
                            fechados.remove(estado);
                            abertos.add(estado);
                        }
                    }
                });
                fechados.add(x);
                abertos.removeAll(fechados);
                reordenar();
            }

        }
        throw new RuntimeException();
    }

    public void reordenar() {
        abertos.sort(Comparator.comparing(Quadrado::getValorHeuristico));
    }

    public void refatoraCaminho(List<Quadrado> caminho, Quadrado quadrado){
        int posicao = caminho.indexOf(quadrado);

        List<Quadrado> listaInvalida = caminho.subList(posicao, caminho.size()-1);

        caminho.removeAll(listaInvalida);
    }


}
