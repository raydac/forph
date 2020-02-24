package com.igormaznitsa.forph;

import java.io.IOException;
import java.io.Reader;

public class ForphEngine {
  public ForphEngine() {

  }

  public void interpret(final ForphContext context, final Reader reader) throws IOException {
    while (true) {
      final String nextWord = this.next(reader);
      if (nextWord.isEmpty()) {
        break;
      }
    }
  }

  private String next(final Reader reader) throws IOException {
    final StringBuilder buffer = new StringBuilder();
    while (true) {
      final int nextChar = reader.read();
      if (nextChar < 0
          || Character.isWhitespace(nextChar)
          || Character.isISOControl(nextChar)) {
        break;
      }
      buffer.append((char) nextChar);
    }
  }

}
