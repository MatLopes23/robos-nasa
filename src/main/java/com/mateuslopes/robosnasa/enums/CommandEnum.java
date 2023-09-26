package com.mateuslopes.robosnasa.enums;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public enum CommandEnum {
    RIGHT('R'),
    LEFT('L'),
    MOVE('M');

    @Getter
    private final Character value;

    CommandEnum(Character value) {
        this.value = value;
    }

    public static List<Character> getAllCommand() {
        List<Character> commandChars = new ArrayList<>();
        for (CommandEnum command : values()) {
            commandChars.add(command.getValue());
        }
        return commandChars;
    }
}
