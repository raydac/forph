package com.igormaznitsa.forph.api.stack;

import com.igormaznitsa.forph.api.security.WithCredentials;
import java.io.Serializable;
import java.util.Set;

public interface ForphPolyStackItem extends WithCredentials, Serializable {
  Set<ForphPolyStackTag> getTags();

}
