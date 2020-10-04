package com.herman.enumsandannotations.enums;

public enum PayrollDay {

    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY,
    SATURDAY(PaymentType.WEEKEND), SUNDAY(PaymentType.WEEKEND);

    @Deprecated
    private static final int MINUTES_PER_WORKING_SHIFT = 8 * 60;

    @Deprecated
    private double payment(int workedMinutes, int paymentRate) {
        int basePayment = workedMinutes * paymentRate;

        int overtimePayment;
        switch (this) {
            case SATURDAY:
            case SUNDAY:
                overtimePayment = basePayment / 2;
                break;
            default:
                overtimePayment = workedMinutes <= MINUTES_PER_WORKING_SHIFT
                        ? 0
                        : (workedMinutes - MINUTES_PER_WORKING_SHIFT) * paymentRate / 2;
        }
        return basePayment + overtimePayment;
    }

    public double doPayment(int workedMinutes, int paymentRate) {
        return this.paymentType.payment(workedMinutes, paymentRate);
    }

    private PaymentType paymentType;

    private PayrollDay() {
        this(PaymentType.WEEKDAY);
    }

    private PayrollDay(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    /**
     * This Enum represents a strategy enum pattern
     */
    private enum PaymentType {
        WEEKDAY {
            @Override
            int overtimePayment(int workedMinutes, int paymentRate) {
                return workedMinutes > MINUTES_PER_WORKING_SHIFT
                        ? (workedMinutes - MINUTES_PER_WORKING_SHIFT) * paymentRate / 2
                        : 0;
            }
        },
        WEEKEND {
            @Override
            int overtimePayment(int workedMinutes, int paymentRate) {
                return workedMinutes * paymentRate / 2;
            }
        };

        private static final int MINUTES_PER_WORKING_SHIFT = 8 * 60;

        abstract int overtimePayment(int workedMinutes, int paymentRate);

        private double payment(int workedMinutes, int paymentRate) {
            double basePayment = workedMinutes * paymentRate;
            return basePayment + overtimePayment(workedMinutes, paymentRate);
        }
    }
}
