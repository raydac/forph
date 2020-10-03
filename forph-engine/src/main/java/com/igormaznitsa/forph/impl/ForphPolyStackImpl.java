package com.igormaznitsa.forph.impl;

import com.igormaznitsa.forph.ForphPolyStack;
import com.igormaznitsa.forph.ForphPolyStackItem;
import com.igormaznitsa.forph.ForphPolyStackTag;
import com.igormaznitsa.forph.ForphRoutine;

final class ForphPolyStackImpl implements ForphPolyStack {

  private final ForphRoutineImpl routine;

  public ForphPolyStackImpl(final ForphRoutineImpl routine) {
    this.routine = routine;
  }

  @Override
  public ForphRoutine getRoutine() {
    return this.routine;
  }

  @Override
  public ForphPolyStackItem pop() {
    return null;
  }

  @Override
  public ForphPolyStackItem pop(ForphPolyStackTag tags) {
    return null;
  }

  @Override
  public ForphPolyStackItem pop(ForphPolyStackTag... tags) {
    return null;
  }

  @Override
  public ForphPolyStackItem peek() {
    return null;
  }

  @Override
  public ForphPolyStackItem peek(ForphPolyStackTag tags) {
    return null;
  }

  @Override
  public ForphPolyStackItem peek(ForphPolyStackTag... tags) {
    return null;
  }

  @Override
  public ForphPolyStackItem pick(int position) {
    return null;
  }

  @Override
  public ForphPolyStackItem pick(int position, ForphPolyStackTag tags) {
    return null;
  }

  @Override
  public ForphPolyStackItem pick(int position, ForphPolyStackTag... tags) {
    return null;
  }

  @Override
  public ForphPolyStack rot() {
    return null;
  }

  @Override
  public ForphPolyStack rot(ForphPolyStackTag tags) {
    return null;
  }

  @Override
  public ForphPolyStack rot(ForphPolyStackTag... tags) {
    return null;
  }

  @Override
  public ForphPolyStack dup() {
    return null;
  }

  @Override
  public ForphPolyStack dup(ForphPolyStackTag tags) {
    return null;
  }

  @Override
  public ForphPolyStack dup(ForphPolyStackTag... tags) {
    return null;
  }

  @Override
  public ForphPolyStack drop() {
    return null;
  }

  @Override
  public ForphPolyStack drop(ForphPolyStackTag tags) {
    return null;
  }

  @Override
  public ForphPolyStack drop(ForphPolyStackTag... tags) {
    return null;
  }

  @Override
  public ForphPolyStack over() {
    return null;
  }

  @Override
  public ForphPolyStack over(ForphPolyStackTag tags) {
    return null;
  }

  @Override
  public ForphPolyStack over(ForphPolyStackTag... tags) {
    return null;
  }

  @Override
  public ForphPolyStack swap() {
    return null;
  }

  @Override
  public ForphPolyStack swap(ForphPolyStackTag tags) {
    return null;
  }

  @Override
  public ForphPolyStack swap(ForphPolyStackTag... tags) {
    return null;
  }

  @Override
  public ForphPolyStack push(ForphPolyStackItem item) {
    return null;
  }

  @Override
  public ForphPolyStack push(ForphPolyStackItem... item) {
    return null;
  }


}
