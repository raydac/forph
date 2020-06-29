package com.igormaznitsa.forph;

@FunctionalInterface
public interface ForphAccessSecurity {
  boolean isAccessible(ForphContext context, ForphVocabulary vocabulary);
}
