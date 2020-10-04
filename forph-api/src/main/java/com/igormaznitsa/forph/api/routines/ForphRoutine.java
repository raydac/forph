package com.igormaznitsa.forph.api.routines;

import com.igormaznitsa.forph.api.engine.ForphEngineAware;
import com.igormaznitsa.forph.api.network.Addressable;
import com.igormaznitsa.forph.api.others.IdAware;
import com.igormaznitsa.forph.api.security.WithCredentials;
import com.igormaznitsa.forph.api.stack.ForphPolyStack;
import java.util.concurrent.CompletableFuture;

public interface ForphRoutine extends Addressable, IdAware, ForphEngineAware, WithCredentials {

  ForphPolyStack getStack();

  CompletableFuture<ForphRoutine> getFuture();
}
