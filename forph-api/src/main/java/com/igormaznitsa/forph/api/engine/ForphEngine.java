package com.igormaznitsa.forph.api.engine;

import com.igormaznitsa.forph.api.network.ForphAddress;
import com.igormaznitsa.forph.api.network.ForphEngineKey;
import com.igormaznitsa.forph.api.routines.ForphQueue;
import com.igormaznitsa.forph.api.routines.ForphRoutine;
import com.igormaznitsa.forph.api.security.ForphCredentials;
import com.igormaznitsa.forph.api.security.ForphSecurity;
import com.igormaznitsa.forph.api.security.WithCredentials;
import com.igormaznitsa.forph.api.vocabulary.ForphVocabulary;
import java.io.IOException;
import java.io.Reader;
import java.util.Optional;

public interface ForphEngine extends AutoCloseable, WithCredentials {

  String getId();

  ForphEngineKey getKey();

  Iterable<ForphAddress> allAddresses(ForphCredentials credentials);

  Optional<ForphEngineStatus> findEngineStatus(ForphCredentials credentials, ForphAddress address);

  ForphSecurity getSecurity();

  Optional<ForphAddress> findLocalAddress(ForphCredentials credentials);

  Iterable<ForphQueue> allQueues(ForphCredentials credentials);

  Optional<ForphQueue> findQueue(ForphCredentials credentials, String id);

  Optional<ForphVocabulary> findVocabulary(ForphCredentials credentials, String id);

  Iterable<ForphVocabulary> allVocabularies(ForphCredentials credentials);

  ForphRoutine spawn(ForphCredentials credentials, String id, Reader source) throws IOException;

  Iterable<ForphRoutine> allRoutines(ForphCredentials credentials, ForphAddress... addresses);
}
