package com.herman.enumsandannotations.enums.specificmethod;

public class Runner {
    public static void main(String[] args) {
        String url = "/cards/consentAgreement?cardId=123";
        RequestType.OPTIONAL.apply(url);

        RequestType.fromString("opTIONAl")
                .ifPresentOrElse(requestType -> requestType.apply(url), () -> System.out.println("There is no appropriate request type."));
    }
}
