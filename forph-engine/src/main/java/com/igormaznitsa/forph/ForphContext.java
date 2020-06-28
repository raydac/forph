package com.igormaznitsa.forph;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public final class ForphContext {
  private final AtomicLong wordOffsetCounter = new AtomicLong(1L);
  private final ForphVocabularyStack vocabularyStack;
  private final List<String> tags;
  private final ForphStack stack;

  ForphContext(final String... tags) {
    this.vocabularyStack = new ForphVocabularyStack(this.makeBaseVocabulary());
    this.stack = new ForphStack();
    this.tags = Arrays.stream(tags)
        .map(x -> x.toLowerCase(Locale.ENGLISH))
        .distinct()
        .collect(Collectors.toUnmodifiableList());
  }

  long makeWordOffset() {
    return this.wordOffsetCounter.getAndIncrement();
  }

  private ForphVocabulary makeBaseVocabulary() {
    return null;
  }

  public int[] asTags(final String... tag) {
    final int[] result = new int[tag.length];
    for (int i = 0; i < tag.length; i++) {
      final String tagName = tag[i];
      final int tagIndex = this.tags.indexOf(tagName);
      if (tagIndex < 0) {
        throw new NoSuchElementException("Can't find tag: " + tagName);
      }
      result[i] = tagIndex;
    }
    return result;
  }

}
