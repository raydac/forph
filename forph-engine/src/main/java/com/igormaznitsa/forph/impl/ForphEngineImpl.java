package com.igormaznitsa.forph.impl;

import com.igormaznitsa.forph.ForphAddress;
import com.igormaznitsa.forph.ForphEngine;
import com.igormaznitsa.forph.ForphQueue;
import com.igormaznitsa.forph.ForphRoutine;
import com.igormaznitsa.forph.ForphSecurity;
import com.igormaznitsa.forph.ForphUser;
import com.igormaznitsa.forph.ForphVocabulary;
import com.igormaznitsa.forph.exceptions.ForphEngineClosedException;
import com.igormaznitsa.forph.exceptions.ForphEngineException;
import java.io.IOException;
import java.io.Reader;
import java.util.Collections;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

public class ForphEngineImpl implements ForphEngine {
  private final String id;
  private final ForphSecurity security;
  private final AtomicBoolean closed = new AtomicBoolean();
  private final ForphUser rootUser;

  public ForphEngineImpl(final ForphSecurity security, final ForphUser rootUser,
                         final String id) {
    this.security = Objects.requireNonNull(security, "SECURITY must be provided");
    this.id = Objects.requireNonNull(id, "ID must be provided");
    this.rootUser = Objects.requireNonNull(rootUser, "ROOT USER must be provided");
  }

  @Override
  public ForphSecurity getSecurity(final ForphUser user) {
    return this.security;
  }

  @Override
  public Optional<ForphAddress> findLocalAddress(ForphUser user) {
    return Optional.empty();
  }

  @Override
  public String getId() {
    return this.id;
  }

  @Override
  public Iterable<ForphAddress> findAddresses(ForphUser user) {
    return Collections.emptyList();
  }

  @Override
  public Iterable<ForphVocabulary> findVocabularies(ForphUser user) {
    return Collections.emptyList();
  }

  @Override
  public Iterable<ForphRoutine> findRoutines(ForphUser user) {
    return Collections.emptyList();
  }

  @Override
  public Optional<ForphQueue> findQueue(final ForphUser user, final String queueId) {
    return Optional.empty();
  }

  @Override
  public ForphUser getUser() {
    return this.rootUser;
  }

  @Override
  public ForphRoutine spawn(ForphUser user, String id, Reader source) throws IOException {
    return null;
  }

  @Override
  public void close() throws ForphEngineException {
    if (this.closed.compareAndSet(false, true)) {

    } else {
      throw new ForphEngineClosedException(this);
    }
  }

  private void assertNonClosed() {
    if (this.closed.get()) {
      throw new ForphEngineClosedException(this);
    }
  }

}
