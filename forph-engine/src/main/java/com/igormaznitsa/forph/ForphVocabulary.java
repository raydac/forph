package com.igormaznitsa.forph;

import static java.util.Arrays.stream;


import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class ForphVocabulary {
  private final String name;
  private final List<ForphWord> words;
  private final int ring;

  ForphVocabulary(final String name, final int ring, final ForphWord... baseWords) {
    assert name != null && !name.isBlank() : "Name must not be empty and blank";
    this.ring = ring;
    this.name = name;
    this.words = stream(baseWords)
        .filter(Objects::nonNull)
        .collect(Collectors.toUnmodifiableList());
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
    if (that instanceof ForphVocabulary) {
      return this.name.equals(((ForphVocabulary) that).name);
    }
    return false;
  }

  public void forget(final ForphWord word) {
    this.words.removeIf(x -> x.getWordOffset() >= word.getWordOffset());
  }

  public String getName() {
    return this.name;
  }

  public void add(final ForphWord word) {
    this.words.add(Objects.requireNonNull(word));
  }

  public Optional<ForphWord> find(final String... name) {
    return this.words.stream().filter(x -> x.match(name)).findFirst();
  }

}
