package com.ivmaly;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PuttingIntoPractice {

    public static void main(String... args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        // Задача 1
        // Найти все транзакции за 2011 год и отсортировать их по сумме от меньшей к большей
        transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .forEach(System.out::println);
        System.out.println();

        // Задача 2
        // Вывести список неповторяющихся городов, в которых работают трейдеры
        transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);
        System.out.println();

        // Задача 3
        // Найти всех трейдеров из Кембриджа и отсортировать их по именам
        transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> "Cambridge".equals(trader.getCity()))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .forEach(System.out::println);
        System.out.println();

        // Задача 4
        // Вернуть строку со всеми именами трейдеров, отсортированными в алфавитном порядке
        String traderNames = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.joining(", "));
        System.out.println(traderNames);
        System.out.println();

        // Задача 5
        // Выяснить, существует ли хоть один трейдер из Милана
        boolean hasMilanTrader = transactions.stream()
                .anyMatch(transaction -> "Milan".equals(transaction.getTrader().getCity()));
        System.out.println(hasMilanTrader);
        System.out.println();

        // Задача 6
        // Вывести суммы всех транзакций трейдеров из Кембриджа
        transactions.stream()
                .filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity()))
                .map(Transaction::getValue)
                .forEach(System.out::println);
        System.out.println();

        // Задача 7
        // Какова максимальная сумма среди всех транзакций?
        int maxTransactionValue = transactions.stream()
                .mapToInt(Transaction::getValue)
                .max()
                .orElse(0);
        System.out.println(maxTransactionValue);
        System.out.println();

        // Задача 8
        // Найти транзакцию с минимальной суммой
        Transaction minTransaction = transactions.stream()
                .min(Comparator.comparing(Transaction::getValue))
                .orElse(null);
        System.out.println(minTransaction);
        System.out.println();
    }
}
