package com.mateuslopes.robosnasa.enums;

import lombok.Getter;

public enum CommandEnum {
    RIGHT('R'),
    LEFT('L'),
    MOVE('M');

    @Getter
    private final Character value;

    CommandEnum(Character value) {
        this.value = value;
    }

}
