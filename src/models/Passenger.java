package models;

import java.util.Random;

public class Passenger {

    Random random = new Random();
    private int finalDestination = (random.nextInt(5)+1);

    public int getFinalDestination() {
        return finalDestination;
    }

}
