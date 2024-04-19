package br.feevale.quadrado;

import java.util.ArrayList;
import java.util.List;

public class Linha extends ArrayList<Elemento> {
    public Linha(List<Elemento> elementos) {
        addAll(elementos);
    }
    public Linha() {

    }
}
