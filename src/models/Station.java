package models;

import java.util.List;
import java.util.Random;

public class Station {

    private int id = 0;
    private List<Passenger> passengersOnStation;
    Random random = new Random();
    private int passengerSum = (random.nextInt(10)+1);



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



    /**public  List<Station> generateStations() {

        List<Station> stations = null;
        for (int i = 1; i < 6; i++) {
            Station station = new Station();
            setStationId(i);
            station.setPassengersOnStation(station.generatePassengers(station.getPassengerSum()));
            stations.add(i-1, station);

            System.out.println("Generated station #" + station.getStationId() + " with " + station.getPassengerSum() + "passengers.");
        }
        return stations;
    }**/

    public List<Passenger> generatePassengers(int passengerSum) {

        List<Passenger> passengers = null;

        for (int i = 1; i <= passengerSum; i++) {
            Passenger passenger = new Passenger();
            passengers.add(i-1,passenger);

            System.out.println("Generated passenger #" + i + "with final destination " + passenger.getFinalDestination());

        }
        return passengers;
    }
}
