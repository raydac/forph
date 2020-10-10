package com.igormaznitsa.forph.engine.impl.engine;

import com.igormaznitsa.forph.api.engine.ForphEngine;
import com.igormaznitsa.forph.api.engine.ForphEngineStatus;
import com.igormaznitsa.forph.api.network.ForphAddress;
import com.igormaznitsa.forph.api.network.ForphEngineKey;
import com.igormaznitsa.forph.api.routines.ForphPipe;
import com.igormaznitsa.forph.api.routines.ForphRoutine;
import com.igormaznitsa.forph.api.security.ForphCredentials;
import com.igormaznitsa.forph.api.security.ForphSecurity;
import com.igormaznitsa.forph.api.stack.ForphPolyStackItem;
import com.igormaznitsa.forph.api.stack.ForphPolyStackTag;
import com.igormaznitsa.forph.api.vocabulary.ForphVocabulary;
import java.io.IOException;
import java.io.Reader;
import java.util.Optional;
import java.util.function.Predicate;

public class ForphEngineImpl implements ForphEngine {
  @Override
  public ForphEngineKey getKey() {
    return null;
  }

  @Override
  public Iterable<ForphAddress> allAddresses(ForphCredentials credentials) {
    return null;
  }

  @Override
  public Optional<ForphEngineStatus> findEngineStatus(ForphCredentials credentials,
                                                      ForphAddress address) {
    return Optional.empty();
  }

  @Override
  public ForphSecurity getSecurity() {
    return null;
  }

  @Override
  public ForphPolyStackTag makeTag(ForphCredentials credentials, String name,
                                   Predicate<ForphPolyStackItem> domainGuard) {
    return null;
  }

  @Override
  public ForphVocabulary newVocabulary(ForphCredentials credentials, String name) {
    return null;
  }

  @Override
  public ForphPipe makePipe(ForphCredentials credentials, String pipeId) {
    return null;
  }

  @Override
  public Optional<ForphAddress> findLocalAddress(ForphCredentials credentials) {
    return Optional.empty();
  }

  @Override
  public Iterable<ForphPipe> allPipes(ForphCredentials credentials) {
    return null;
  }

  @Override
  public Optional<ForphPipe> findPipe(ForphCredentials credentials, String pipeId) {
    return Optional.empty();
  }

  @Override
  public Optional<ForphVocabulary> findVocabulary(ForphCredentials credentials,
                                                  String vocabuleryId) {
    return Optional.empty();
  }

  @Override
  public Iterable<ForphVocabulary> allVocabularies(ForphCredentials credentials) {
    return null;
  }

  @Override
  public ForphRoutine prepareRoutine(ForphCredentials credentials, String routineId, Reader source)
      throws IOException {
    return null;
  }

  @Override
  public Iterable<ForphRoutine> allRoutines(ForphCredentials credentials,
                                            ForphAddress... addresses) {
    return null;
  }

  @Override
  public String getName() {
    return null;
  }

  @Override
  public ForphCredentials getCredentials() {
    return null;
  }

  @Override
  public void close() throws Exception {

  }
}
