package com.herman.enumsandannotations.enums.specificmethod;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum RequestType {

    GET {
        @Override
        void apply(String url) {
            System.out.println("Executing GET request to: " + url);
        }
    },
    POST {
        @Override
        void apply(String url) {
            System.out.println("Executing POST request to: " + url);
        }
    },
    PUT {
        @Override
        void apply(String url) {
            System.out.println("Executing PUT request to: " + url);
        }
    },
    OPTIONAL {
        @Override
        void apply(String url) {
            System.out.println("Executing OPTIONAL request to: " + url);
        }
    };

    abstract void apply(String url);

    private static final Map<String, RequestType> REQUEST_TYPES = Stream.of(values())
            .collect(Collectors.toMap(Object::toString, Function.identity()));

    public static Optional<RequestType> fromString(String requestTypeName) {
        return Optional.ofNullable(REQUEST_TYPES.get(requestTypeName.toUpperCase()));
    }
}
