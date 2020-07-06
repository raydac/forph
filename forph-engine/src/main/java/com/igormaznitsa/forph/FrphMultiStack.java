package com.igormaznitsa.forph;

import static java.util.Objects.requireNonNull;


import java.util.ArrayList;
import java.util.List;

final class FrphMultiStack {
  private final List<FrphStackItemImpl> stack;

  FrphMultiStack() {
    this.stack = new ArrayList<>();
  }

  boolean isEmpty(final int... tags) {
    return this.depth(tags) == 0L;
  }

  public void clear() {
    this.stack.clear();
  }

  long depth() {
    return this.stack.size();
  }

  long depth(final int... tags) {
    return this.stack.stream()
        .filter(x -> x.hasTags(tags))
        .count();
  }

  void push(final Object content, final int... tags) {
    this.stack.add(new FrphStackItemImpl(tags, requireNonNull(content)));
  }

  FrphStackItem popItem(final int... tags) {
    for (int i = this.stack.size() - 1; i >= 0; i--) {
      final FrphStackItemImpl item = this.stack.get(i);
      if (item.hasTags(tags)) {
        return this.stack.remove(i);
      }
    }
    return null;
  }

  FrphStackItem peekItem(final int depth, final int... tags) {
    int depthCounter = depth;
    for (int i = this.stack.size() - 1; i >= 0; i--) {
      final FrphStackItemImpl item = this.stack.get(i);
      if (item.hasTags(tags)) {
        if (depthCounter == 0) {
          return item;
        } else {
          depthCounter--;
        }
      }
    }
    return null;
  }

  private static final class FrphStackItemImpl implements FrphStackItem {
    private final int[] tags;
    private final Object content;

    FrphStackItemImpl(final int[] tags, final Object content) {
      this.tags = tags.clone();
      this.content = content;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T getContent() {
      return (T) this.content;
    }

    @Override
    public int[] getTags() {
      return this.tags.clone();
    }

    boolean hasTags(final int... tag) {
      for (int j : tag) {
        boolean found = false;
        for (int i : tags) {
          if (j == i) {
            found = true;
            break;
          }
        }
        if (!found) {
          return false;
        }
      }
      return true;
    }
  }

}
