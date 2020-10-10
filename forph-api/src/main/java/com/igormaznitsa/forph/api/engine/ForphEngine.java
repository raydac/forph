package com.igormaznitsa.forph.api.engine;

import com.igormaznitsa.forph.api.network.ForphAddress;
import com.igormaznitsa.forph.api.network.ForphEngineKey;
import com.igormaznitsa.forph.api.others.Nameable;
import com.igormaznitsa.forph.api.routines.ForphPipe;
import com.igormaznitsa.forph.api.routines.ForphRoutine;
import com.igormaznitsa.forph.api.security.ForphCredentials;
import com.igormaznitsa.forph.api.security.ForphSecurity;
import com.igormaznitsa.forph.api.security.WithCredentials;
import com.igormaznitsa.forph.api.stack.ForphPolyStackItem;
import com.igormaznitsa.forph.api.stack.ForphPolyStackTag;
import com.igormaznitsa.forph.api.vocabulary.ForphVocabulary;
import java.io.IOException;
import java.io.Reader;
import java.util.Optional;
import java.util.function.Predicate;

public interface ForphEngine extends Nameable, AutoCloseable, WithCredentials {

  ForphEngineKey getKey();

  Iterable<ForphAddress> allAddresses(ForphCredentials credentials);

  Optional<ForphEngineStatus> findEngineStatus(ForphCredentials credentials, ForphAddress address);

  ForphSecurity getSecurity();

  ForphPolyStackTag makeTag(ForphCredentials credentials, String name,
                            Predicate<ForphPolyStackItem> domainGuard);

  ForphVocabulary newVocabulary(ForphCredentials credentials, String name);

  ForphPipe makePipe(ForphCredentials credentials, String pipeId);

  Optional<ForphAddress> findLocalAddress(ForphCredentials credentials);

  Iterable<ForphPipe> allPipes(ForphCredentials credentials);

  Optional<ForphPipe> findPipe(ForphCredentials credentials, String pipeId);

  Optional<ForphVocabulary> findVocabulary(ForphCredentials credentials, String vocabuleryId);

  Iterable<ForphVocabulary> allVocabularies(ForphCredentials credentials);

  ForphRoutine prepareRoutine(ForphCredentials credentials, String routineId, Reader source)
      throws IOException;

  Iterable<ForphRoutine> allRoutines(ForphCredentials credentials, ForphAddress... addresses);
}
