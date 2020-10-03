package com.igormaznitsa.forph;

import java.io.IOException;
import java.io.Reader;
import java.util.Optional;

public interface ForphEngine extends AutoCloseable, ForphUserAware {

  String getId();

  Iterable<ForphAddress> findAddresses(ForphUser user);

  ForphSecurity getSecurity(ForphUser user);

  Optional<ForphAddress> findLocalAddress(ForphUser user);

  Optional<ForphQueue> findQueue(ForphUser user, String queueId);

  Iterable<ForphVocabulary> findVocabularies(ForphUser user);

  ForphRoutine spawn(ForphUser user, String id, Reader source) throws IOException;

  Iterable<ForphRoutine> findRoutines(ForphUser user);
}
