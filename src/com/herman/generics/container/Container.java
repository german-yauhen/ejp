package com.herman.generics.container;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Container<E> {
    private List<E> container;

    public Container() {
        this.container = new ArrayList<>();
    }

    public void store(E element) {
        check();
        container.add(element);
    }

    public Optional<E> retrieveLast() {
        check();
        return isNotEmptyContainer()
                ? Optional.ofNullable(container.get(container.size() - 1))
                : Optional.empty();
    }

    public boolean hasElements() {
        check();
        return isNotEmptyContainer();
    }

    private boolean isNotEmptyContainer() {
        return !container.isEmpty();
    }

    public void storeAll(Iterable<? extends E> elements) {
        check();
        for (E element: elements) {
            container.add(element);
        }
    }

    private void check() {
        if (container == null) {
            throw new IllegalStateException("Container has not been initialized yet!");
        }
    }
}
