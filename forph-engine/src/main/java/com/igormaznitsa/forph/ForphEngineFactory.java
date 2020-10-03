package com.igormaznitsa.forph;

public final class ForphEngineFactory {

  private static final ForphEngineFactory INSTANCE = new ForphEngineFactory();

  private ForphEngineFactory() {

  }

  public static ForphEngineFactory getInstance(ForphSecurity security) {
    return INSTANCE;
  }

  public ForphEngine makeEngine(final ForphUser rootUser, final String engineId) {
    return null;
  }
}
