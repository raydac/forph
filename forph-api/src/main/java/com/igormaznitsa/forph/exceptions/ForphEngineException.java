package com.igormaznitsa.forph.exceptions;

import com.igormaznitsa.forph.ForphEngine;
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
