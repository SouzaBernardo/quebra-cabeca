package br.feevale.quadrado;

import br.feevale.regra.Regras;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
public class Quadrado extends ArrayList<Linha> implements Regras {

    public static final int TAMANHO_MAXIMO_LINHA = 3;
    public static final int TAMANHO_MAXIMO_COLUNA = 3;
    public static final int TAMANHO_MINIMO_LINHA = 0;
    public static final int TAMANHO_MINIMO_COLUNA = 0;
    public static final int GAP_DESLOCAMENTO = 1;
    public static final String VALOR_ELEMENTO_VAZIO = "0";

    private Elemento elemento;

    public Quadrado(String input) {
        var inputElements = input.split("");
        criarLinhas(inputElements);
    }

    private void criarLinhas(String[] inputElements) {
        var count = 0;
        for (int l = 0; l < 3; l++) {
            var linha = new Linha();
            for (int c = 0; c < 3; c++) {
                var elemento = new Elemento(inputElements[count++], new Posicao(l, c));
                if (Objects.equals(elemento.getValor(), VALOR_ELEMENTO_VAZIO) && this.elemento == null) {
                    this.elemento = elemento;
                }
                linha.add(elemento);
            }
            add(linha);
        }
    }

    public void movimentar(int linha, int coluna) {
        var validas = getPosicoesValidas();
        var proxima = validas.stream()
                .filter(posicao -> posicao.getLinha() == linha && posicao.getColuna() == coluna)
                .findFirst();

        if (validas.isEmpty() || proxima.isEmpty()) return;

        mover(proxima.get());
    }

    private void mover(Posicao proximaPosicao) {
        var elementoMovimentado = getElemento(proximaPosicao);
        var posicaoAtual = elemento.getPosicao();

        var linhaAtual = get(posicaoAtual.getLinha());
        linhaAtual.remove(posicaoAtual.getColuna());
        linhaAtual.add(posicaoAtual.getColuna(), elementoMovimentado);

        var proximaLinha = get(proximaPosicao.getLinha());
        proximaLinha.remove(proximaPosicao.getColuna());
        proximaLinha.add(proximaPosicao.getColuna(), elemento);

        elementoMovimentado.setPosicao(elemento.getPosicao());
        elemento.setPosicao(proximaPosicao);
    }

    private Elemento getElemento(Posicao posicao) {
        return get(posicao.getLinha()).get(posicao.getColuna());
    }

    private List<Posicao> getPosicoesValidas() {
        var posicoes = new ArrayList<Posicao>();
        var linhaElemento = elemento.getPosicao().getLinha();
        var colunaElemento = elemento.getPosicao().getColuna();

        var cima = linhaElemento - GAP_DESLOCAMENTO;
        var baixo = linhaElemento + GAP_DESLOCAMENTO;
        var direita = colunaElemento + GAP_DESLOCAMENTO;
        var esquerda = colunaElemento - GAP_DESLOCAMENTO;

        if (cima >= TAMANHO_MINIMO_LINHA) posicoes.add(get(cima).get(colunaElemento).getPosicao());
        if (baixo < TAMANHO_MAXIMO_LINHA) posicoes.add(get(baixo).get(colunaElemento).getPosicao());
        if (esquerda >= TAMANHO_MINIMO_COLUNA) posicoes.add(get(linhaElemento).get(esquerda).getPosicao());
        if (direita < TAMANHO_MAXIMO_COLUNA) posicoes.add(get(linhaElemento).get(direita).getPosicao());

        return posicoes;
    }
}
