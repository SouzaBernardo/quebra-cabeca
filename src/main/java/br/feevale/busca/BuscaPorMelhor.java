package br.feevale.busca;

import br.feevale.quadrado.Quadrado;
import lombok.AllArgsConstructor;

import java.util.Comparator;
import java.util.List;

import static java.lang.Boolean.TRUE;

@AllArgsConstructor
public class BuscaPorMelhor {
    private List<Quadrado> abertos;
    private List<Quadrado> fechados;

    public List<Quadrado> buscarMelhor(Quadrado esperado) {
        while (!abertos.isEmpty()) {
            var x = abertos.getFirst();
            if (x.equals(esperado)) { // todo: equals funciona?
                return fechados;
            } else {
                var estadosPossiveis = x.getEstadosPosiveis();
                estadosPossiveis.forEach(estado -> {
                    if (!abertos.contains(estado) || !fechados.contains(estado)) {
                        estado.valorHeuristico(esperado);
                        abertos.add(estado);
                    } else if (abertos.contains(estado)) {
                        // refatorar o caminho
                    } else if (fechados.contains(estado)) {
                        if (true /*se o filho foi alcancado por um caminho mais curto*/) {
                            fechados.remove(estado);
                            abertos.add(estado);
                        }
                    }
                });
                fechados.add(x);
                reordenar();
            }
        }
        return null;
    }

    public void reordenar() {
        abertos.sort(Comparator.comparing(Quadrado::getValorHeuristico).reversed());
    }



}
