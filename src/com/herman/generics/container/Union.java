package com.herman.generics.container;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Union {

    public static <T> Set<T> doUnite(Set<T> firstSet, Set<T> second) {
        HashSet<T> united = new HashSet<>(firstSet);
        united.addAll(second);
        return united;
    }

    public static <T extends Comparable<? super T>> Optional<T> getMax(Collection<T> collection) {
        check(collection);

        return collection.stream().max(Comparator.naturalOrder());
    }

    public static <T extends Comparable<? super T>> Optional<T> getMin(Collection<T> collection) {
        check(collection);

        return collection.stream().min(Comparator.naturalOrder());
    }

    private static <T> void check(Collection<T> collection) {
        if (collection == null) throw new IllegalArgumentException("Collection is not initialized yet!");
    }
}
