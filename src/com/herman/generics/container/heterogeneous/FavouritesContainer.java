package com.herman.generics.container.heterogeneous;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class FavouritesContainer {

    private final Map<Class<?>, Object> container;

    public FavouritesContainer() {
        this.container = new HashMap<>();
    }

    public <T> void putFavourite(Class<T> type, T instance) {
        check(type);

        container.putIfAbsent(type, type.cast(instance));
    }

    public <T> Optional<T> getFavourite(Class<T> type) {
        check(type);

        return Optional.ofNullable(container.get(type)).map(type::cast);
    }

    private <T> void check(Class<T> type) {
        if (type == null) throw new IllegalArgumentException("Type can not be null!");
    }
}
