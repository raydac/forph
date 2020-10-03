package com.igormaznitsa.forph;

import java.util.concurrent.CompletableFuture;

public interface ForphRoutine extends IdAware, ForphEngineAware, ForphUserAware {

  ForphAddress getAddress();

  ForphPolyStack getStack();

  CompletableFuture<ForphRoutine> getFuture();
}
