package com.igormaznitsa.forph;

public class FrphEngine {

  private static final String[] BASE_TAGS = new String[] {"int", "float", "str"};
  private final FrphAccessSecurity accessSecurity;

  public FrphEngine() {
    this.accessSecurity = (x, y) -> true;
  }

  public FrphContext makeContext(final String contextId) {
    final FrphContext context = new FrphContext(contextId, this.accessSecurity, BASE_TAGS);
    return context;
  }

}
