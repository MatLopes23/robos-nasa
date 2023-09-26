package com.mateuslopes.robosnasa.model;

import com.mateuslopes.robosnasa.enums.OrientacaoEnum;
import com.mateuslopes.robosnasa.exception.RoboBadRequestException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PosicaoRoboTest {

    @Test
    public void testMoveNorth() {
        PosicaoRobo robo = new PosicaoRobo(0, 0, OrientacaoEnum.NORTH);
        robo.move();
        assertEquals(1, robo.getEixoY());
    }

    @Test
    public void testMoveSouth() {
        PosicaoRobo robo = new PosicaoRobo(1, 1, OrientacaoEnum.SOUTH);
        robo.move();
        assertEquals(0, robo.getEixoY());
    }

    @Test
    public void testMoveEast() {
        PosicaoRobo robo = new PosicaoRobo(0, 0, OrientacaoEnum.EAST);
        robo.move();
        assertEquals(1, robo.getEixoX());
    }

    @Test
    public void testMoveWest() {
        PosicaoRobo robo = new PosicaoRobo(1, 1, OrientacaoEnum.WEST);
        robo.move();
        assertEquals(0, robo.getEixoX());
    }

    @Test
    public void testRotacaoEsquerda() {
        PosicaoRobo robo = new PosicaoRobo(0, 0, OrientacaoEnum.NORTH);
        robo.rotacaoEsquerda();
        assertEquals(OrientacaoEnum.WEST, robo.getOrientacao());
    }

    @Test
    public void testRotacaoDireita() {
        PosicaoRobo robo = new PosicaoRobo(0, 0, OrientacaoEnum.NORTH);
        robo.rotacaoDireita();
        assertEquals(OrientacaoEnum.EAST, robo.getOrientacao());
    }

    @Test
    public void testMovimentoDentroDosLimites() {
        PosicaoRobo robo = new PosicaoRobo(2, 2, OrientacaoEnum.NORTH);
        robo.move();
        assertEquals(3, robo.getEixoY());
    }

    @Test
    public void testMovimentoForaDosLimites() {
        PosicaoRobo robo = new PosicaoRobo(0, 5, OrientacaoEnum.NORTH);

        assertThrows(RoboBadRequestException.class, () -> {
            robo.move();
        });
    }
}
