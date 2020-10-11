package com.igormaznitsa.forph.api.exceptions;

import static java.util.Objects.requireNonNull;
import static java.util.Set.copyOf;


import com.igormaznitsa.forph.api.engine.ForphEngine;
import com.igormaznitsa.forph.api.identifiers.RoutineIdentifier;
import com.igormaznitsa.forph.api.stack.ForphPolyStackTag;
import java.util.Set;

public class ForphStackItemNotFoundException extends ForphStackException {

  private final RoutineIdentifier routineId;
  private final Set<ForphPolyStackTag> tags;

  public ForphStackItemNotFoundException(
      ForphEngine engine,
      String message,
      RoutineIdentifier routineId,
      Set<ForphPolyStackTag> tags
  ) {
    super(engine, message);
    this.routineId = requireNonNull(routineId);
    this.tags = copyOf(requireNonNull(tags));
  }

  public RoutineIdentifier getRoutineId() {
    return this.routineId;
  }

  public Set<ForphPolyStackTag> getTags() {
    return this.tags;
  }
}
