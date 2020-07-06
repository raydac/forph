package com.igormaznitsa.forph;

public interface FrphStackItem {
  <T> T getContent();

  int[] getTags();
}
