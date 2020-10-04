package com.igormaznitsa.forph.api.exceptions;

import com.igormaznitsa.forph.api.engine.ForphEngine;
import com.igormaznitsa.forph.api.security.ForphCredentials;

public class ForphSecurityException extends ForphEngineException {

  private final ForphCredentials credentials;

  public ForphSecurityException(final ForphEngine engine,
                                final ForphCredentials credentials,
                                final String message) {
    super(engine, message);
    this.credentials = credentials;
  }
}
