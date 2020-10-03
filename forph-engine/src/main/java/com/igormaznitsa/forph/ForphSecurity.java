package com.igormaznitsa.forph;

public interface ForphSecurity {
  boolean canOperateStackTag(ForphEngine engine, ForphUser user, ForphPolyStackTag tag);

  boolean canAccessVocabulary(ForphEngine engine, ForphUser user, ForphVocabulary vocabulary);

  boolean canSpanRoutine(ForphEngine engine, ForphUser user);

  boolean canAccessWord(ForphEngine engine, ForphUser user, ForphWord word);

  boolean canCreateQueue(ForphEngine engine, ForphUser user);

  boolean canOperateQueue(ForphEngine engine, ForphUser user, ForphQueue queue);

  boolean canOperateAddress(ForphEngine engine, ForphUser user, ForphAddress address);
}
