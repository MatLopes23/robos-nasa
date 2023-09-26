package com.mateuslopes.robosnasa.command;

import com.mateuslopes.robosnasa.enums.CommandEnum;
import com.mateuslopes.robosnasa.model.PosicaoRobo;

public class GirarDireitaHandler implements CommandHandler {
    @Override
    public void handleCommand(PosicaoRobo posicao, Character comando) {
        if (CommandEnum.RIGHT.getValue().equals(comando)) {
            posicao.rotacaoDireita();
        }
    }
}
