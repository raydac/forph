package com.igormaznitsa.forph;

import com.igormaznitsa.forph.exceptions.ForphEmptyStackException;
import com.igormaznitsa.forph.exceptions.ForphNotEnoughElementsOnStackException;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

public class ForphStack<T> {
    private final long id;
    private final String name;
    private final ForphContext context;
    private List<T> list;

    public ForphStack(
        final ForphContext context,
        final long id,
        final String name,
        final Supplier<List<T>> stackContainerSupplier
    ) {
        this.id = id;
        this.name = Objects.requireNonNull(name);
        this.context = Objects.requireNonNull(context);
        this.list = stackContainerSupplier.get();
    }

    protected void assertNonEmptyStack() {
        if (this.list.isEmpty()) {
            throw new ForphEmptyStackException(this);
        }
    }

    protected void assertStackContainsMoreThan(final int elements) {
        if (this.list.size() < elements) {
            throw new ForphNotEnoughElementsOnStackException(this, String.format("Required %d elements on stack but foud %d", elements, this.list.size()));
        }
    }

    public ForphContext getContext() {
        return this.context;
    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public T pop() {
        this.assertNonEmptyStack();
        return this.list.remove(this.list.size() - 1);
    }

    public T peek() {
        this.assertNonEmptyStack();
        return this.list.get(this.list.size() - 1);
    }

    public ForphStack<T> push(T element) {
        this.list.add(element);
        return this;
    }

    public int size() {
        return this.list.size();
    }

    public ForphStack<T> clear() {
        this.list.clear();
        return this;
    }

    public ForphStack<T> drop() {
        this.assertNonEmptyStack();
        this.list.remove(this.list.size() - 1);
        return this;
    }

    public ForphStack<T> dup() {
        this.assertNonEmptyStack();
        this.list.add(this.list.get(this.list.size() - 1));
        return this;
    }

    public ForphStack<T> over() {
        return this.pick(1);
    }

    public ForphStack<T> pick(int position) {
        this.assertStackContainsMoreThan(position);
        this.list.add(this.list.get(this.list.size() - 1 - position));
        return this;
    }

    public ForphStack<T> roll(int position) {
        if (position != 0) {
            this.assertStackContainsMoreThan(position);
            this.list.add(this.list.remove(this.list.size() - 1 - position));
        }
        return this;
    }

    public ForphStack<T> rot() {
        return this.roll(2);
    }

    public ForphStack<T> swap() {
        this.assertStackContainsMoreThan(2);
        final int first = this.list.size() - 1;
        final int second = this.list.size() - 2;
        this.list.set(second, this.list.set(first, this.list.get(second)));
        return this;
    }
}
