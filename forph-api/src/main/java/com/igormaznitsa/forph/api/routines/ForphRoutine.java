package com.igormaznitsa.forph.api.routines;

import com.igormaznitsa.forph.api.engine.ForphEngineAware;
import com.igormaznitsa.forph.api.network.Addressable;
import com.igormaznitsa.forph.api.others.Nameable;
import com.igormaznitsa.forph.api.security.ForphCredentials;
import com.igormaznitsa.forph.api.security.WithCredentials;
import com.igormaznitsa.forph.api.stack.ForphPolyStack;
import com.igormaznitsa.forph.api.stack.ForphPolyStackItem;
import com.igormaznitsa.forph.api.vocabulary.word.ForphWord;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface ForphRoutine extends Addressable, Nameable, ForphEngineAware, WithCredentials {

  Optional<ForphWord> getErrorWord();

  void setErrorWord(ForphWord word);

  void interrupt(ForphCredentials credentials);

  boolean isInterrupted();

  ForphPolyStack getStack();

  CompletableFuture<ForphRoutine> call();

  ForphRoutineMode getMode();

  ForphRoutineState getState();

  ForphPolyStackItem getVar(ForphCredentials credentials, String name);

  void setVar(ForphCredentials credentials, String name, ForphPolyStackItem value);
}
