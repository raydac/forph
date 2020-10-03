package com.igormaznitsa.forph.exceptions;

import com.igormaznitsa.forph.ForphEngine;

public class ForphStackException extends ForphEngineException {
  public ForphStackException(final ForphEngine engine, final String message) {
    super(engine, message);
  }
}
