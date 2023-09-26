package com.mateuslopes.robosnasa.command;

import com.mateuslopes.robosnasa.enums.CommandEnum;
import com.mateuslopes.robosnasa.model.PosicaoRobo;

public class GirarEsquerdaHandler implements CommandHandler {
    @Override
    public void handleCommand(PosicaoRobo posicao, Character comando) {
        if (CommandEnum.LEFT.getValue().equals(comando)) {
            posicao.rotacaoEsquerda();
        }
    }
}
