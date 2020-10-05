package com.herman.enumsandannotations.annotations.exc;

import java.util.ArrayList;
import java.util.List;

public class Sample {

    @ExceptionsTest(values = {ArithmeticException.class})
    public static void divideByZero() {
        int i = 5 / 0;
    }

    @ExceptionsTest(values = {ArithmeticException.class})
    public static void divide() {
        double x = 1.0 / 2;
    }

    @ExceptionsTest(values = {ArithmeticException.class})
    public static void doNothing() {
    }

    @ExceptionsTest(values = {
            IndexOutOfBoundsException.class,
            NullPointerException.class
    })
    public static void doublyBad() {
        List<Object> objects = new ArrayList<>();
        objects.addAll(5, null);
    }

}
