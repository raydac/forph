package com.igormaznitsa.forph;

import java.util.concurrent.CompletableFuture;

public interface ForphRoutine extends ForphEngineAware, ForphUserAware {

  ForphAddress getAddress();

  String getName();

  ForphPolyStack getStack();

  CompletableFuture<ForphRoutine> getFuture();
}
