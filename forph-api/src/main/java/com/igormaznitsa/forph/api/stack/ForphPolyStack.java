package com.igormaznitsa.forph.api.stack;

import com.igormaznitsa.forph.api.routines.ForphRoutine;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

public interface ForphPolyStack extends Serializable {

  void clear(ForphPolyStackTag tag);

  void clear(Set<ForphPolyStackTag> tag);

  long depth(ForphPolyStackTag tag);

  long depth(Set<ForphPolyStackTag> tags);

  ForphRoutine getRoutine();

  ForphPolyStackItem pop(ForphPolyStackTag tag);

  ForphPolyStackItem pop(Set<ForphPolyStackTag> tags);

  ForphPolyStackItem peek(ForphPolyStackTag tags);

  ForphPolyStackItem peek(Set<ForphPolyStackTag> tags);

  ForphPolyStackItem pick(int position, ForphPolyStackTag tags);

  ForphPolyStackItem pick(int position, Set<ForphPolyStackTag> tags);

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
