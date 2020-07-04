package com.igormaznitsa.forph;

public interface FrphAccessSecurity {
  boolean isAccessible(FrphContext context, FrphVocabulary vocabulary);

  boolean isAllowed(FrphContext context, int tag);
}
