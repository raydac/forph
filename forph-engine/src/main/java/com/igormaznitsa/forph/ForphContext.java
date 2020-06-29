package com.igormaznitsa.forph;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public final class ForphContext {
  private final String contextId;
  private final AtomicLong wordOffsetCounter = new AtomicLong(1L);
  private final ForphVocabularyStack vocabularyStack;
  private final List<String> tags;
  private final ForphStack stack;
  private final ForphAccessSecurity accessSecurity;

  private int currentRing;

  ForphContext(final String contextId,
               final ForphAccessSecurity accessSecurity,
               final String... tags) {
    assert contextId != null && !contextId.isBlank() : "Context id must not be null or blank";
    this.accessSecurity = accessSecurity;
    this.contextId = contextId;
    this.vocabularyStack = new ForphVocabularyStack(this, this.makeBaseVocabulary());
    this.stack = new ForphStack();
    this.tags = Arrays.stream(tags)
        .map(x -> x.toLowerCase(Locale.ENGLISH))
        .distinct()
        .collect(Collectors.toUnmodifiableList());
  }

  public boolean isAccessible(final ForphVocabulary vocabulary) {
    return this.accessSecurity.isAccessible(this, vocabulary);
  }

  long makeWordOffset() {
    return this.wordOffsetCounter.getAndIncrement();
  }

  private ForphVocabulary makeBaseVocabulary() {
    return null;
  }

  public int getCurrentRing() {
    return this.currentRing;
  }

  public ForphAccessSecurity getAccessSecurity() {
    return this.accessSecurity;
  }

  public String getContextId() {
    return this.contextId;
  }

  public void addTag(final String tag) {
    final String normalized = tag.toLowerCase(Locale.ENGLISH).trim();
    if (this.tags.contains(normalized)) {
      throw new IllegalArgumentException("Tag already presented: " + normalized);
    }
    this.tags.add(normalized);
  }

  public String[] getAllTags() {
    return this.tags.toArray(String[]::new);
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
