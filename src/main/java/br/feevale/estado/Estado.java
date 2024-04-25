package br.feevale.estado;

import br.feevale.quadrado.Quadrado;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Estado {
    private Quadrado atual;
    private List<Quadrado> possiveis;
}
