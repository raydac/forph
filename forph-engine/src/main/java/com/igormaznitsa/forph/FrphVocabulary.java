package com.igormaznitsa.forph;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class FrphVocabulary {
  private final String name;
  private final List<FrphWord> words;
  private final int[] defaultTags;
  private final int ring;

  FrphVocabulary(
      final String name,
      final int ring,
      final int[] defaultTags,
      final List<FrphWord> words
  ) {
    assert name != null && !name.isBlank() : "Name must not be empty and blank";
    this.ring = ring;
    this.defaultTags = defaultTags.clone();
    this.name = name;
    this.words = new ArrayList<>(words);
  }

  public int[] getDefaultTags() {
    return this.defaultTags;
  }

  public int getRing() {
    return this.ring;
  }

  @Override
  public int hashCode() {
    return this.name.hashCode();
  }

  @Override
  public boolean equals(final Object that) {
    if (that instanceof FrphVocabulary) {
      return this.name.equals(((FrphVocabulary) that).name);
    }
    return false;
  }

  public void forget(final FrphWord word) {
    this.words.removeIf(x -> x.getWordOffset() >= word.getWordOffset());
  }

  public String getName() {
    return this.name;
  }

  public void add(final FrphWord word) {
    this.words.add(Objects.requireNonNull(word));
  }

  public Optional<FrphWord> find(final String... name) {
    return this.words.stream().filter(x -> x.match(name)).findFirst();
  }

}
