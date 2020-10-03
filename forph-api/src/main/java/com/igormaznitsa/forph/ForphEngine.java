package com.igormaznitsa.forph;

import java.io.IOException;
import java.io.Reader;
import java.util.Optional;

public interface ForphEngine extends AutoCloseable, ForphUserAware {

  String getId();

  Iterable<ForphAddress> allAddresses(ForphUser user);

  ForphSecurity getSecurity();

  Optional<ForphAddress> findLocalAddress(ForphUser user);

  Iterable<ForphQueue> allQueues(ForphUser user);

  Optional<ForphQueue> findQueue(ForphUser user, String id);

  Optional<ForphVocabulary> findVocabulary(ForphUser user, String id);

  Iterable<ForphVocabulary> allVocabularies(ForphUser user);

  ForphRoutine spawn(ForphUser user, String id, Reader source) throws IOException;

  Iterable<ForphRoutine> allRoutines(ForphUser user);
}
