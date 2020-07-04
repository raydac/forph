package com.igormaznitsa.forph;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public final class FrphContext {
  private final String contextId;
  private final AtomicLong wordOffsetCounter = new AtomicLong(1L);
  private final FrphVocabularyStack vocabularyStack;
  private final List<String> tags;
  private final FrphStack stack;
  private final FrphAccessSecurity accessSecurity;

  private int currentRing;

  FrphContext(final String contextId,
              final FrphAccessSecurity accessSecurity,
              final String... tags) {
    assert contextId != null && !contextId.isBlank() : "Context id must not be null or blank";
    this.accessSecurity = accessSecurity;
    this.contextId = contextId;
    this.vocabularyStack = new FrphVocabularyStack(this, this.makeBaseVocabulary());
    this.stack = new FrphStack();
    this.tags = Arrays.stream(tags)
        .map(x -> x.toLowerCase(Locale.ENGLISH))
        .distinct()
        .collect(Collectors.toUnmodifiableList());
  }

  public boolean isAccessible(final FrphVocabulary vocabulary) {
    return this.accessSecurity.isAccessible(this, vocabulary);
  }

  long makeWordOffset() {
    return this.wordOffsetCounter.getAndIncrement();
  }

  private FrphVocabulary makeBaseVocabulary() {
    return null;
  }

  public int getCurrentRing() {
    return this.currentRing;
  }

  public FrphAccessSecurity getAccessSecurity() {
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
      } else if (!this.accessSecurity.isAllowed(this, tagIndex)) {
        throw new SecurityException(
            String.format("Tag '%s'(%d) is not accessible", tagName, tagIndex));
      }
      result[i] = tagIndex;
    }
    return result;
  }

}
