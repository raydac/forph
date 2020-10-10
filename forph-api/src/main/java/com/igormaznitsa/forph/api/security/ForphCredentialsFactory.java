package com.igormaznitsa.forph.api.security;

import java.util.Optional;

public interface ForphCredentialsFactory {
  Optional<ForphCredentials> findCredentials(String name, String password);
}
