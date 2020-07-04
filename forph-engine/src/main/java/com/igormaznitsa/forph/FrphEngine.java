package com.igormaznitsa.forph;

import java.util.Objects;

public class FrphEngine {

  public static final FrphAccessSecurity NO_RESTRICTIONS = new FrphAccessSecurity() {
    @Override
    public boolean isAccessible(final FrphContext context, final FrphVocabulary vocabulary) {
      return true;
    }

    @Override
    public boolean isAllowed(final FrphContext context, int tag) {
      return true;
    }
  }

  private static final String[] BASE_TAGS = new String[] {
      "ptr",
      "int",
      "float",
      "str"
  };
  private final FrphAccessSecurity accessSecurity;

  public FrphEngine(final FrphAccessSecurity accessSecurity) {
    this.accessSecurity = Objects.requireNonNull(accessSecurity);
  }

  public FrphContext makeContext(final String contextId) {
    final FrphContext context = new FrphContext(contextId, this.accessSecurity, BASE_TAGS);
    return context;
  }

}
