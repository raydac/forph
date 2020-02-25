package com.igormaznitsa.forph;

import static java.util.Objects.requireNonNull;


import com.igormaznitsa.forph.security.ForphAccessLevel;
import java.util.ArrayList;
import java.util.List;

public class ForphContext {
    private final String name;
    private final ForphStack<Long> dataStack;
    private final ForphStack<Long> returnStack;
    private final ForphSecurityManager securityManager;
    private final List<ForphVocabulary> vocabularies = new ArrayList<>();

    public ForphContext(final String name, final ForphSecurityManager securityManager) {
        this.securityManager = requireNonNull(securityManager);
        this.name = requireNonNull(name);
        this.dataStack = new ForphStack<>(this, 0, "d", () -> new ArrayList<>(8));
        this.returnStack = new ForphStack<>(this, 0, "r", () -> new ArrayList<>(8));
    }

    public ForphSecurityManager getSecurityManager() {
        return this.securityManager;
    }

    public String getName() {
        return this.name;
    }

    public ForphWord find(final ForphAccessLevel accessLevel, final String... name) {
        ForphWord result = null;
        for (final ForphVocabulary v : this.vocabularies) {
            if (this.securityManager.isAccessible(accessLevel, v)) {
                result = v.find(name);
            }
            if (result != null) {
                break;
            }
        }
        return result;
    }
}
