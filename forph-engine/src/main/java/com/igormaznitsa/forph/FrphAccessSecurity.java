package com.igormaznitsa.forph;

@FunctionalInterface
public interface FrphAccessSecurity {
  boolean isAccessible(FrphContext context, FrphVocabulary vocabulary);
}
