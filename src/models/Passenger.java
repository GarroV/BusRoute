package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Passenger {

    Random random = new Random();
    private int finalDestination = (random.nextInt(5)+1);

    public int getFinalDestination() {
        return finalDestination;
    }

    public static List<Passenger> generatePassengers(int passengerSum) {

        List<Passenger> passengers = new ArrayList<>();

        for (int i = 1; i <= passengerSum; i++) {
            Passenger passenger = new Passenger();
            passengers.add(i-1,passenger);

            System.out.println("Generated passenger #" + i + " with final destination " + passenger.getFinalDestination());

        }
        System.out.println();
        return passengers;
    }

}
