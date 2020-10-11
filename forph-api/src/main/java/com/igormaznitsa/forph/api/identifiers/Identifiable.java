package com.igormaznitsa.forph.api.identifiers;

public interface Identifiable<T extends Identifier> {
  T getIdentifier();
}
