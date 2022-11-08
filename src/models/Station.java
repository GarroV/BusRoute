package models;

import java.util.List;
import java.util.Random;

public class Station {

    private int id = 0;
    private List<Passenger> passengersOnStation;
    Random random = new Random();
    private int passengerSum = (random.nextInt(15)+1);



    public void setStationId(int id) {
        this.id = id;
    }

    public int getStationId() {
        return id;
    }

    public int getPassengerSum() {
            return passengerSum;
    }

    public void setPassengersOnStation(List<Passenger> passengersOnStation) {
        this.passengersOnStation = passengersOnStation;
    }

    public List<Passenger> getPassengersOnStation() {
        return passengersOnStation;
    }

}
