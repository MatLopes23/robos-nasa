package com.mateuslopes.robosnasa.controller;

import com.mateuslopes.robosnasa.command.CommandProcessor;
import com.mateuslopes.robosnasa.enums.OrientacaoEnum;
import com.mateuslopes.robosnasa.model.PosicaoRobo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> moveRobot(@PathVariable String comandos) {
        PosicaoRobo position = new PosicaoRobo(0, 0, OrientacaoEnum.NORTH);
        commandProcessor.execute(position, comandos);

        if(position.getRealizouMovimentoIrregular())
            return ResponseEntity.badRequest().body("Erro ao processar os comandos.");

        return ResponseEntity.ok(position.toString());

    }

}
