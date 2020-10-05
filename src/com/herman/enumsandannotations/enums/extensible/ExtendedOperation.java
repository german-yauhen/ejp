package com.herman.enumsandannotations.enums.extensible;

public enum ExtendedOperation implements Operation {

    EXP("^") {
        @Override
        public double apply(double x, double y) {
            return Math.pow(x, y);
        }
    },
    REMAINDER("%") {
        @Override
        public double apply(double x, double y) {
            return x % y;
        }
    };

    ExtendedOperation(String symbol) {
        this.symbol = symbol;
    }

    private final String symbol;


    @Override
    public String toString() {
        return this.symbol;
    }
}
