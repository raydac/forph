package com.igormaznitsa.forph.api.exceptions;

import com.igormaznitsa.forph.api.engine.ForphEngine;

public class ForphStackException extends ForphEngineException {
  public ForphStackException(final ForphEngine engine, final String message) {
    super(engine, message);
  }
}
