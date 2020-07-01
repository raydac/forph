package com.igormaznitsa.forph;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public final class FrphStack {
  private List<ForphStackItem> stack;

  FrphStack() {
    this.stack = new ArrayList<>();
  }

  public long depth() {
    return this.stack.size();
  }

  public boolean isEmpty(final int... tags) {
    return this.depth(tags) == 0L;
  }

  public void clear() {
    this.stack.clear();
  }

  public void drop(final int... tags) {
    final ForphStackItem item = this.popItem(tags);
    if (item == null) {
      throw new NoSuchElementException();
    }
    this.pushItem(item);
    this.pushItem(item);
  }

  public void swap(final int... tags) {
    final ForphStackItem b = this.popItem(tags);
    final ForphStackItem a = this.popItem(tags);
    if (a == null || b == null) {
      throw new NoSuchElementException();
    }
    this.pushItem(b);
    this.pushItem(a);
  }

  public void over(final int... tags) {
    final ForphStackItem b = this.popItem(tags);
    final ForphStackItem a = this.popItem(tags);
    if (a == null || b == null) {
      throw new NoSuchElementException();
    }
    this.pushItem(a);
    this.pushItem(b);
    this.pushItem(a);
  }

  public void rot(final int... tags) {
    final ForphStackItem c = this.popItem(tags);
    final ForphStackItem b = this.popItem(tags);
    final ForphStackItem a = this.popItem(tags);
    if (a == null || b == null || c == null) {
      throw new NoSuchElementException();
    }
    this.pushItem(b);
    this.pushItem(c);
    this.pushItem(a);
  }

  public long depth(final int... tags) {
    return this.stack.stream()
        .filter(x -> x.hasTags(tags))
        .count();
  }

  public void push(final Object content, final int... tags) {
    this.stack.add(new ForphStackItem(tags.clone(), content));
  }

  public <T> Optional<T> pop(final int... tags) {
    final ForphStackItem found = this.popItem(tags);
    return found == null ? Optional.empty() : Optional.of(found.getContent());
  }

  public <T> Optional<T> peek(final int... tags) {
    final ForphStackItem found = this.peekItem(0, tags);
    return found == null ? Optional.empty() : Optional.of(found.getContent());
  }

  private void pushItem(final ForphStackItem item) {
    this.stack.add(item);
  }

  private ForphStackItem popItem(final int... tags) {
    for (int i = this.stack.size() - 1; i >= 0; i--) {
      final ForphStackItem item = this.stack.get(i);
      if (item.hasTags(tags)) {
        return this.stack.remove(i);
      }
    }
    return null;
  }

  private ForphStackItem peekItem(final int depth, final int... tags) {
    int depthCounter = depth;
    for (int i = this.stack.size() - 1; i >= 0; i--) {
      final ForphStackItem item = this.stack.get(i);
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

  private static final class ForphStackItem {
    private final int[] tags;
    private final Object content;

    ForphStackItem(final int[] tags, final Object content) {
      this.tags = tags;
      this.content = content;
    }

    @SuppressWarnings("unchecked")
    <T> T getContent() {
      return (T) this.content;
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
