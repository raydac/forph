package com.igormaznitsa.forph;

public class Forph {

  private static final String[] BASE_TAGS = new String[] {"int", "float", "str"};
  private final ForphAccessSecurity accessSecurity;

  public Forph() {
    this.accessSecurity = (x, y) -> true;
  }

  public ForphContext makeContext(final String contextId) {
    final ForphContext context = new ForphContext(contextId, this.accessSecurity, BASE_TAGS);
    return context;
  }

}
