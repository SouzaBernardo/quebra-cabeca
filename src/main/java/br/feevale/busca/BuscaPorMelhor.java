package br.feevale.busca;

import br.feevale.quadrado.Quadrado;
import lombok.AllArgsConstructor;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Boolean.TRUE;

@AllArgsConstructor
public class BuscaPorMelhor {
    private List<Quadrado> abertos;
    private List<Quadrado> fechados;

    public List<Quadrado> buscarMelhor(Quadrado esperado) {
        while (!abertos.isEmpty()) {
            var x = abertos.getFirst();
            System.out.println(x);
            if (x.equals(esperado)) {
                return fechados;
            } else {
                var estadosPossiveis = x.getEstadosPosiveis();
                estadosPossiveis.forEach(estado -> {
                    if (Boolean.FALSE.equals(abertos.contains(estado)) || Boolean.FALSE.equals(fechados.contains(estado))) {
                        estado.valorHeuristico(esperado);
                        abertos.add(estado);
                    } else if (abertos.contains(estado)) {
                        // refatorar o caminho
//                        fechados.add(estado);
                    } else if (fechados.contains(estado)) {
                        if (false /*se o filho foi alcancado por um caminho mais curto*/) {
                            fechados.remove(estado);
                            abertos.add(estado);
                        }
                    }
                });
                fechados.add(x);
                abertos = abertos.stream()
                        .filter(it -> fechados.stream().noneMatch(it::equals))
                        .collect(Collectors.toList());;
                reordenar();
            }

        }
        return null;
    }

    public void reordenar() {
        abertos.sort(Comparator.comparing(Quadrado::getValorHeuristico));
    }



}
