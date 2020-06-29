package com.igormaznitsa.forph;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public final class ForphVocabularyStack {
    private final List<ForphVocabulary> vocabularyList;
    private final ForphVocabulary baseVocab;
    private final ForphContext context;

    ForphVocabularyStack(final ForphContext context, final ForphVocabulary baseVocabulary) {
        assert baseVocabulary != null : "Base FORPH vocabulary must be provide";
        assert context != null : "Context must not be null";

        this.context = context;
        this.baseVocab = baseVocabulary;
        this.vocabularyList = new ArrayList<>();
    }

    public Optional<ForphVocabulary> activate(final String name) {
        assert name != null : "Name can't be null";
        Optional<ForphVocabulary> vocabulary = this.find(name);
        vocabulary.ifPresent(x -> {
            this.vocabularyList.remove(x);
            this.vocabularyList.add(0, x);
        });
        return vocabulary;
    }

    Optional<ForphVocabulary> find(final String name) {
        assert name != null : "Name must not be null";
        return this.vocabularyList.stream().filter(x -> x.getName().equals(name)).findFirst();
    }

    ForphVocabulary add(final String name, final int callerRing) {
        assert name != null : "Name can't be null";
        this.find(name)
            .ifPresent(voc -> {
                throw new IllegalArgumentException("Vocabulary already presented: " + name);
            });
        return this.find(name)
            .orElseGet(() -> {
                final ForphVocabulary newVocabulary = new ForphVocabulary(name, callerRing);
                this.vocabularyList.add(0, newVocabulary);
                return newVocabulary;
            });
    }

    Optional<ForphVocabulary> current() {
        return this.vocabularyList.stream().filter(this.context::isAccessible).findFirst();
    }

    boolean forget(final String... name) {
        assert name.length > 0 : "Name can't be empty";
        final Optional<ForphWord> word = this.findWord(name);
        word.ifPresent(x -> {
            vocabularyList.forEach(y -> y.forget(x));
        });
        return word.isPresent();
    }

    Optional<ForphWord> findWord(final String... name) {
        assert name.length > 0 : "Name can't be empty";
        for (final ForphVocabulary v : this.vocabularyList) {
            if (this.context.isAccessible(v)) {
                final Optional<ForphWord> foundWord = v.find(name);
                if (foundWord.isPresent()) {
                    this.vocabularyList.remove(v);
                    this.vocabularyList.add(0, v);
                    return foundWord;
                }
            }
        }
        return this.baseVocab.find(name);
    }
}
