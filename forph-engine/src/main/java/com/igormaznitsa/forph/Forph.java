package com.igormaznitsa.forph;

public class Forph {

  private final ForphVocabularyStack vocabularyStack;

  public Forph() {
    this.vocabularyStack = new ForphVocabularyStack(makeBaseStack());
  }

  private static ForphVocabulary makeBaseStack() {
    return new ForphVocabulary("forph");
  }

}
