package com.herman.enumsandannotations.enums.specificmethod;

import com.herman.enumsandannotations.enums.PayrollDay;

public class PayrollRunner {
    public static void main(String[] args) {
        int paymentPerMinute = 15;
        double fridayPayment = PayrollDay.FRIDAY.doPayment(480, paymentPerMinute);
        double sundayPayment = PayrollDay.SUNDAY.doPayment(480, paymentPerMinute);
        System.out.println("Friday: " + fridayPayment);
        System.out.println("Sunday: " + sundayPayment);
    }
}
