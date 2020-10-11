package com.igormaznitsa.forph.api.stack;

import com.igormaznitsa.forph.api.identifiers.Identifiable;
import com.igormaznitsa.forph.api.security.WithCredentials;
import java.io.Serializable;

public interface ForphPolyStackTag extends Identifiable, WithCredentials, Serializable {
  boolean isValid(ForphPolyStackItem item);
}
