package day6_optional;

import day5_streams.task.Trader;
import day5_streams.task.Transaction;

import java.util.*;

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

        System.out.println("------- sum of all the transactions --------");
        double sumOfAll = transactions.stream()
                .mapToDouble(Transaction::getValue)
                .sum();
        System.out.println(sumOfAll);

        System.out.println("------- sum of all the transactions in 2020 --------");
        double sumOf2020 = transactions.stream()
                .filter(p -> p.getYear() == 2020)
                .mapToDouble(Transaction::getValue)
                .sum();
        System.out.println(sumOf2020);

        System.out.println("------- find the average of David's transactions --------");
        OptionalDouble davidAvg = transactions.stream()
                .filter(p -> p.getTrader().getName().equalsIgnoreCase("David"))
                .mapToDouble(Transaction::getValue)
                .average();
        System.out.println(davidAvg);
        System.out.println(davidAvg.getAsDouble());

        System.out.println("------- find the average of James's transactions --------");
        OptionalDouble jamesAvg = transactions.stream()
                .filter(p -> p.getTrader().getName().equalsIgnoreCase("James"))
                .mapToDouble(Transaction::getValue)
                .average();
        System.out.println(jamesAvg);
        //System.out.println(jamesAvg.getAsDouble()); --> will not work
        jamesAvg.ifPresent(System.out::println); // no exception, will give empty string

        System.out.println("------- find Tesla' biggest trnsaction --------");
        OptionalDouble teslaMax = transactions.stream()
                .filter(p -> p.getCompany().equalsIgnoreCase("tesla"))
                .mapToDouble(Transaction::getValue)
                .max();
        System.out.println(teslaMax);
        System.out.println(teslaMax.getAsDouble());

        System.out.println("------- find Tesla' biggest transaction --------");
        double teslaMax2 = transactions.stream()
                .filter(p -> p.getCompany().equalsIgnoreCase("tesla"))
                .mapToDouble(Transaction::getValue)
                .max()
                .orElse(0);
        System.out.println(teslaMax2);

        System.out.println("------- find Cydeo's biggest transaction --------");
        double cydeoMax = transactions.stream()
                .filter(p -> p.getCompany().equalsIgnoreCase("cydeo"))
                .mapToDouble(Transaction::getValue)
                .max()
                .orElse(0);
        System.out.println(cydeoMax);

        System.out.println("------- find the smallest transaction in new york --------");
        double smallestNewYork = transactions.stream()
                .filter(p -> p.getTrader().getCity().equalsIgnoreCase("new york"))
                .mapToDouble(Transaction::getValue)
                .min()
                .orElseThrow();
        System.out.println(smallestNewYork);

        System.out.println("------- find the smallest transaction in cydeo --------");
        /*double smallestCydeo = transactions.stream()
                .filter(p -> p.getTrader().getCity().equalsIgnoreCase("cydeo"))
                .mapToDouble(Transaction::getValue)
                .min()
                .orElseThrow();
        System.out.println(smallestCydeo);*/ //will throw exception

        System.out.println("------- with reduce --------");
        Optional<Double> maxWithReduce = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Double::max);
        System.out.println(maxWithReduce);
        System.out.println(maxWithReduce.get());
    }
}
