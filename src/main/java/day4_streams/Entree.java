package day4_streams;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Entree {

    private String name;
    private int calories;
    private boolean isVegetarian;

}
