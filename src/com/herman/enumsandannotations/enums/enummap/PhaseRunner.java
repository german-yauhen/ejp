package com.herman.enumsandannotations.enums.enummap;

public class PhaseRunner {
    public static void main(String[] args) {
        Phase.Transaction transaction = Phase.Transaction.getTransaction(Phase.GAS, Phase.SOLID);
        System.out.println(transaction.getFrom() + " -> " + transaction.getTo());
    }
}
