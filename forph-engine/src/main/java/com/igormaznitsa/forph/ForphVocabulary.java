package com.igormaznitsa.forph;

import java.io.Serializable;
import java.util.Iterator;

public interface ForphVocabulary extends IdAware, ForphEngineAware, Serializable {

  ForphVocabularyStatus getStatus();

  Iterator<ForphWord> findWords();
}

