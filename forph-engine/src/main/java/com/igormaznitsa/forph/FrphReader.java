package com.igormaznitsa.forph;

import java.io.IOException;
import java.io.Reader;
import java.util.Objects;
import java.util.Optional;

public final class FrphReader extends Reader {

  private final Reader reader;
  private int line;
  private int position;

  public FrphReader(final Reader reader) {
    this.reader = Objects.requireNonNull(reader);
  }

  public Optional<String> next() throws IOException {
    final StringBuilder result = new StringBuilder();

    boolean find = true;

    final char[] chr = new char[1];
    while (read(chr, 0, 1) == 1) {
      final char foundCharacter = chr[0];
      if (find) {
        if (!(Character.isISOControl(foundCharacter) && Character.isWhitespace(foundCharacter))) {
          find = false;
          result.append(foundCharacter);
        }
      } else {
        if (Character.isISOControl(foundCharacter) || Character.isWhitespace(foundCharacter)) {
          break;
        }
      }
    }
    return result.length() == 0 ? Optional.empty() : Optional.of(result.toString());
  }

  @Override
  public int read(char[] cbuf, int off, int len) throws IOException {
    final char[] chr = new char[1];
    int readCounter = 0;

    while (len > 0) {
      final int read = this.reader.read(chr, 0, 1);
      if (read == 0) {
        break;
      }
      readCounter++;
      cbuf[off++] = chr[0];
      len--;
      if (chr[0] == '\n') {
        line++;
        position = 0;
      } else {
        position++;
      }
    }

    return readCounter;
  }

  public int getLine() {
    return this.line;
  }

  public int getPosition() {
    return this.position;
  }

  @Override
  public void close() throws IOException {
    this.reader.close();
  }
}
