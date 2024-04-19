package br.feevale.quadrado;

import lombok.Getter;

import javax.swing.text.Utilities;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
public class Quadrado extends ArrayList<Linha> {

    public static final int TAMANHO_MAXIMO_LINHA = 3;
    public static final int TAMANHO_MAXIMO_COLUNA = 3;
    public static final int TAMANHO_MINIMO_LINHA = 0;
    public static final int TAMANHO_MINIMO_COLUNA = 0;
    public static final int GAP_DESLOCAMENTO = 1;
    public static final String VALOR_ELEMENTO_VAZIO = "0";

    private Elemento elemento;

    public Quadrado(String input) {
        String[] inputElements = input.split("");
        criarLinhas(inputElements);
    }

    private void criarLinhas(String[] inputElements) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            var linha = new Linha();
            for (int j = 0; j < 3; j++) {
                Elemento e = new Elemento(inputElements[count++], new Posicao(i, j));
                if (Objects.equals(e.getValor(), VALOR_ELEMENTO_VAZIO) && elemento == null) {
                    elemento = e;
                }
                linha.add(e);
            }
            add(linha);
        }
    }

    public void movimentar(int linha, int coluna) {
        var validas = getPosicoesValidas();
        var proxima = validas.stream()
                .filter(posicao -> posicao.getLinha() == linha && posicao.getColuna() == coluna)
                .findFirst();

        if (validas.isEmpty() || proxima.isEmpty()) {
            return;
        }

        mover(proxima.get());
    }

    private void mover(Posicao proximaPosicao) {
        Elemento elementoMovimentado = getElemento(proximaPosicao);
        Posicao posicaoAtual = elemento.getPosicao();
        Linha linhaAtual = get(posicaoAtual.getLinha());

        linhaAtual.remove(posicaoAtual.getColuna());
        linhaAtual.add(posicaoAtual.getColuna(), elementoMovimentado);

        Linha proximaLinha = get(proximaPosicao.getLinha());
        proximaLinha.remove(proximaPosicao.getColuna());
        proximaLinha.add(proximaPosicao.getColuna(), elemento);
        elementoMovimentado.setPosicao(elementoMovimentado.getPosicao());
        elemento.setPosicao(proximaPosicao);
    }

    private Elemento getElemento(Posicao posicao) {
        return get(posicao.getLinha()).get(posicao.getColuna());
    }

    private List<Posicao> getPosicoesValidas() {
        List<Posicao> posicoes = new ArrayList<>();
        int linhaElemento = elemento.getPosicao().getLinha();
        int colunaElemento = elemento.getPosicao().getColuna();

        int cima = linhaElemento - GAP_DESLOCAMENTO;
        int baixo = linhaElemento + GAP_DESLOCAMENTO;
        int direita = colunaElemento + GAP_DESLOCAMENTO;
        int esquerda = colunaElemento - GAP_DESLOCAMENTO;

        if (cima >= TAMANHO_MINIMO_LINHA)
            posicoes.add(get(cima).get(colunaElemento).getPosicao());
        if (baixo < TAMANHO_MAXIMO_LINHA)
            posicoes.add(get(baixo).get(colunaElemento).getPosicao());
        if (esquerda >= TAMANHO_MINIMO_COLUNA)
            posicoes.add(get(linhaElemento).get(esquerda).getPosicao());
        if (direita < TAMANHO_MAXIMO_COLUNA)
            posicoes.add(get(linhaElemento).get(direita).getPosicao());

        return posicoes;
    }
}
