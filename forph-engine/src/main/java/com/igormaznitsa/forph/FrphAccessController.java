package com.igormaznitsa.forph;

public interface FrphAccessController {
  boolean isAccessible(FrphContext context, FrphVocabulary vocabulary);

  boolean isAllowed(FrphContext context, int tag);

  boolean canAddTag(FrphContext context);
}
