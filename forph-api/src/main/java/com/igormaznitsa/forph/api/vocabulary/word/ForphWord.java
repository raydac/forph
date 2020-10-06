package com.igormaznitsa.forph.api.vocabulary.word;

import com.igormaznitsa.forph.api.routines.ForphRoutine;
import com.igormaznitsa.forph.api.security.ForphCredentials;
import com.igormaznitsa.forph.api.security.WithCredentials;
import com.igormaznitsa.forph.api.stack.ForphPolyStackTag;
import com.igormaznitsa.forph.api.vocabulary.ForphVocabulary;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

public interface ForphWord extends WithCredentials, Serializable {
  Set<ForphPolyStackTag> getLocalTags();

  ForphVocabulary getVocabulary();

  Set<ForphWordFlag> getFlags();

  List<Set<ForphPolyStackTag>> getIn();

  List<Set<ForphPolyStackTag>> getOut();

  List<String> getName();

  int getWeight(WordWeight weight);

  void call(ForphCredentials credentials, ForphRoutine routine);
}
