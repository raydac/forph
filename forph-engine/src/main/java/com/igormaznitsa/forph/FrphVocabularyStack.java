package com.igormaznitsa.forph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public final class FrphVocabularyStack {
  private final List<FrphVocabulary> vocabularyList;
  private final FrphVocabulary baseVocab;
  private final FrphContext context;

  FrphVocabularyStack(final FrphContext context, final FrphVocabulary baseVocabulary) {
    assert baseVocabulary != null : "Base FORPH vocabulary must be provide";
    assert context != null : "Context must not be null";

    this.context = context;
    this.baseVocab = baseVocabulary;
    this.vocabularyList = new ArrayList<>();
  }

  public Optional<FrphVocabulary> activate(final String name) {
    assert name != null : "Name can't be null";
    Optional<FrphVocabulary> vocabulary = this.find(name);
    vocabulary.ifPresent(x -> {
      this.vocabularyList.remove(x);
      this.vocabularyList.add(0, x);
    });
    return vocabulary;
  }

  Optional<FrphVocabulary> find(final String name) {
    assert name != null : "Name must not be null";
    return this.vocabularyList.stream().filter(x -> x.getName().equals(name)).findFirst();
  }

  FrphVocabulary add(final String name, final int[] defaultTags, final int callerRing) {
    assert name != null : "Name can't be null";

    this.find(name)
        .ifPresent(voc -> {
          throw new IllegalArgumentException("Vocabulary already presented: " + name);
        });
    return this.find(name)
        .orElseGet(() -> {
          final FrphVocabulary newVocabulary = new FrphVocabulary(
              name,
              callerRing,
              defaultTags,
              Collections.emptyList()
          );
          this.vocabularyList.add(0, newVocabulary);
          return newVocabulary;
        });
  }

  Optional<FrphVocabulary> current() {
    return this.vocabularyList.stream().filter(this.context::isAccessible).findFirst();
  }

  boolean forget(final String... name) {
    assert name.length > 0 : "Name can't be empty";
    final Optional<FrphWord> word = this.findWord(name);
    word.ifPresent(x -> {
      vocabularyList.forEach(y -> y.forget(x));
    });
    return word.isPresent();
  }

  Optional<FrphWord> findWord(final String... name) {
    assert name.length > 0 : "Name can't be empty";
    for (final FrphVocabulary v : this.vocabularyList) {
      if (this.context.isAccessible(v)) {
        final Optional<FrphWord> foundWord = v.find(name);
        if (foundWord.isPresent()) {
          this.vocabularyList.remove(v);
          this.vocabularyList.add(0, v);
          return foundWord;
        }
      }
    }
    return this.baseVocab.find(name);
  }
}
