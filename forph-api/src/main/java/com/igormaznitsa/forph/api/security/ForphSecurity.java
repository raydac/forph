package com.igormaznitsa.forph.api.security;

import com.igormaznitsa.forph.api.engine.ForphEngine;
import com.igormaznitsa.forph.api.network.ForphAddress;
import com.igormaznitsa.forph.api.routines.ForphPipe;
import com.igormaznitsa.forph.api.routines.ForphRoutine;
import com.igormaznitsa.forph.api.stack.ForphPolyStackTag;
import com.igormaznitsa.forph.api.vocabulary.ForphVocabulary;
import com.igormaznitsa.forph.api.vocabulary.word.ForphWord;

public interface ForphSecurity {
  boolean canOperateTag(ForphEngine engine, ForphCredentials credentials, ForphPolyStackTag tag);

  boolean canCreateTag(ForphEngine engine, ForphCredentials credentials);

  boolean canOperateVocabulary(
      ForphEngine engine,
      ForphCredentials credentials,
      ForphVocabulary vocabulary
  );

  boolean canCreateVocabulary(ForphEngine engine, ForphCredentials credentials);

  boolean canSpawnRoutine(ForphEngine engine, ForphCredentials credentials);

  boolean canReadVar(ForphEngine engine, ForphCredentials credentials, String name);

  boolean canWriteVar(ForphEngine engine, ForphCredentials credentials, String name);

  boolean canAccessRoutine(
      ForphEngine engine,
      ForphCredentials credentials,
      ForphRoutine routine
  );

  boolean canCallWord(
      ForphEngine engine,
      ForphCredentials credentials,
      ForphWord word
  );

  boolean canCreatePipe(ForphEngine engine, ForphCredentials credentials);

  boolean canOperatePipe(ForphEngine engine, ForphCredentials credentials, ForphPipe pipe);

  boolean canOperateAddress(
      ForphEngine engine,
      ForphCredentials credentials,
      ForphAddress address
  );
}
