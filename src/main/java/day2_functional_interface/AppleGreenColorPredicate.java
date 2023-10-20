package day2_functional_interface;

public class AppleGreenColorPredicate implements ApplePredicate {

    @Override
    public boolean test(Apple apple) {
        return apple.getColor().equalsIgnoreCase("green");
    }

}
