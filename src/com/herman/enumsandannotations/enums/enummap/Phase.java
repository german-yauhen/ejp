package com.herman.enumsandannotations.enums.enummap;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Phase {
    SOLID, LIQUID, GAS;

    public enum Transaction {
        MELT(SOLID, LIQUID),
        FREEZE(LIQUID, SOLID),
        BOIL(LIQUID, GAS),
        CONDENSE(GAS, LIQUID),
        SUBLIME(SOLID, GAS),
        DEPOSIT(GAS, SOLID);

        private Phase from;
        private Phase to;

        Transaction(Phase from, Phase to) {
            this.from = from;
            this.to = to;
        }

        public Phase getFrom() {
            return from;
        }

        public Phase getTo() {
            return to;
        }

        private static final Map<Phase, Map<Phase, Transaction>> phaseTransactions =
                Stream.of(values()).collect(
                        Collectors.groupingBy(
                                Transaction::getFrom,
                                () -> new EnumMap<>(Phase.class),
                                Collectors.toMap(
                                        Transaction::getTo,
                                        Function.identity(),
                                        (from, to) -> to,
                                        () -> new EnumMap<>(Phase.class)
                                )
                        )
                );

        public static Transaction getTransaction(Phase from, Phase to) {
            return phaseTransactions.get(from).get(to);
        }
    }
}
