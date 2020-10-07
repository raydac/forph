package com.igormaznitsa.forph.api.engine;

import com.igormaznitsa.forph.api.network.ForphAddress;
import com.igormaznitsa.forph.api.network.ForphEngineKey;
import com.igormaznitsa.forph.api.others.Nameable;
import com.igormaznitsa.forph.api.routines.ForphPipe;
import com.igormaznitsa.forph.api.routines.ForphRoutine;
import com.igormaznitsa.forph.api.security.ForphCredentials;
import com.igormaznitsa.forph.api.security.ForphSecurity;
import com.igormaznitsa.forph.api.security.WithCredentials;
import com.igormaznitsa.forph.api.stack.ForphPolyStackTag;
import com.igormaznitsa.forph.api.vocabulary.ForphVocabulary;
import java.io.IOException;
import java.io.Reader;
import java.util.Optional;

public interface ForphEngine extends Nameable, AutoCloseable, WithCredentials {

  ForphEngineKey getKey();

  Iterable<ForphAddress> allAddresses(ForphCredentials credentials);

  Optional<ForphEngineStatus> findEngineStatus(ForphCredentials credentials, ForphAddress address);

  ForphSecurity getSecurity();

  ForphPolyStackTag newTag(ForphCredentials credentials, String name);

  ForphVocabulary newVocabulary(ForphCredentials credentials, String name);

  ForphPipe newPipe(ForphCredentials credentials, String name);

  Optional<ForphAddress> findLocalAddress(ForphCredentials credentials);

  Iterable<ForphPipe> allQueues(ForphCredentials credentials);

  Optional<ForphPipe> findQueue(ForphCredentials credentials, String id);

  Optional<ForphVocabulary> findVocabulary(ForphCredentials credentials, String id);

  Iterable<ForphVocabulary> allVocabularies(ForphCredentials credentials);

  ForphRoutine spawn(ForphCredentials credentials, String id, Reader source) throws IOException;

  Iterable<ForphRoutine> allRoutines(ForphCredentials credentials, ForphAddress... addresses);
}
