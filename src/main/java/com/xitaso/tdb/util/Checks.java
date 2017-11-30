package com.xitaso.tdb.util;

import java.util.Objects;

public final class Checks {
    private Checks() {
    }

    public static String nonEmpty(String s) {
        final String string = Objects.requireNonNull(s);
        if (string.isEmpty()) {
            throw new IllegalArgumentException("Argument may not be empty");
        }
        return string;
    }
}
