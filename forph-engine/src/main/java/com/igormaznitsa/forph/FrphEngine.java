package com.igormaznitsa.forph;

import java.util.Objects;

public class FrphEngine {

  public static final FrphAccessController NO_RESTRICTIONS = new FrphAccessController() {
    @Override
    public boolean isAccessible(final FrphContext context, final FrphVocabulary vocabulary) {
      return true;
    }

    @Override
    public boolean canAddTag(FrphContext context) {
      return true;
    }

    @Override
    public boolean isAllowed(final FrphContext context, int tag) {
      return true;
    }
  };

  private static final String[] BASE_TAGS = new String[] {
      "ptr",
      "int",
      "float",
      "str"
  };
  private final FrphAccessController accessController;

  public FrphEngine(final FrphAccessController accessController) {
    this.accessController = Objects.requireNonNull(accessController);
  }

  public FrphContext makeContext(final String contextId) {
    final FrphContext context = new FrphContext(contextId, this.accessController, BASE_TAGS);
    return context;
  }

}
