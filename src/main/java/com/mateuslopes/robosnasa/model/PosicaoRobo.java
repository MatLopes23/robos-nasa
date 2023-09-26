package com.mateuslopes.robosnasa.model;

import com.mateuslopes.robosnasa.enums.OrientacaoEnum;
import lombok.Data;

@Data
public class PosicaoRobo {

    private static final Integer TAMANHO_EIXO_X = 5;
    private static final Integer TAMANHO_EIXO_Y = 5;

    private Integer eixoX;
    private Integer eixoY;
    private OrientacaoEnum orientacao;
    private Boolean realizouMovimentoIrregular;

    public PosicaoRobo(Integer eixoX, Integer eixoY, OrientacaoEnum orientacao) {
        this.eixoX = eixoX;
        this.eixoY = eixoY;
        this.orientacao = orientacao;
        this.realizouMovimentoIrregular = Boolean.FALSE;
    }

    public void move() {
        switch (orientacao) {
            case NORTH:
                eixoY++;
                break;
            case SOUTH:
                eixoY--;
                break;
            case EAST:
                eixoX++;
                break;
            case WEST:
                eixoX--;
                break;
        }
        verificaMovimentoValido();
    }

    public void rotacaoEsquerda() {
        int valor = orientacao.ordinal();
        int quantidadeOrientacao = OrientacaoEnum.values().length;
        int valorAnterior = (valor - 1 + quantidadeOrientacao) % quantidadeOrientacao;
        orientacao = OrientacaoEnum.getByOrdem(valorAnterior);
    }


    public void rotacaoDireita() {
        int valor = orientacao.ordinal();
        int quantidadeOrientacao = OrientacaoEnum.values().length;
        int valorProximo = (valor + 1) % quantidadeOrientacao;
        orientacao = OrientacaoEnum.getByOrdem(valorProximo);
    }

    private void verificaMovimentoValido() {
        if( eixoX < 0 || eixoX >= TAMANHO_EIXO_X || eixoY < 0 || eixoY >= TAMANHO_EIXO_Y )
            realizouMovimentoIrregular = true;
    }

    @Override
    public String toString() {
        return "(" + eixoX + ", " + eixoY + ", " + orientacao.getValue() + ")";
    }
}
