package com.mateuslopes.robosnasa.enums;

import lombok.Getter;

public enum OrientacaoEnum {
    NORTH('N', 0),
    EAST('E', 1),
    SOUTH('S', 2),
    WEST('W', 3);

    @Getter
    private final Character value;
    @Getter
    private final Integer ordem;

    OrientacaoEnum(Character value, Integer ordem) {
        this.value = value;
        this.ordem = ordem;
    }

    public static OrientacaoEnum getByOrdem(int ordem) {
        for (OrientacaoEnum orientacao : OrientacaoEnum.values()) {
            if (orientacao.getOrdem() == ordem) {
                return orientacao;
            }
        }
        throw new IllegalArgumentException("Ordem inválida: " + ordem);
    }
}