package com.igormaznitsa.forph;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ForphVocabularyStack {
  private final List<ForphVocabulary> vocabularyList;
  private final ForphVocabulary baseVocabulary;

  ForphVocabularyStack(final ForphVocabulary baseVocabulary) {
    this.baseVocabulary = baseVocabulary;
    this.vocabularyList = new ArrayList<>();
    this.vocabularyList.add(new ForphVocabulary("user"));
  }

  public Optional<ForphVocabulary> activate(final String name) {
    Optional<ForphVocabulary> vocabulary = this.find(name);
    vocabulary.ifPresent(x -> {
      this.vocabularyList.remove(x);
      this.vocabularyList.add(0, x);
    });
    return vocabulary;
  }

  public Optional<ForphVocabulary> find(final String name) {
    return this.vocabularyList.stream().filter(x -> x.getName().equals(name)).findFirst();
  }

  public ForphVocabulary findOrCreateIfAbsent(final String name) {
    return this.find(name)
        .orElseGet(() -> {
          final ForphVocabulary newVocabulary = new ForphVocabulary(name);
          this.vocabularyList.add(0, newVocabulary);
          return newVocabulary;
        });
  }

  public ForphVocabulary current() {
    return this.vocabularyList.get(0);
  }

  public boolean forget(final String... name) {
    final Optional<ForphWord> word = this.findWord(name);
    word.ifPresent(x -> {
      vocabularyList.forEach(y -> y.forget(x));
    });
    return word.isPresent();
  }

  public Optional<ForphWord> findWord(final String... name) {
    for (final ForphVocabulary v : this.vocabularyList) {
      final Optional<ForphWord> foundWord = v.find(name);
      if (foundWord.isPresent()) {
        this.vocabularyList.remove(v);
        this.vocabularyList.add(0, v);
        return foundWord;
      }
    }
    return this.baseVocabulary.find(name);
  }
}
