package models;

import java.util.ArrayList;
import java.util.List;

public class Bus {

    private int price = 5;
    private int capacity = 30;
    private List<Station> stations = new ArrayList<>();
    private List<Passenger> passengers = new ArrayList<>();
    private List<Passenger> passengersToExit;
    private int cash = 0;

    /**for (int i = 0; i < stations.size(); i++) {
        Station s = stations.get(i);
        List<Passenger> passengersToExit = askPassengersToExit(s);
        takeMoney(passengersToExit);
        askToExit(passengersToExit);
        if (!isLastStation(i)) {
            receivePassengers(s);
        }
        return cash;
    }**/


    public Integer drive() {
        int cash = 0;
        stations = generateStations();


        for (int i = 0; i < stations.size(); i++) {
            Station s = stations.get(i);
            int currentStationId = s.getStationId();
            getPassengers(s);
            List<Passenger> passengersToExit = askPassengersToExit(currentStationId);
            askToExit(passengersToExit);

            //if (!isLastStation(i)) {
            //    receivePassengers(s);
            //}
        }
        return cash;
    }
    public void askToExit(List<Passenger> passengersToExit) {

        for (int i = 0; i < passengers.size(); i++) {
            for (int j = 0; j < passengersToExit.size(); j++) {
                if (passengers.get(i) == passengersToExit.get(j)) {
                    passengers.remove(i);
                }
            }
        }
    }

    public List<Passenger> askPassengersToExit(int currentStationId) {
        List<Passenger> passengersToExit = new ArrayList<>();

        for (int i = 0; i < this.passengers.size(); i++) {
            Passenger passenger = passengers.get(i);
            if (passenger.getFinalDestination() == currentStationId) {
                passengersToExit.add(passenger);
            }
        }
        return passengersToExit;
    }

    public void getPassengers(Station station) {

        List<Passenger> enteringPassengers = station.getPassengersOnStation();

        if (passengers.size() <= capacity) {
            for (int i = 0; i < enteringPassengers.size(); i++) {
                this.passengers.add(enteringPassengers.get(i));
                this.cash += price;
            }
        } else {
            System.out.println("На станции " + station.getStationId() + "не смогли сесть все пассажиры");
        }
    }

    public List<Station> generateStations() {

        List<Station> stations = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            Station station = new Station();
            station.setStationId(i);
            station.setPassengersOnStation(Passenger.generatePassengers(station.getPassengerSum()));
            stations.add(i-1, station);

            System.out.println("Generated station #" + station.getStationId() + " with " + station.getPassengerSum() + "passengers.");
            System.out.println();
        }
        return stations;
    }



    public void setStations(List<Station> stations) {
        this.stations = stations;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }



}
