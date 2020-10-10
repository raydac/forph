package com.igormaznitsa.forph.engine.impl.security;

import com.igormaznitsa.forph.api.security.ForphCredentials;
import com.igormaznitsa.forph.api.security.ForphCredentialsFactory;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public final class ForphCredentialsFactoryImpl implements ForphCredentialsFactory {

  public static final int LEVEL_ROOT = 0;
  public static final int LEVEL_MASTER = 1;
  public static final int LEVEL_DEVELOPER = 2;
  public static final int LEVEL_USER = 3;
  private static final ForphCredentialsFactoryImpl INSTANCE = new ForphCredentialsFactoryImpl();
  private final List<ForphCredentialsImpl> credentialsList;

  private ForphCredentialsFactoryImpl() {
    this.credentialsList = List.of(
        new ForphCredentialsImpl("root", "root", UUID.randomUUID(), LEVEL_ROOT),
        new ForphCredentialsImpl("master", "master", UUID.randomUUID(), LEVEL_MASTER),
        new ForphCredentialsImpl("developer", "developer", UUID.randomUUID(), LEVEL_DEVELOPER),
        new ForphCredentialsImpl("user", "user", UUID.randomUUID(), LEVEL_USER)
    );
  }

  public static ForphCredentialsFactoryImpl getInstance() {
    return INSTANCE;
  }

  @Override
  public Optional<ForphCredentials> findCredentials(final String name, final String password) {
    return this.credentialsList.stream()
        .filter(x -> x.doesMatch(name, password))
        .map(x -> (ForphCredentials) x)
        .findFirst();
  }
}
