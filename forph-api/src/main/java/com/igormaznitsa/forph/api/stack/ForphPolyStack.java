package com.igormaznitsa.forph.api.stack;

import com.igormaznitsa.forph.api.routines.ForphRoutine;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ForphPolyStack extends Serializable {

  void clear();

  void clear(ForphPolyStackTag tag);

  void clear(Set<ForphPolyStackTag> tags);

  long depth(ForphPolyStackTag tag);

  long depth(Set<ForphPolyStackTag> tags);

  ForphRoutine getRoutine();

  Optional<ForphPolyStackItem> pop(ForphPolyStackTag tag);

  Optional<ForphPolyStackItem> pop(Set<ForphPolyStackTag> tags);

  Optional<ForphPolyStackItem> peek(ForphPolyStackTag tag);

  Optional<ForphPolyStackItem> peek(Set<ForphPolyStackTag> tags);

  Optional<ForphPolyStackItem> remove(ForphPolyStackTag tags, long depth);

  Optional<ForphPolyStackItem> remove(Set<ForphPolyStackTag> tags, long depth);

  void push(ForphPolyStackItem item);

  void push(List<ForphPolyStackItem> items);
}
