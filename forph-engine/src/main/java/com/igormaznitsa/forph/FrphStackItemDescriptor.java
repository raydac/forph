package com.igormaznitsa.forph;

public final class FrphStackItemDescriptor {
  private final int count;
  private final int[] tags;

  FrphStackItemDescriptor(final int count, final int[] tags) {
    assert count >= 0 : "Counte must not be negative";
    assert tags.length > 0 : "Tags must be provided";
    this.count = count;
    this.tags = tags;
  }

  public int getCount() {
    return this.count;
  }

  public int[] getTags() {
    return this.tags;
  }
}
