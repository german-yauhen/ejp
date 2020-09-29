package com.herman.generics.container.heterogeneous;

import java.math.BigDecimal;

public class Runner {
    public static void main(String[] args) {
        FavouritesContainer container = new FavouritesContainer();

        container.putFavourite(Integer.class, Integer.MAX_VALUE);
        container.putFavourite(String.class, "FAVOURITE");
        container.putFavourite(BigDecimal.class, BigDecimal.TEN);

        container.getFavourite(Integer.class).ifPresent(System.out::println);
        container.getFavourite(String.class).ifPresent(System.out::println);
        container.getFavourite(BigDecimal.class).ifPresent(System.out::println);
        container.getFavourite(Double.class)
                .ifPresentOrElse(System.out::println, () -> System.out.println("There is no value!"));

        container.putFavourite(Float.class, null);
        container.getFavourite(Float.class)
                .ifPresentOrElse(System.out::println, () -> System.out.println("There is no value!"));

        Float minNormal = Float.MIN_NORMAL;
        container.putFavourite(Float.class, minNormal);
        container.getFavourite(Float.class)
                .ifPresentOrElse(System.out::println, () -> System.out.println("There is no value!"));
    }
}
