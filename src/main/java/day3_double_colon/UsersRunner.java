package day3_double_colon;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class UsersRunner {

    public static void main(String[] args) {

        List<User> users = new ArrayList<>();
        users.add(new User("jbond", "007"));
        users.add(new User("javalover", "java"));
        users.add(new User("sdetFan", "testing"));
        users.add(new User("programmingIsFun", "java"));

        users.forEach(user -> System.out.println(user)); // lambda
        users.forEach(System.out::println); //method reference

        users.removeIf(p -> p.getPassword().equals("java"));
        users.forEach(System.out::println);

        BiFunction<String,String, User> createUser = (user, pass) -> new User(user,pass);
        User newUser = createUser.apply("catsAreTheBest", "noDogs");

        BiFunction<String,String, User> createUser2 = User::new;
        User newUser2 = createUser2.apply("alperen", "aslıhan");

    }
}
