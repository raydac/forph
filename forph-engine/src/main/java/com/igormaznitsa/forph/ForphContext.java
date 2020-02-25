package com.igormaznitsa.forph;

import java.util.ArrayList;
import java.util.Objects;

public class ForphContext {
    private final ForphStack<Integer> dataStack;
    private final ForphStack<Integer> returnStack;
    private final String name;

    public ForphContext(final String name) {
        this.name = Objects.requireNonNull(name);
        this.dataStack = new ForphStack<>(this, 0, "d", () -> new ArrayList<>(8));
        this.returnStack = new ForphStack<>(this, 0, "r", () -> new ArrayList<>(8));
    }

    public String getName() {
        return this.name;
    }
}
