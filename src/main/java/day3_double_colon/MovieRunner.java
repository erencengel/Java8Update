package day3_double_colon;

import java.util.*;

public class MovieRunner {

    public static void main(String[] args) {
        List<Movie> movies = new ArrayList<>(Arrays.asList(
                new Movie("Star Wars: Episode IV – A New Hope", 1977, 8.6),
                new Movie("Avatar", 2009, 7.9),
                new Movie("Iron Man", 2008, 7.9),
                new Movie("The Dark Knight", 2008, 9.0),
                new Movie("Rocky",1976, 8.1)
        ));

        System.out.println("--------------Original Data----------------");
        movies.forEach(System.out::println); // (movie) -> System.out.println(movie)

        System.out.println("--------------sort by year in ascending order----------------");
        movies.sort(Comparator.comparing(movie -> movie.getYear()));
        //movies.sort(Comparator.comparing(Movie::getYear));
        movies.forEach(System.out::println);

        System.out.println("--------------sort by year in descending order----------------");
        movies.sort(Comparator.comparing(Movie::getYear).reversed());
        movies.forEach(System.out::println);

        System.out.println("--------------sort by highest rated movie----------------");
        //movies.sort(Comparator.comparing(movie -> movie.getRating()).reversed());
        movies.sort(Comparator.comparing(Movie::getRating).reversed());
        movies.forEach(System.out::println);

        System.out.println("--------------sort the names alphabetically----------------");
        movies.sort(Comparator.comparing(movie -> movie.getName()));
        movies.sort(Comparator.comparing(Movie::getName));

        System.out.println("--------------comparable----------------");
        //COMPARABLE
        List<Movie_Comparable> movies1 = new ArrayList<>(Arrays.asList(
                new Movie_Comparable("Star Wars: Episode IV – A New Hope", 1998, 8.6),
                new Movie_Comparable("Avatar", 1960, 7.9),
                new Movie_Comparable("Iron Man", 2000, 7.9),
                new Movie_Comparable("The Dark Knight", 1950, 9.0),
                new Movie_Comparable("Rocky",2023, 8.1)
        ));
        Collections.sort(movies1);
        movies1.forEach(System.out::println);
    }
}
