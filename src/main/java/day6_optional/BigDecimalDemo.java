package day6_optional;

import java.math.BigDecimal;

public class BigDecimalDemo {

    public static void main(String[] args) {
        double d = 10.99;
        double d2 = 2.55;
        System.out.println(d-d2);

        BigDecimal d3 = new BigDecimal("10.99");
        BigDecimal d4 = new BigDecimal("2.55");
        System.out.println(d3.subtract(d4));
    }

}
