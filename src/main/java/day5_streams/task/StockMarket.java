package day5_streams.task;

import java.util.*;
import java.util.stream.Collectors;

public class StockMarket {

    public static void main(String[] args) {

        Trader[] traders = {
                new Trader("David", "Virginia"),
                new Trader("Jika", "Chicago"),
                new Trader("Mark", "New York"),
                new Trader("Maria", "New York"),
                new Trader("Emre", "Chicago"),
                new Trader("Olesea", "New York"),
                new Trader("Alma", "Virginia"),
        };

        List<Transaction> transactions = new ArrayList<>(Arrays.asList(
                new Transaction(traders[0], "Apple", 2019, 1000),
                new Transaction(traders[3], "Tesla", 2020, 2500),
                new Transaction(traders[2], "Meta", 2022, 1200),
                new Transaction(traders[1], "Uber", 2018, 400),
                new Transaction(traders[4], "Ford", 2019, 1400),
                new Transaction(traders[2], "Amazon", 2023, 3400),
                new Transaction(traders[6], "Apple", 2020, 1300),
                new Transaction(traders[5], "Meta", 2018, 700),
                new Transaction(traders[4], "Meta", 2019, 600),
                new Transaction(traders[6], "Ford", 2019, 340),
                new Transaction(traders[2], "Uber", 2020, 890),
                new Transaction(traders[3], "Apple", 2020, 1290),
                new Transaction(traders[1], "Uber", 2023, 820),
                new Transaction(traders[0], "Amazon", 2017, 1230),
                new Transaction(traders[5], "Uber", 2016, 980),
                new Transaction(traders[3], "Ford", 2018, 650),
                new Transaction(traders[6], "Meta", 2023, 1320),
                new Transaction(traders[0], "Tesla", 2023, 2300)
        ));


        System.out.println("--------all the transactions in 2020 and sort by highest value-----------");
        transactions.stream()
                .filter(p -> p.getYear() == 2020)
                .sorted(Comparator.comparing(Transaction::getValue).reversed())
                //.sorted(Comparator.comparing(p -> p.getValue()).reversed())
                .forEach(System.out::println);

        System.out.println("--------find 3 biggest transactions-----------");
        transactions.stream()
                .sorted(Comparator.comparing(Transaction::getValue).reversed())
                .limit(3)
                .map(Transaction::getValue)
                .forEach(System.out::println);

        System.out.println("--------find the company's name with the smallest 2 transactions-----------");
        transactions.stream()
                .sorted(Comparator.comparing(Transaction::getValue))
                .limit(2)
                .map(p -> p.getValue() + " - " + p.getCompany())
                .forEach(System.out::println);

        System.out.println("--------find all the cities trades were made in-----------");
        transactions.stream()
                .map(p -> p.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);

        System.out.println("--------find all the transactions of Meta-----------");
        transactions.stream()
                .filter(p -> p.getCompany() == "Meta")
                .map(Transaction::getValue)
                .forEach(System.out::println);

        System.out.println("--------find all the traders that are from New York-----------");
        transactions.stream()
                .filter(p -> p.getTrader().getCity() == "New York")
                //.map(p -> p.getTrader().getName())
                .distinct()
                .forEach(System.out::println);

        System.out.println("--------find all the trader's names that are from Chicago-----------");
        transactions.stream()
                .filter(p -> p.getTrader().getCity() == "Chicago")
                .map(p -> p.getTrader().getName())
                .distinct()
                .forEach(System.out::println);

        System.out.println("--------find all the trader's names and sort them alphabetically-----------");
        transactions.stream()
                .map(p -> p.getTrader().getName())
                .distinct()
                .sorted()
                .forEach(System.out::println);

        System.out.println("--------find if there is any Traders from Los Angeles-----------");
        System.out.println(transactions.stream().anyMatch(p -> p.getTrader().getCity().equalsIgnoreCase("Los Angeles")));

        System.out.println("--------find the values of the transactions Mark was involved in-----------");
        transactions.stream()
                .filter(p -> p.getTrader().getName().equalsIgnoreCase("Mark"))
                .map(Transaction::getValue)
                .forEach(System.out::println);

        System.out.println("----------------\nNew Topics");
        System.out.println("----------------toMap------------");
        Map<String, String> traderMap = Arrays.stream(traders)
                .collect(Collectors.toMap(Trader::getName, Trader::getCity)); //name is the key, city is the value
        System.out.println(traderMap);

        System.out.println("----------------groupingBy - trader's transactions------------");
        Map<Trader,List<Transaction>> tradersGroupMap = transactions.stream()
                .collect(Collectors.groupingBy(Transaction::getTrader)); // transaction -> transaction.getTrader()
        tradersGroupMap.forEach((k,v) -> {
            System.out.println(k + " " + v);
        });

        System.out.println("----------------groupingBy - company------------");
        Map<String, List<Transaction>> companyMap = transactions.stream()
                .collect(Collectors.groupingBy(Transaction::getCompany));

        companyMap.forEach((k,v) -> {
            System.out.println(k + " " + v);
        });

        System.out.println("----------------groupingBy - year------------");
        Map<Integer, List<Transaction>> yearMap = transactions.stream()
                .collect(Collectors.groupingBy(Transaction::getYear));

        yearMap.forEach((k,v) -> {
            System.out.println(k + " " + v);
        });

        System.out.println("----------------normal flow------------");
        // most normal flow
        List<Integer> nums = new ArrayList<>(Arrays.asList(4,2,4,3,7,9,2,3,4,5,9,13));
        System.out.println(nums.stream().filter(p -> p % 2 == 0).distinct().collect(Collectors.toList()));
        //how many distint even number we have
        System.out.println(nums.stream().filter(p -> p % 2 == 0).distinct().count());
    }
}
