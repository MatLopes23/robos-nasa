package com.mateuslopes.robosnasa.command;

import com.mateuslopes.robosnasa.model.PosicaoRobo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommandProcessor {
    private final List<CommandHandler> handlers;

    public CommandProcessor() {
        handlers = new ArrayList<>();
        handlers.add(new ValidaCommandHandler());
        handlers.add(new GirarEsquerdaHandler());
        handlers.add(new GirarDireitaHandler());
        handlers.add(new MoverHandler());
    }

    public void execute(PosicaoRobo posicao, String comandos) {
        for (char comando : comandos.toCharArray()) {
            for (CommandHandler handler : handlers) {
                handler.handleCommand(posicao, comando);
            }
        }
    }
}
