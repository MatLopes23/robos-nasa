package com.mateuslopes.robosnasa.command;

import static org.junit.jupiter.api.Assertions.*;

import com.mateuslopes.robosnasa.enums.CommandEnum;
import com.mateuslopes.robosnasa.enums.OrientacaoEnum;
import com.mateuslopes.robosnasa.model.PosicaoRobo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MoverHandlerTest {

    private CommandHandler handler;

    @BeforeEach
    public void setUp() {
        handler = new MoverHandler();
    }

    @Test
    public void testHandleMoveComandoNorth() {
        PosicaoRobo posicao = new PosicaoRobo(0, 0, OrientacaoEnum.NORTH);

        handler.handleCommand(posicao, CommandEnum.MOVE.getValue());

        assertEquals(1, posicao.getEixoY());
    }

    @Test
    public void testHandleMoveComandoSouth() {
        PosicaoRobo posicao = new PosicaoRobo(1, 1, OrientacaoEnum.SOUTH);

        handler.handleCommand(posicao, CommandEnum.MOVE.getValue());

        assertEquals(0, posicao.getEixoY());
    }

    @Test
    public void testHandleMoveComandoEast() {
        PosicaoRobo posicao = new PosicaoRobo(0, 0, OrientacaoEnum.EAST);

        handler.handleCommand(posicao, CommandEnum.MOVE.getValue());

        assertEquals(1, posicao.getEixoX());
    }

    @Test
    public void testHandleMoveComandoWest() {
        PosicaoRobo posicao = new PosicaoRobo(1, 1, OrientacaoEnum.WEST);

        handler.handleCommand(posicao, CommandEnum.MOVE.getValue());

        assertEquals(0, posicao.getEixoX());
    }

    @Test
    public void testHandleComandoRotacionar() {
        PosicaoRobo posicao = new PosicaoRobo(0, 0, OrientacaoEnum.NORTH);

        handler.handleCommand(posicao, CommandEnum.RIGHT.getValue());

        assertEquals(0, posicao.getEixoX());
        assertEquals(0, posicao.getEixoY());
    }
}
