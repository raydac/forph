package com.igormaznitsa.forph.api.security;

import com.igormaznitsa.forph.api.identifiers.CredentialsIdentifier;
import java.util.Optional;

public interface ForphCredentialsFactory {
  Optional<ForphCredentials> findCredentials(CredentialsIdentifier credentialsId);
}
