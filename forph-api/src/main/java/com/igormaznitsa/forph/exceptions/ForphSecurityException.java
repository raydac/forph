package com.igormaznitsa.forph.exceptions;

import com.igormaznitsa.forph.ForphEngine;

public class ForphSecurityException extends ForphEngineException {
  public ForphSecurityException(final ForphEngine engine,
                                final String message) {
    super(engine, message);
  }
}
