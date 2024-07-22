package com.ivmaly;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PuttingIntoPractice {

    public static void main(String... args) {
        List<Transaction> transactions = getTransactions();

        // Task 1
        // Find all transactions in 2011 and sort them by value from low to high
        System.out.println("Task 1: Find all transactions in 2011 and sort them by value from low to high");
        transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .forEach(System.out::println);
        System.out.println();

        // Task 2
        // Print a list of unique cities where the traders work
        System.out.println("Task 2: Print a list of unique cities where the traders work");
        transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);
        System.out.println();

        // Task 3
        // Find all traders from Cambridge and sort them by name
        System.out.println("Task 3: Find all traders from Cambridge and sort them by name");
        transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> "Cambridge".equals(trader.getCity()))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .forEach(System.out::println);
        System.out.println();

        // Task 4
        // Return a string with all traders' names, sorted alphabetically
        System.out.println("Task 4: Return a string with all traders' names, sorted alphabetically");
        String traderNames = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.joining(", "));
        System.out.println(traderNames);
        System.out.println();

        // Task 5
        // Check if there is any trader from Milan
        System.out.println("Task 5: Check if there is any trader from Milan");
        boolean hasMilanTrader = transactions.stream()
                .anyMatch(transaction -> "Milan".equals(transaction.getTrader().getCity()));
        System.out.println(hasMilanTrader);
        System.out.println();

        // Task 6
        // Print the values of all transactions of traders from Cambridge
        System.out.println("Task 6: Print the values of all transactions of traders from Cambridge");
        transactions.stream()
                .filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity()))
                .map(Transaction::getValue)
                .forEach(System.out::println);
        System.out.println();

        // Task 7
        // What is the maximum value among all transactions?
        System.out.println("Task 7: What is the maximum value among all transactions?");
        int maxTransactionValue = transactions.stream()
                .mapToInt(Transaction::getValue)
                .max()
                .orElse(0);
        System.out.println(maxTransactionValue);
        System.out.println();

        // Task 8
        // Find the transaction with the minimum value
        System.out.println("Task 8: Find the transaction with the minimum value");
        Transaction minTransaction = transactions.stream()
                .min(Comparator.comparing(Transaction::getValue))
                .orElse(null);
        System.out.println(minTransaction);
        System.out.println();
    }

    private static List<Transaction> getTransactions() {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        return Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
    }
}
