package com.igormaznitsa.forph;

public interface ForphSecurity {
  boolean canOperateTag(ForphEngine engine, ForphUser user, ForphPolyStackTag tag);

  boolean canCreateTag(ForphEngine engine, ForphUser user);

  boolean canOperateVocabulary(ForphEngine engine, ForphUser user, ForphVocabulary vocabulary);

  boolean canCreateVocabulary(ForphEngine engine, ForphUser user);

  boolean canSpawnRoutine(ForphEngine engine, ForphUser user);

  boolean canAccessRoutine(ForphEngine engine, ForphUser user, ForphRoutine routine);

  boolean canAccessWord(ForphEngine engine, ForphUser user, ForphWord word);

  boolean canCreateQueue(ForphEngine engine, ForphUser user);

  boolean canOperateQueue(ForphEngine engine, ForphUser user, ForphQueue queue);

  boolean canOperateAddress(ForphEngine engine, ForphUser user, ForphAddress address);
}
