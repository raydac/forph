package com.igormaznitsa.forph;

import java.util.Optional;

@FunctionalInterface
public interface FrphExecutor {
  void execute(FrphContext context, FrphWord word, Optional<FrphReader> inputStream);
}
