package day2_functional_interface.appleeren;

public class AppleHeavyPredicate implements ApplePredicate {

    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > 200;
    }
}
