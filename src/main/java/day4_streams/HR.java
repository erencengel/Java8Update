package day4_streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class HR {

    public static void main(String[] args) {

        List<Application> applications = new ArrayList<>(Arrays.asList(
                new Application("Molly", 100000, true),
                new Application("James", 110000, false),
                new Application("Emre", 120000, true),
                new Application("Oleg", 120000, false),
                new Application("Ella", 95000, true),
                new Application("Poppy", 135000, true)
        ));

        System.out.println("--------------applications willing to relocate------------");
        applications
                .stream()
                .filter(Application::isWillingToRelocate)
                //.filter(p -> p.isWillingToRelocate());
                .forEach(System.out::println);

        System.out.println("--------------applications willing to relocate - show their names------------");
        applications
                .stream()
                .filter(Application::isWillingToRelocate)
                .map(Application::getName)
                //.map(application -> application.getName())
                .forEach(System.out::println);

        System.out.println("--------------applications are expecting less than 125,000------------");
        applications
                .stream()
                .filter(p -> p.getExpectedSalary() < 125_000)
                .forEach(System.out::println);

        System.out.println("--------------applications are expecting less than 125,000 && willing to relocate------------");
        applications
                .stream()
                .filter(Application::isWillingToRelocate)
                .filter(p -> p.getExpectedSalary() < 125_000)
                .forEach(System.out::println);

        System.out.println("--------------applications sorted by salaries lowest to highest------------");
        applications
                .stream()
                .sorted(Comparator.comparing(Application::getExpectedSalary)) // app -> app.getExpectedSalary()
                .forEach(System.out::println);
    }
}
