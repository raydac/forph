package com.igormaznitsa.forph.exceptions;

import com.igormaznitsa.forph.ForphStack;

public class ForphStackException extends ForphException {
  private final ForphStack<?> causeStack;

  public ForphStackException(ForphStack<?> causeStack, String message) {
    super(causeStack.getContext(), message);
    this.causeStack = causeStack;
  }

  public ForphStack<?> getCauseStack() {
    return this.causeStack;
  }
}
