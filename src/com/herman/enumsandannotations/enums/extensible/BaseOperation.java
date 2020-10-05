package com.herman.enumsandannotations.enums.extensible;

public enum BaseOperation implements Operation {

    PLUS("+") {
        @Override
        public double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS("-") {
        @Override
        public double apply(double x, double y) {
            return x - y;
        }
    },
    MULTIPLY("*") {
        @Override
        public double apply(double x, double y) {
            return x * y;
        }
    },
    DIVIDE("/") {
        @Override
        public double apply(double x, double y) {
            return x / y;
        }
    };

    private String symbol;

    BaseOperation(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }

    public static BaseOperation inverse(BaseOperation baseOperation) {
        switch (baseOperation) {
            case PLUS:
                return BaseOperation.MINUS;
            case MINUS:
                return BaseOperation.PLUS;
            case DIVIDE:
                return BaseOperation.MULTIPLY;
            case MULTIPLY:
                return BaseOperation.DIVIDE;
            default:
                throw new IllegalArgumentException("Illegal operation!");
        }
    }
}
