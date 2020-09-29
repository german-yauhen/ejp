package com.herman.generics.container;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ScheduledFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ContainerRunner {

    public static void main(String[] args) {
        Container<Number> numberContainer = new Container<>();

        System.out.println(numberContainer.hasElements());

        List<Integer> integers = IntStream.rangeClosed(1, 10)
                .boxed()
                .collect(Collectors.toList());

        numberContainer.storeAll(integers);

        System.out.println(numberContainer.hasElements());

        numberContainer.retrieveLast().ifPresent(System.out::println);

        Union.getMax(integers)
                .ifPresentOrElse(System.out::println, () -> System.out.println("No value!"));

        Union.getMin(integers)
                .ifPresentOrElse(System.out::println, () -> System.out.println("No value!"));

        List<Integer> empty = Collections.<Integer>emptyList();
        Union.getMax(empty)
                .ifPresentOrElse(System.out::println, () -> System.out.println("No value!"));

        Union.getMin(empty)
                .ifPresentOrElse(System.out::println, () -> System.out.println("No value!"));

        List<ScheduledFuture<?>> scheduledFutureList = new ArrayList<>();
        Union.getMax(scheduledFutureList)
                .ifPresentOrElse(System.out::println, () -> System.out.println("No value!"));
    }
}
