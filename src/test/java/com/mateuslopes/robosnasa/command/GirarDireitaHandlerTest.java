package com.mateuslopes.robosnasa.command;

import com.mateuslopes.robosnasa.enums.CommandEnum;
import com.mateuslopes.robosnasa.enums.OrientacaoEnum;
import com.mateuslopes.robosnasa.model.PosicaoRobo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GirarDireitaHandlerTest {


    private GirarDireitaHandler handler;
    private PosicaoRobo posicao;
    @BeforeEach
    public void setUp(){
        posicao = new PosicaoRobo(0, 0, OrientacaoEnum.NORTH);
        handler = new GirarDireitaHandler();
    }
    @Test
    public void testHandleComandoGirarDireita() {
        handler.handleCommand(posicao, CommandEnum.RIGHT.getValue());
        assertEquals(OrientacaoEnum.EAST, posicao.getOrientacao());
    }

    @Test
    public void testHandleOutroComando() {
        handler.handleCommand(posicao, 'X');
        assertEquals(OrientacaoEnum.NORTH, posicao.getOrientacao());
    }
}
