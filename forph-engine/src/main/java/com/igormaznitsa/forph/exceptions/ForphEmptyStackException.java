package com.igormaznitsa.forph.exceptions;

import com.igormaznitsa.forph.ForphStack;

public class ForphEmptyStackException extends ForphStackException {
    public ForphEmptyStackException(final ForphStack<?> causeStack) {
        super(causeStack, "Empty stack");
    }
}
