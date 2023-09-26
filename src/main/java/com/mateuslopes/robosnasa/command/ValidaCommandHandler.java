package com.mateuslopes.robosnasa.command;

import com.mateuslopes.robosnasa.enums.CommandEnum;
import com.mateuslopes.robosnasa.exception.RoboBadRequestException;
import com.mateuslopes.robosnasa.model.PosicaoRobo;

import java.util.List;

public class ValidaCommandHandler implements CommandHandler {
    @Override
    public void handleCommand(PosicaoRobo posicao, Character comando) {
        List<Character> comandosValidos = CommandEnum.getAllCommand();

        if (!comandosValidos.contains(comando)) {
            throw new RoboBadRequestException("Comando inválido identificado.");
        }
    }
}
