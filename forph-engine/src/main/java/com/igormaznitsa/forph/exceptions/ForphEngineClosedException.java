package com.igormaznitsa.forph.exceptions;

import com.igormaznitsa.forph.ForphEngine;

public class ForphEngineClosedException extends ForphEngineException {
  public ForphEngineClosedException(final ForphEngine engine) {
    super(engine, "Engine is closed");
  }
}
