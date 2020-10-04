package com.herman.enumsandannotations.enums.augmenting;

public class OperationRunner {
    public static void main(String[] args) {
        double multiplyResult = Operation.MULTIPLY.apply(127, 127);
        double divideResult = Operation.inverse(Operation.MULTIPLY).apply(127, 127);

        System.out.println(multiplyResult);
        System.out.println(divideResult);
    }
}
