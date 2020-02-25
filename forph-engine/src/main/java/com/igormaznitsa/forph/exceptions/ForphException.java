package com.igormaznitsa.forph.exceptions;

import com.igormaznitsa.forph.ForphContext;

public class ForphException extends RuntimeException {
  private final ForphContext context;

  public ForphException(ForphContext context, String message) {
    this(context, message, null);
  }

  public ForphException(ForphContext context, String message, Throwable cause) {
    super(message, cause);
    this.context = context;
  }

  public ForphContext getContext() {
    return this.context;
  }

}
