package com.igormaznitsa.forph;

import java.io.Serializable;

public interface ForphWord extends ForphUserAware, Serializable {

  ForphVocabulary getVocabulary();
}
