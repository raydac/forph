package com.igormaznitsa.forph.exceptions;

import com.igormaznitsa.forph.ForphStack;

public class ForphNotEnoughElementsOnStackException extends ForphStackException {
  public ForphNotEnoughElementsOnStackException(final ForphStack<?> causeStack, String message) {
    super(causeStack, message);
  }
}
