package com.igormaznitsa.forph.api.exceptions;

import com.igormaznitsa.forph.api.engine.ForphEngine;
import java.util.Objects;

public class ForphEngineException extends RuntimeException {
  private final ForphEngine engine;

  public ForphEngineException(final ForphEngine engine, final String message) {
    super(message);
    this.engine = Objects.requireNonNull(engine, "Engine must be provided");
  }

  public ForphEngine getEngine() {
    return this.engine;
  }

}
