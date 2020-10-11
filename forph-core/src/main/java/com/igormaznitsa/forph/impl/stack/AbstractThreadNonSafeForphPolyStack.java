package com.igormaznitsa.forph.impl.stack;

import com.igormaznitsa.forph.api.routines.ForphRoutine;
import com.igormaznitsa.forph.api.stack.ForphPolyStack;
import com.igormaznitsa.forph.api.stack.ForphPolyStackItem;
import com.igormaznitsa.forph.api.stack.ForphPolyStackTag;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Set;

public abstract class AbstractThreadNonSafeForphPolyStack implements ForphPolyStack {
  private final List<ForphPolyStackItem> stackStore;
  private final ForphRoutine routine;

  public AbstractThreadNonSafeForphPolyStack(final ForphRoutine routine,
                                             final List<ForphPolyStackItem> stackStore) {
    assert routine != null;
    assert stackStore != null;
    this.stackStore = stackStore;
    this.routine = routine;
  }

  @Override
  public void clear() {
    this.stackStore.clear();
  }

  @Override
  public void clear(final ForphPolyStackTag tag) {
    this.stackStore.removeIf(x -> x.getTags().contains(tag));
  }

  @Override
  public void clear(final Set<ForphPolyStackTag> tags) {
    this.stackStore.removeIf(x -> x.getTags().containsAll(tags));
  }

  @Override
  public long depth(final ForphPolyStackTag tag) {
    return this.stackStore.stream().filter(x -> x.getTags().contains(tag)).count();
  }

  @Override
  public long depth(final Set<ForphPolyStackTag> tags) {
    return this.stackStore.stream().filter(x -> x.getTags().containsAll(tags)).count();
  }

  @Override
  public ForphRoutine getRoutine() {
    return this.routine;
  }

  private OptionalInt findFirstPosition(
      final Set<ForphPolyStackTag> tags,
      final int skip
  ) {
    int skipItems = skip;
    for (int i = this.stackStore.size() - 1; i >= 0; i--) {
      final ForphPolyStackItem item = this.stackStore.get(i);
      if (item.getTags().containsAll(tags)) {
        if (skipItems == 0) {
          return OptionalInt.of(i);
        } else {
          skipItems--;
        }
      }
    }
    return OptionalInt.empty();
  }


  @Override
  public Optional<ForphPolyStackItem> pop(final ForphPolyStackTag tag) {
    final OptionalInt position = this.findFirstPosition(Collections.singleton(tag), 0);
    return position.isPresent() ? Optional.of(this.stackStore.remove(position.getAsInt())) :
        Optional.empty();
  }

  @Override
  public Optional<ForphPolyStackItem> pop(final Set<ForphPolyStackTag> tags) {
    final OptionalInt position = this.findFirstPosition(tags, 0);
    return position.isPresent() ? Optional.of(this.stackStore.remove(position.getAsInt())) :
        Optional.empty();
  }

  @Override
  public Optional<ForphPolyStackItem> peek(final ForphPolyStackTag tag) {
    final OptionalInt position = this.findFirstPosition(Collections.singleton(tag), 0);
    return position.isPresent() ? Optional.of(this.stackStore.get(position.getAsInt())) :
        Optional.empty();
  }

  @Override
  public Optional<ForphPolyStackItem> peek(final Set<ForphPolyStackTag> tags) {
    final OptionalInt position = this.findFirstPosition(tags, 0);
    return position.isPresent() ? Optional.of(this.stackStore.get(position.getAsInt())) :
        Optional.empty();
  }

  @Override
  public Optional<ForphPolyStackItem> remove(final ForphPolyStackTag tag, final long depth) {
    final OptionalInt position = this.findFirstPosition(Collections.singleton(tag), (int) depth);
    return position.isEmpty() ? Optional.empty() :
        Optional.of(this.stackStore.remove(position.getAsInt()));
  }

  @Override
  public Optional<ForphPolyStackItem> remove(final Set<ForphPolyStackTag> tags, final long depth) {
    final OptionalInt position = this.findFirstPosition(tags, (int) depth);
    return position.isEmpty() ? Optional.empty() :
        Optional.of(this.stackStore.remove(position.getAsInt()));
  }

  @Override
  public void push(final ForphPolyStackItem item) {
    assert item != null;
    this.stackStore.add(item);
  }

  @Override
  public void push(final List<ForphPolyStackItem> items) {
    items.forEach(this::push);
  }
}
