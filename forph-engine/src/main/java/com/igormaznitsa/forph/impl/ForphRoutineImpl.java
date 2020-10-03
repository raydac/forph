package com.igormaznitsa.forph.impl;

import com.igormaznitsa.forph.ForphAddress;
import com.igormaznitsa.forph.ForphEngine;
import com.igormaznitsa.forph.ForphPolyStack;
import com.igormaznitsa.forph.ForphRoutine;
import com.igormaznitsa.forph.ForphUser;
import java.util.concurrent.CompletableFuture;

class ForphRoutineImpl implements ForphRoutine {

  private final ForphEngineImpl engine;
  private final ForphUser user;
  private final String name;
  private final ForphPolyStackImpl stack;

  ForphRoutineImpl(final String name, final ForphEngineImpl engine, final ForphUser user) {
    this.name = name;
    this.engine = engine;
    this.user = user;
    this.stack = new ForphPolyStackImpl(this);
  }

  @Override
  public ForphAddress getAddress() {
    return null;
  }

  @Override
  public ForphUser getUser() {
    return this.user;
  }

  @Override
  public ForphEngine getEngine() {
    return this.engine;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public ForphPolyStack getStack() {
    return this.stack;
  }

  @Override
  public CompletableFuture<ForphRoutine> getFuture() {
    return null;
  }
}
