package com.mateuslopes.robosnasa.command;

import com.mateuslopes.robosnasa.enums.CommandEnum;
import com.mateuslopes.robosnasa.enums.OrientacaoEnum;
import com.mateuslopes.robosnasa.model.PosicaoRobo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GirarEsquerdaHandlerTest {

    private GirarEsquerdaHandler handler;
    private PosicaoRobo posicao;
    @BeforeEach
    public void setUp(){
        posicao = new PosicaoRobo(0, 0, OrientacaoEnum.NORTH);
        handler = new GirarEsquerdaHandler();
    }
    @Test
    public void testHandleComandoGirarEsquerda() {
        handler.handleCommand(posicao, CommandEnum.LEFT.getValue());
        assertEquals(OrientacaoEnum.WEST, posicao.getOrientacao());
    }

    @Test
    public void testHandleOutroComando() {
        handler.handleCommand(posicao, 'X');
        assertEquals(OrientacaoEnum.NORTH, posicao.getOrientacao());
    }
}
