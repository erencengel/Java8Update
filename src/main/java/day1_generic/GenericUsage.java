package day1_generic;

import java.util.ArrayList;
import java.util.List;

public class GenericUsage {

    public static void main(String[] args) {

        List things = new ArrayList<>();
        things.add("Java");
        things.add(null);
        things.add(3);
        things.add(3.14);

        //since they are all seen as objects, substring will not work
        //object types does not have access to substring
        //things.get(0).substring(0,3);

        //defining jeneric
        //using the jeneric
        //we need a TYPE PROTECTION
        //generic allows us to use certain objects
        //generics like a parameter for class or objects

        //FUNCTIONAL PROGRAMMING --> DIRECTLY IMPLEMENTATION WITH INTERFACES, IT ALLOWS TO MAKE SOME ACTIONS DIRECTLY
        //LAMBDA --> WE ARE NOT USING CLASS OR OBJECT, WE ARE DIRECTLY MAKING ACTIONS WITH LAMBDA
    }

}
