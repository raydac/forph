package com.igormaznitsa.forph.api.routines;

import com.igormaznitsa.forph.api.others.Nameable;
import com.igormaznitsa.forph.api.stack.ForphPolyStackItem;
import java.time.Duration;
import java.util.Optional;
import java.util.concurrent.TimeoutException;

public interface ForphPipe extends Nameable {
  void offer(ForphPolyStackItem item);

  void push(ForphPolyStackItem item, Duration timeout) throws TimeoutException;

  ForphPolyStackItem pop(Duration timeut) throws TimeoutException;

  Optional<ForphPolyStackItem> poll(Duration timout);
}
