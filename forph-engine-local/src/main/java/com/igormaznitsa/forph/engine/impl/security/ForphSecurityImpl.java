package com.igormaznitsa.forph.engine.impl.security;

import com.igormaznitsa.forph.api.engine.ForphEngine;
import com.igormaznitsa.forph.api.network.ForphAddress;
import com.igormaznitsa.forph.api.routines.ForphPipe;
import com.igormaznitsa.forph.api.routines.ForphRoutine;
import com.igormaznitsa.forph.api.security.ForphCredentials;
import com.igormaznitsa.forph.api.security.ForphSecurity;
import com.igormaznitsa.forph.api.stack.ForphPolyStackTag;
import com.igormaznitsa.forph.api.vocabulary.ForphVocabulary;
import com.igormaznitsa.forph.api.vocabulary.word.ForphWord;

public class ForphSecurityImpl implements ForphSecurity {
  @Override
  public boolean canOperateTag(
      final ForphEngine engine,
      final ForphCredentials credentials,
      final ForphPolyStackTag tag
  ) {
    return true;
  }

  @Override
  public boolean canCreateTag(final ForphEngine engine, final ForphCredentials credentials) {
    return true;
  }

  @Override
  public boolean canOperateVocabulary(ForphEngine engine, ForphCredentials credentials,
                                      ForphVocabulary vocabulary) {
    return true;
  }

  @Override
  public boolean canCreateVocabulary(final ForphEngine engine, final ForphCredentials credentials) {
    return true;
  }

  @Override
  public boolean canSpawnRoutine(
      final ForphEngine engine,
      final ForphCredentials credentials
  ) {
    return true;
  }

  @Override
  public boolean canReadVar(
      final ForphEngine engine,
      final ForphCredentials credentials,
      final String name) {
    return true;
  }

  @Override
  public boolean canWriteVar(
      final ForphEngine engine,
      final ForphCredentials credentials,
      final String name
  ) {
    return true;
  }

  @Override
  public boolean canAccessRoutine(
      final ForphEngine engine,
      final ForphCredentials credentials,
      final ForphRoutine routine) {
    return true;
  }

  @Override
  public boolean canCallWord(
      final ForphEngine engine,
      final ForphCredentials credentials,
      final ForphWord word
  ) {
    return true;
  }

  @Override
  public boolean canCreatePipe(
      final ForphEngine engine,
      final ForphCredentials credentials
  ) {
    return true;
  }

  @Override
  public boolean canOperatePipe(
      final ForphEngine engine,
      final ForphCredentials credentials,
      final ForphPipe pipe
  ) {
    return true;
  }

  @Override
  public boolean canOperateAddress(
      final ForphEngine engine,
      final ForphCredentials credentials,
      final ForphAddress address) {
    return true;
  }
}
