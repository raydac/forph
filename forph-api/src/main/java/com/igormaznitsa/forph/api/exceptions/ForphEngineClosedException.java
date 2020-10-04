package com.igormaznitsa.forph.api.exceptions;

import com.igormaznitsa.forph.api.engine.ForphEngine;

public class ForphEngineClosedException extends ForphEngineException {
  public ForphEngineClosedException(final ForphEngine engine) {
    super(engine, "Engine is closed");
  }
}
