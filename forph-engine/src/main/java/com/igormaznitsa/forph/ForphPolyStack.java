package com.igormaznitsa.forph;

import java.io.Serializable;

public interface ForphPolyStack extends Serializable {

  ForphRoutine getRoutine();

  ForphPolyStackItem pop();

  ForphPolyStackItem pop(ForphPolyStackTag tags);

  ForphPolyStackItem pop(ForphPolyStackTag... tags);

  ForphPolyStackItem peek();

  ForphPolyStackItem peek(ForphPolyStackTag tags);

  ForphPolyStackItem peek(ForphPolyStackTag... tags);

  ForphPolyStackItem pick(int position);

  ForphPolyStackItem pick(int position, ForphPolyStackTag tags);

  ForphPolyStackItem pick(int position, ForphPolyStackTag... tags);

  ForphPolyStack rot();

  ForphPolyStack rot(ForphPolyStackTag tags);

  ForphPolyStack rot(ForphPolyStackTag... tags);

  ForphPolyStack dup();

  ForphPolyStack dup(ForphPolyStackTag tags);

  ForphPolyStack dup(ForphPolyStackTag... tags);

  ForphPolyStack drop();

  ForphPolyStack drop(ForphPolyStackTag tags);

  ForphPolyStack drop(ForphPolyStackTag... tags);

  ForphPolyStack over();

  ForphPolyStack over(ForphPolyStackTag tags);

  ForphPolyStack over(ForphPolyStackTag... tags);

  ForphPolyStack swap();

  ForphPolyStack swap(ForphPolyStackTag tags);

  ForphPolyStack swap(ForphPolyStackTag... tags);

  ForphPolyStack push(ForphPolyStackItem item);

  ForphPolyStack push(ForphPolyStackItem... item);
}
