package com.igormaznitsa.forph.api.engine;

import com.igormaznitsa.forph.api.identifiers.EngineIdentifier;
import com.igormaznitsa.forph.api.identifiers.Identifiable;
import com.igormaznitsa.forph.api.identifiers.Identifier;
import com.igormaznitsa.forph.api.identifiers.RoutineIdentifier;
import com.igormaznitsa.forph.api.identifiers.TagIdentifier;
import com.igormaznitsa.forph.api.identifiers.VocabularyIdentifier;
import com.igormaznitsa.forph.api.network.ForphAddress;
import com.igormaznitsa.forph.api.network.ForphEngineKey;
import com.igormaznitsa.forph.api.routines.ForphPipe;
import com.igormaznitsa.forph.api.routines.ForphRoutine;
import com.igormaznitsa.forph.api.security.ForphCredentials;
import com.igormaznitsa.forph.api.security.ForphSecurity;
import com.igormaznitsa.forph.api.security.WithCredentials;
import com.igormaznitsa.forph.api.stack.ForphPolyStackItem;
import com.igormaznitsa.forph.api.stack.ForphPolyStackTag;
import com.igormaznitsa.forph.api.vocabulary.ForphVocabulary;
import java.io.Reader;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;

public interface ForphEngine
    extends Identifiable<EngineIdentifier>, AutoCloseable, WithCredentials {

  ForphEngineKey getKey();

  Iterable<ForphAddress> allAddresses(ForphCredentials credentials);

  Optional<ForphEngineStatus> findEngineStatus(ForphCredentials credentials, ForphAddress address);

  ForphSecurity getSecurity();

  ForphPolyStackTag makeTag(ForphCredentials credentials, TagIdentifier tagId,
                            Predicate<ForphPolyStackItem> domainGuard);

  ForphVocabulary makeVocabulary(ForphCredentials credentials, VocabularyIdentifier vocabularyId);

  ForphPipe makePipe(ForphCredentials credentials, Identifier pipeId);

  Optional<ForphAddress> findLocalAddress(ForphCredentials credentials);

  Iterable<ForphPipe> allPipes(ForphCredentials credentials);

  Optional<ForphPipe> findPipe(ForphCredentials credentials, Identifier pipeId);

  Optional<ForphVocabulary> findVocabulary(ForphCredentials credentials,
                                           VocabularyIdentifier vocabularyId);

  Iterable<ForphVocabulary> allVocabularies(ForphCredentials credentials);

  ForphRoutine prepareRoutine(ForphCredentials credentials, RoutineIdentifier routineId,
                              Reader source);

  Iterable<ForphRoutine> allRoutines(ForphCredentials credentials, Set<ForphAddress> addresses);
}
