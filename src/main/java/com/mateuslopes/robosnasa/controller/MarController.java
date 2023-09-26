package com.mateuslopes.robosnasa.controller;

import com.mateuslopes.robosnasa.command.CommandProcessor;
import com.mateuslopes.robosnasa.enums.OrientacaoEnum;
import com.mateuslopes.robosnasa.model.PosicaoRobo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/mars")
public class MarController {

    CommandProcessor commandProcessor;

    @Autowired
    public MarController(CommandProcessor commandProcessor) {
        this.commandProcessor = commandProcessor;
    }

    @PostMapping("/{comandos}")
    public String moveRobot(@PathVariable String comandos) {
        PosicaoRobo position = new PosicaoRobo(0, 0, OrientacaoEnum.NORTH);
        commandProcessor.execute(position, comandos);

        if(position.getRealizouMovimentoIrregular())
            return "falhou";

        return position.toString();

    }

    private boolean isValidPosition(PosicaoRobo position) {
        int x = position.getEixoX();
        int y = position.getEixoY();

        // Verificar se a posição está dentro dos limites (0 a 4 para x e y)
        return x >= 0 && x <= 4 && y >= 0 && y <= 4;
    }
}
