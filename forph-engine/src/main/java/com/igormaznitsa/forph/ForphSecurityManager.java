package com.igormaznitsa.forph;

import com.igormaznitsa.forph.security.ForphAccessLevel;

public interface ForphSecurityManager {
  boolean isAccessible(ForphAccessLevel level, ForphStack<?> stack);

  boolean isAccessible(ForphAccessLevel level, ForphVocabulary vocabulary);
}
