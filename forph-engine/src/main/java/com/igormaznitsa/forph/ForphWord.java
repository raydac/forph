package com.igormaznitsa.forph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

public class ForphWord {
  private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
  private static final BiConsumer<ForphContext, ForphWord> NULL_EXECUTOR = (x, y) -> {
  };
  private final Set<ForphWordFlag> flags;
  private final String[] name;
  private final ForphWordWeight cpuWeight;
  private final ForphWordWeight ramWeight;
  private final BiConsumer<ForphContext, ForphWord> executor;
  private final List<ForphWord> body;
  private final byte[] data;
  private final List<int[]> stackIn;
  private final List<int[]> stackOut;
  private final long wordOffset;

  private ForphWord(
      final long wordOffset,
      final String name
  ) {
    this.data = EMPTY_BYTE_ARRAY;
    this.cpuWeight = ForphWordWeight.ULTRALIGHT;
    this.ramWeight = ForphWordWeight.ULTRALIGHT;
    this.wordOffset = wordOffset;
    this.name = new String[] {name};
    this.flags = EnumSet.noneOf(ForphWordFlag.class);
    this.executor = NULL_EXECUTOR;
    this.body = Collections.emptyList();
    this.stackIn = Collections.emptyList();
    this.stackOut = Collections.emptyList();
  }

  private ForphWord(
      final ForphContext context,
      final EnumSet<ForphWordFlag> flags,
      final BiConsumer<ForphContext, ForphWord> executor,
      final String[] name,
      final ForphWord[] params,
      final byte[] data,
      final ForphWordWeight cpuWeight,
      final ForphWordWeight ramWeight,
      final List<int[]> stackIn,
      final List<int[]> stackOut
  ) {
    this.wordOffset = context.makeWordOffset();
    this.flags = Collections.unmodifiableSet(EnumSet.copyOf(flags));
    this.data = data.clone();
    this.name = name.clone();
    this.cpuWeight = cpuWeight;
    this.ramWeight = ramWeight;
    this.executor = executor;
    this.body = params.length == 1 ? Collections.singletonList(params[0]) :
        Arrays.stream(params).collect(Collectors.toUnmodifiableList());
    this.stackIn = stackIn.stream().collect(Collectors.toUnmodifiableList());
    this.stackOut = stackOut.stream().collect(Collectors.toUnmodifiableList());
  }

  public static Builder build(final ForphContext context, final String... name) {
    return new Builder(context, name);
  }

  public byte[] getData() {
    return this.data;
  }

  public ForphWordWeight getCpuWeight() {
    return this.cpuWeight;
  }

  public ForphWordWeight getRamWeight() {
    return this.ramWeight;
  }

  public Set<ForphWordFlag> getFlags() {
    return this.flags;
  }

  public long getWordOffset() {
    return this.wordOffset;
  }

  public boolean match(final String... name) {
    return Arrays.equals(this.name, name);
  }

  public static class Builder {
    private static final ForphWord RECURSE = new ForphWord(0L, ' ' + "RECURSE" + ' ');

    private final String[] name;
    private BiConsumer<ForphContext, ForphWord> executor = NULL_EXECUTOR;
    private List<ForphWord> params = new ArrayList<>();
    private List<String[]> stackIn;
    private List<String[]> stackOut;
    private byte[] data = EMPTY_BYTE_ARRAY;

    private Builder(final ForphContext context, final String... name) {
      if (name.length == 0) {
        throw new IllegalArgumentException("Empty name");
      }
      this.name = name.clone();
    }

    public Builder stackIn(final String... tags) {
      this.stackIn.add(tags.clone());
      return this;
    }

    public Builder stackOut(final String... tags) {
      this.stackOut.add(tags.clone());
      return this;
    }

    public Builder word(final String... name) {
      return this;
    }

    public Builder number(final long number) {
      return this;
    }

    public Builder recurse() {
      this.params.add(RECURSE);
      return this;
    }

    public ForphWord build() {
      return null;
    }

  }
}
