package br.feevale.busca;

import br.feevale.quadrado.Quadrado;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class BuscaPorLargura {
    private List<Quadrado> abertos = new ArrayList<>();
    private List<Quadrado> fechados =  new ArrayList<>();


    public void buscarLargura(Quadrado inicial, Quadrado objetivo){
        abertos.add(inicial);
        AtomicReference<Boolean> continuar = new AtomicReference<>(Boolean.TRUE);
        while(continuar.get()){
            ArrayList<Quadrado> proxAbertos = new ArrayList<>();
            abertos.forEach(estado -> {
                System.out.println(estado);
                if(estado.equals(objetivo)) {
                    continuar.set(Boolean.FALSE);
                    return;
                }
                proxAbertos.addAll(estado.getEstadosPosiveis());
            });

            fechados.addAll(abertos);
            abertos.clear();
            abertos.addAll(proxAbertos);
            abertos.removeAll(fechados);
        }
    }
}
