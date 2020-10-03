package com.igormaznitsa.forph;

import java.io.IOException;
import java.io.Reader;
import java.util.Optional;

public interface ForphEngine extends AutoCloseable, ForphUserAware {

  String getId();

  Iterable<ForphAddress> findAddresses(ForphUser user);

  ForphSecurity getSecurity();

  Optional<ForphQueue> findQueue(ForphUser user, String queueId);

  Iterable<ForphVocabulary> findVocabularies(ForphUser user);

  ForphRoutine startRoutine(ForphUser user, String name, Reader word) throws IOException;

  Iterable<ForphRoutine> findRoutines(ForphUser user);
}
