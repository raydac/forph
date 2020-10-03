package com.igormaznitsa.forph;

import java.io.Serializable;
import java.util.Set;

public interface ForphPolyStackItem extends ForphUserAware, Serializable {
  Set<ForphPolyStackTag> getTags();

}
