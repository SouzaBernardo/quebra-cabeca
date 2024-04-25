package br.feevale.quadrado;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Elemento {
    private final String valor;
    private Posicao posicao;
}
