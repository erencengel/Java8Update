package day2_functional_interface;

@FunctionalInterface
//that means that there can be only one abstract method
public interface ApplePredicate {

    boolean test(Apple apple);

}
