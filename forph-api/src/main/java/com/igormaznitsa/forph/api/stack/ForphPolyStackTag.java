package com.igormaznitsa.forph.api.stack;

import com.igormaznitsa.forph.api.others.Nameable;
import com.igormaznitsa.forph.api.security.WithCredentials;
import java.io.Serializable;

public interface ForphPolyStackTag extends Nameable, WithCredentials, Serializable {
  boolean isValid(ForphPolyStackItem item);
}
