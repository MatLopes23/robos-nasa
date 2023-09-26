package com.mateuslopes.robosnasa.command;

import com.mateuslopes.robosnasa.model.PosicaoRobo;

public interface CommandHandler {
    void handleCommand(PosicaoRobo posicao, Character command);
}
