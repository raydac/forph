package com.igormaznitsa.forph.api.stack;

import com.igormaznitsa.forph.api.routines.ForphRoutine;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ForphPolyStack extends Serializable {

  void clear(ForphPolyStackTag tag);

  void clear(Set<ForphPolyStackTag> tag);

  long depth(ForphPolyStackTag tag);

  long depth(Set<ForphPolyStackTag> tags);

  ForphRoutine getRoutine();

  Optional<ForphPolyStackItem> pop(ForphPolyStackTag tag);

  Optional<ForphPolyStackItem> pop(Set<ForphPolyStackTag> tags);

  Optional<ForphPolyStackItem> peek(ForphPolyStackTag tags);

  Optional<ForphPolyStackItem> peek(Set<ForphPolyStackTag> tags);

  Optional<ForphPolyStackItem> pick(ForphPolyStackTag tags, int depth);

  Optional<ForphPolyStackItem> pick(Set<ForphPolyStackTag> tags, int depth);

  void rot(ForphPolyStackTag tags);

  void rot(Set<ForphPolyStackTag> tags);

  void dup(ForphPolyStackTag tags);

  void dup(Set<ForphPolyStackTag> tags);

  void drop(ForphPolyStackTag tags);

  void drop(Set<ForphPolyStackTag> tags);

  void over(ForphPolyStackTag tag);

  void over(Set<ForphPolyStackTag> tags);

  void swap(ForphPolyStackTag tag);

  void swap(Set<ForphPolyStackTag> tags);

  void push(ForphPolyStackItem item);

  void push(List<ForphPolyStackItem> item);
}
