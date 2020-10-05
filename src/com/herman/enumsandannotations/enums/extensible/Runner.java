package com.herman.enumsandannotations.enums.extensible;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        double x = 15;
        double y = 5;
        test(BaseOperation.class, x, y);
        test(ExtendedOperation.class, x, y);

        test(Arrays.asList(BaseOperation.values()), x, y);
        test(Arrays.asList(ExtendedOperation.values()), x, y);
    }

    private static <T extends Enum<T> & Operation> void test(Class<T> opEnumType, double x, double y) {
        T[] enumConstants = opEnumType.getEnumConstants();
        test(List.of(enumConstants), x, y);
    }

    private static void test(Collection<? extends Operation> operations, double x, double y) {
        operations.forEach(enumConstant -> {
            System.out.printf("%f %s %f = %f%n",
                    x, enumConstant.toString(), y, enumConstant.apply(x, y));
        });
    }
}
