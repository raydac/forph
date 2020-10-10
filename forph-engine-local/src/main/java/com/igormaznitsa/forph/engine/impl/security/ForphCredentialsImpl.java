package com.igormaznitsa.forph.engine.impl.security;

import com.igormaznitsa.forph.api.security.ForphCredentials;
import java.util.Objects;
import java.util.UUID;

class ForphCredentialsImpl implements ForphCredentials {

  private final String name;
  private final int password;
  private final UUID uuid;
  private final int level;

  ForphCredentialsImpl(
      final String name,
      final String password,
      final UUID uuid,
      final int level) {
    this.name = Objects.requireNonNull(name);
    this.password = Objects.requireNonNull(password).hashCode();
    this.uuid = Objects.requireNonNull(uuid);
    this.level = level;
  }

  int getLevel() {
    return this.level;
  }

  boolean doesCoverRights(final ForphCredentialsImpl credentials) {
    return this.level <= credentials.level;
  }

  boolean doesMatch(final String name, final String password) {
    return this.name.equals(name) && this.password == password.hashCode();
  }

  @Override
  public int hashCode() {
    return this.uuid.hashCode();
  }

  @Override
  public boolean equals(final Object that) {
    if (that == null) {
      return false;
    }
    if (this == that) {
      return true;
    }
    return that instanceof ForphCredentialsImpl
        && (this.uuid.equals(((ForphCredentialsImpl) that).uuid))
        && (this.name.equals(((ForphCredentialsImpl) that).name))
        && (this.password == ((ForphCredentialsImpl) that).password)
        && (this.level == ((ForphCredentialsImpl) that).level);
  }

  @Override
  public String toString() {
    return String.format("ForphCredentials(name='%s',uuid='%s')", this.name, this.uuid);
  }

  @Override
  public String getName() {
    return this.name;
  }
}
