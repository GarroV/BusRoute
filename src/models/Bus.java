package models;

import models.Station;
import java.util.List;

public class Bus {

    private int price = 5;
    private int capacity = 30;
    private List<Station> stations;
    private List<Passenger> passengers;
    private List<Passenger> passengersToExit;




    public void run() {

        this.stations = generateStations();

    }




    public void setStations(List<Station> stations) {
        this.stations = stations;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }



    public List<Passenger> askPassengersToExit() {
        List<Passenger> passengersToExit;



    }
    public  List<Station> generateStations() {

        List<Station> stations = null;
        for (int i = 1; i < 6; i++) {
            Station station = new Station();
            station.setStationId(i);
            station.setPassengersOnStation(station.generatePassengers(station.getPassengerSum()));
            stations.add(i-1, station);

            System.out.println("Generated station #" + station.getStationId() + " with " + station.getPassengerSum() + "passengers.");
        }
        return stations;
    }


    /** public Integer drive() {
        int cash = 0;

        for (int i = 0; i < stations.size(); i++) {
            Station s = stations.get(i);
            List<Passenger> passengersToExit = askPassengersToExit(s);
            takeMoney(passengersToExit);
            askToExit(passengersToExit);
            if (!isLastStation(i)) {
                receivePassengers(s);
            }
            return cash;
        }
    }

    public Integer takeMoney(List<Passenger> passengersToExit) {

        int money = this.price * (passengersToExit.size() + 1);
        return money;
    }

    public List<Passenger> askPassengersToExit(Station s) {
       int stationId = s.getStationId();

    }**/

}
