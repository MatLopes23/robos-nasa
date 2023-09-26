package com.mateuslopes.robosnasa.controller;

import com.mateuslopes.robosnasa.command.CommandProcessor;
import com.mateuslopes.robosnasa.enums.OrientacaoEnum;
import com.mateuslopes.robosnasa.exception.RoboBadRequestException;
import com.mateuslopes.robosnasa.model.PosicaoRobo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/mars")
public class MarController {

    private static final Logger logger = LoggerFactory.getLogger(MarController.class);

    CommandProcessor commandProcessor;

    @Autowired
    public MarController(CommandProcessor commandProcessor) {
        this.commandProcessor = commandProcessor;
    }

    @PostMapping("/{comandos}")
    public ResponseEntity<String> moveRobot(@PathVariable String comandos) {
        logger.info("Recebendo solicitação para mover o robô. Comandos: {}", comandos);

        PosicaoRobo position = new PosicaoRobo(0, 0, OrientacaoEnum.NORTH);

        try{
            commandProcessor.execute(position, comandos);

            logger.info("Movimento bem-sucedido. Posição: {}", position);
            return ResponseEntity.ok(position.toString());
        } catch (RoboBadRequestException e){
            logger.warn("Movimento irregular detectado. Comandos: {}", comandos);

            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            logger.error("Ocorreu um erro ao processar os comandos.", e);

            return ResponseEntity.badRequest().body("Erro ao processar os comandos: " + e.getMessage());
        }

    }

}
