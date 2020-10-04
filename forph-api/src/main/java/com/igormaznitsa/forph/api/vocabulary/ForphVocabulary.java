package com.igormaznitsa.forph.api.vocabulary;

import com.igormaznitsa.forph.api.engine.ForphEngineAware;
import com.igormaznitsa.forph.api.others.IdAware;
import com.igormaznitsa.forph.api.vocabulary.word.ForphWord;
import java.io.Serializable;
import java.util.Iterator;

public interface ForphVocabulary extends IdAware, ForphEngineAware, Serializable {

  ForphVocabularyStatus getStatus();

  Iterator<ForphWord> allWords();
}

