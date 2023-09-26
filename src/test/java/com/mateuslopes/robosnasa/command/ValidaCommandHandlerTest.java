package com.mateuslopes.robosnasa.command;

import com.mateuslopes.robosnasa.enums.CommandEnum;
import com.mateuslopes.robosnasa.enums.OrientacaoEnum;
import com.mateuslopes.robosnasa.exception.RoboBadRequestException;
import com.mateuslopes.robosnasa.model.PosicaoRobo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ValidaCommandHandlerTest {

    private CommandHandler handler;
    private PosicaoRobo posicao;

    @BeforeEach
    public void setUp() {
        handler = new ValidaCommandHandler();
        posicao = new PosicaoRobo(0, 0, OrientacaoEnum.NORTH);
    }

    @Test
    public void testHandleComandoValido() {
        Character comando = CommandEnum.MOVE.getValue();
        assertDoesNotThrow(() -> handler.handleCommand(posicao, comando));
    }

    @Test
    public void testHandleComandoInvalido() {
        Character comando = 'X';
        assertThrows(RoboBadRequestException.class, () -> handler.handleCommand(posicao, comando));
    }

    @Test
    public void testHandleListComandosValidos() {
        List<Character> comandosValidos = CommandEnum.getAllCommand();
        for (Character comando : comandosValidos) {
            assertDoesNotThrow(() -> handler.handleCommand(posicao, comando));
        }
    }

    @Test
    public void testHandleListComandosInvalidos() {
        Character[] comandosInvalidos = {'X', 'Y', 'Z'};
        for (Character comando : comandosInvalidos) {
            assertThrows(RoboBadRequestException.class, () -> handler.handleCommand(posicao, comando));
        }
    }
}
