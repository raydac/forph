package com.igormaznitsa.forph.api.routines;

import com.igormaznitsa.forph.api.identifiers.Identifiable;
import com.igormaznitsa.forph.api.identifiers.PipeIdentifier;
import com.igormaznitsa.forph.api.stack.ForphPolyStackItem;
import java.time.Duration;
import java.util.Optional;
import java.util.concurrent.TimeoutException;

public interface ForphPipe extends Identifiable<PipeIdentifier> {
  void offer(ForphPolyStackItem item);

  void push(ForphPolyStackItem item, Duration timeout) throws TimeoutException;

  ForphPolyStackItem pop(Duration timeut) throws TimeoutException;

  Optional<ForphPolyStackItem> poll(Duration timout);
}
