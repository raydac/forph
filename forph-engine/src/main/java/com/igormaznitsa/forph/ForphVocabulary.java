package com.igormaznitsa.forph;

import java.io.Serializable;
import java.util.Iterator;

public interface ForphVocabulary extends ForphEngineAware, Serializable {

  Iterator<ForphWord> findWords();
}

