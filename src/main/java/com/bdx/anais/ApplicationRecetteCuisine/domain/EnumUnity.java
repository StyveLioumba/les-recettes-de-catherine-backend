package com.bdx.anais.ApplicationRecetteCuisine.domain;

import java.util.Arrays;

public enum EnumUnity {
    CUILLERE_CAFE,
    CUILLERE_SOUPE,
    TRANCHE,
    AUCUNE,
    GOUSSE,
    SACHET,
    POIGNEE,
    G,
    KG,
    ML,
    CL,
    L;

    public static boolean isValid(String value) {
        return Arrays.stream(EnumUnity.values())
                .anyMatch(enumValue -> enumValue.name().equalsIgnoreCase(value));
    }
}
