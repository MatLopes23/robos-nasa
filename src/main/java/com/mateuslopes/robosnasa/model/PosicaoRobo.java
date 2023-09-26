package com.mateuslopes.robosnasa.model;

import com.mateuslopes.robosnasa.enums.OrientacaoEnum;
import lombok.Data;

@Data
public class PosicaoRobo {
    private int eixoX;
    private int eixoY;
    private OrientacaoEnum orientacao;


    public PosicaoRobo(int eixoX, int eixoY, OrientacaoEnum orientacao) {
        this.eixoX = eixoX;
        this.eixoY = eixoY;
        this.orientacao = orientacao;
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

    @Override
    public String toString() {
        return "(" + eixoX + ", " + eixoY + ", " + orientacao.getValue() + ")";
    }
}
