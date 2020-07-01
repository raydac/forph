package com.igormaznitsa.forph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

public class FrphWord {
  private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
  public static final BiConsumer<FrphContext, FrphWord> NULL_EXECUTOR = (x, y) -> {
  };
  public static final BiConsumer<FrphContext, FrphWord> INT_EXECUTOR = (x, y) -> {
  };
  public static final BiConsumer<FrphContext, FrphWord> FLOAT_EXECUTOR = (x, y) -> {
  };
  public static final BiConsumer<FrphContext, FrphWord> STR_EXECUTOR = (x, y) -> {
  };
  public static final BiConsumer<FrphContext, FrphWord> WORD_EXECUTOR = (x, y) -> {
  };
  private final Set<FrphWordFlag> flags;
  private final String[] name;
  private final FrphWordWeight cpuWeight;
  private final FrphWordWeight ramWeight;
  private final BiConsumer<FrphContext, FrphWord> executor;
  private final List<FrphWord> body;
  private final byte[] data;
  private final List<FrphStackItemDescriptor> stackIn;
  private final List<FrphStackItemDescriptor> stackOut;
  private final long wordOffset;

  private FrphWord(
      final long wordOffset,
      final String name
  ) {
    this.data = EMPTY_BYTE_ARRAY;
    this.cpuWeight = FrphWordWeight.ULTRALIGHT;
    this.ramWeight = FrphWordWeight.ULTRALIGHT;
    this.wordOffset = wordOffset;
    this.name = new String[] {name};
    this.flags = EnumSet.noneOf(FrphWordFlag.class);
    this.executor = NULL_EXECUTOR;
    this.body = Collections.emptyList();
    this.stackIn = Collections.emptyList();
    this.stackOut = Collections.emptyList();
  }

  private FrphWord(
      final FrphContext context,
      final EnumSet<FrphWordFlag> flags,
      final BiConsumer<FrphContext, FrphWord> executor,
      final String[] name,
      final FrphWord[] params,
      final byte[] data,
      final FrphWordWeight cpuWeight,
      final FrphWordWeight ramWeight,
      final List<FrphStackItemDescriptor> stackIn,
      final List<FrphStackItemDescriptor> stackOut
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

  public static Builder build(final FrphContext context, final String... name) {
    return new Builder(context, name);
  }

  public byte[] getData() {
    return this.data;
  }

  public FrphWordWeight getCpuWeight() {
    return this.cpuWeight;
  }

  public FrphWordWeight getRamWeight() {
    return this.ramWeight;
  }

  public Set<FrphWordFlag> getFlags() {
    return this.flags;
  }

  public long getWordOffset() {
    return this.wordOffset;
  }

  public boolean match(final String... name) {
    return Arrays.equals(this.name, name);
  }

  public static class Builder {
    private static final FrphWord RECURSE = new FrphWord(0L, ' ' + "RECURSE" + ' ');

    private final String[] name;
    private BiConsumer<FrphContext, FrphWord> executor = NULL_EXECUTOR;
    private List<FrphWord> params = new ArrayList<>();
    private List<String[]> stackIn;
    private List<String[]> stackOut;
    private byte[] data = EMPTY_BYTE_ARRAY;

    private Builder(final FrphContext context, final String... name) {
      assert name.length > 0 : "Name must not be empty";
      this.name = name.clone();
    }

    public Builder stackIn(final String... tags) {
      assert tags.length > 0 : "Tag must be provided";
      this.stackIn.add(tags.clone());
      return this;
    }

    public Builder stackOut(final String... tags) {
      assert tags.length > 0 : "Tag must be provided";
      this.stackOut.add(tags.clone());
      return this;
    }

    public Builder word(final String... name) {
      return this;
    }

    public Builder number(final long number) {
      return this;
    }

    public Builder number(final double number) {
      return this;
    }

    public Builder str(final String str) {
      return this;
    }

    public Builder recurse() {
      this.params.add(RECURSE);
      return this;
    }

    public FrphWord build() {
      return null;
    }

  }
}
