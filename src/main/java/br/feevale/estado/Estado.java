package br.feevale.estado;

import br.feevale.quadrado.Quadrado;
import br.feevale.regra.EstadoRegras;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class Estado implements EstadoRegras {
    private Quadrado objetivo;
    private Quadrado atual;
    private List<Quadrado> possiveis;
    private List<Quadrado> antigos;


    public Estado(Quadrado objetivo, Quadrado atual) {
        this.objetivo = objetivo;
        this.atual = atual;
        this.possiveis = new ArrayList<>();
        this.antigos = new ArrayList<>();
        possiveis.addAll(atual.getEstadosPosiveis());
    }


    @Override
    public String toString() {
        StringBuilder estados = new StringBuilder();

        possiveis.forEach(quadrado -> {
            estados.append(quadrado.toString());
            estados.append("\n");
        });

        return estados.toString();
    }

    public void logarEstados() {
        // todo: spa nao vai precisar desse metodo aqui
    }

    public boolean encontrarObjetivo() {
        var naoEncontrado = true;
        while (naoEncontrado) {
            System.out.println(atual);
            var map = new HashMap<Long, Quadrado>();
            possiveis.forEach(quadrado -> {
                map.put(objetivo.comparar(quadrado), quadrado);
            });

            Long max = Collections.max(map.keySet());
            Quadrado novo = map.get(max);
            List<Quadrado> list = possiveis.stream().filter(quadrado -> quadrado != novo).toList();

            atualizarAntigos(list, map);
            atualizarAtual(novo);
            if (Objects.equals(atual.toString(), objetivo.toString())) {
                naoEncontrado = false;
            }
        }
        System.out.println(atual);
        return true;
    }

    private void atualizarAtual(Quadrado novo) {
        atual = novo; // vale so atualiza o novo quand otodos possiveis estados do atual estiver zerado?
        possiveis.clear(); // todo remover os que estao em antigos, logo, nao limpar tudo
        possiveis.addAll(atual.getEstadosPosiveis()); // continuar adionando os novos estados aqui
    }

    private void atualizarAntigos(List<Quadrado> list, HashMap<Long, Quadrado> map) {
        antigos.addAll(list);
        list.forEach(map::remove);
        antigos.add(atual);
    }
}
