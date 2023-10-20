package day5_streams.task;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Transaction {

    private Trader trader;
    private String company;
    private int year;
    private double value;

}
