package com.igormaznitsa.forph.api.stack;

import com.igormaznitsa.forph.api.routines.ForphRoutine;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

public interface ForphPolyStack extends Serializable {

  ForphPolyStack clear(ForphPolyStackTag tag);

  ForphPolyStack clear(Set<ForphPolyStackTag> tag);

  long depth(ForphPolyStackTag tag);

  long depth(Set<ForphPolyStackTag> tags);

  ForphRoutine getRoutine();

  ForphPolyStackItem pop(ForphPolyStackTag tag);

  ForphPolyStackItem pop(Set<ForphPolyStackTag> tags);

  ForphPolyStackItem peek(ForphPolyStackTag tags);

  ForphPolyStackItem peek(Set<ForphPolyStackTag> tags);

  ForphPolyStackItem pick(int position, ForphPolyStackTag tags);

  ForphPolyStackItem pick(int position, Set<ForphPolyStackTag> tags);

  ForphPolyStack rot(ForphPolyStackTag tags);

  ForphPolyStack rot(Set<ForphPolyStackTag> tags);

  ForphPolyStack dup(ForphPolyStackTag tags);

  ForphPolyStack dup(Set<ForphPolyStackTag> tags);

  ForphPolyStack drop(ForphPolyStackTag tags);

  ForphPolyStack drop(Set<ForphPolyStackTag> tags);

  ForphPolyStack over(ForphPolyStackTag tag);

  ForphPolyStack over(Set<ForphPolyStackTag> tags);

  ForphPolyStack swap(ForphPolyStackTag tag);

  ForphPolyStack swap(Set<ForphPolyStackTag> tags);

  ForphPolyStack push(ForphPolyStackItem item);

  ForphPolyStack push(List<ForphPolyStackItem> item);
}
