package br.feevale.quadrado;

import lombok.NoArgsConstructor;

import java.util.ArrayList;

@NoArgsConstructor
public class Linha extends ArrayList<Elemento> {

    @Override
    public Linha clone() {
        Linha linha = new Linha();
        this.forEach(elemento -> linha.add(elemento.clone()));
        return linha;
    }

    @Override
    public String toString() {
        StringBuilder texto = new StringBuilder();
        this.forEach(elemento -> {
            texto.append(elemento);
            texto.append(",");
        });
        return texto.toString();
    }
}
