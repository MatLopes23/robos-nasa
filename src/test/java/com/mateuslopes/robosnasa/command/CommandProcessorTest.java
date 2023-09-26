package com.mateuslopes.robosnasa.command;

import com.mateuslopes.robosnasa.model.PosicaoRobo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class CommandProcessorTest {

    private CommandProcessor processor;
    private PosicaoRobo posicao;

    @BeforeEach
    public void setUp() {
        posicao = mock(PosicaoRobo.class);

        processor = new CommandProcessor();
    }

    @Test
    public void testExecute() {
        CommandHandler validHandler = mock(ValidaCommandHandler.class);
        CommandHandler leftHandler = mock(GirarEsquerdaHandler.class);
        CommandHandler rightHandler = mock(GirarDireitaHandler.class);
        CommandHandler moveHandler = mock(MoverHandler.class);

        processor.addCommandHandler(validHandler);
        processor.addCommandHandler(leftHandler);
        processor.addCommandHandler(rightHandler);
        processor.addCommandHandler(moveHandler);

        String comandos = "MLRMM";
        processor.execute(posicao, comandos);

        verify(validHandler, times(5)).handleCommand(eq(posicao), anyChar());
        verify(leftHandler, times(1)).handleCommand(eq(posicao), eq('L'));
        verify(rightHandler, times(1)).handleCommand(eq(posicao), eq('R'));
        verify(moveHandler, times(3)).handleCommand(eq(posicao), eq('M'));
    }

}
