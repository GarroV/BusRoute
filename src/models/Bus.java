package models;

import java.util.ArrayList;
import java.util.List;

public class Bus {

    private int price = 50;
    private int capacity = 30;
    private List<Station> stations = new ArrayList<>();
    private List<Passenger> passengers = new ArrayList<>();
    private int cash = 0;
    private int lateForWork = 0;

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


    public void drive() {
        stations = generateStations();


        for (int i = 0; i < stations.size(); i++) {
            Station s = stations.get(i);
            int currentStationId = s.getStationId();
            if (isLastStation(s)) {
                receivePassengers(this.passengers);
            } else {
                getPassengers(s);
                List<Passenger> passengersToExit = askPassengersToExit(currentStationId);
                askToExit(passengersToExit);
            }

        }
        //System.out.println();
        //System.out.println("Людей опоздало на работу: " + lateForWork);
        //System.out.println();
        //System.out.println("* * * * * * * * * * * * * * * * * * * *");
        System.out.println("Автобус заработал за рейс: " + cash);
        this.cash = 0;
    }

    public void receivePassengers(List<Passenger> passengers) {
        this.passengers.removeAll(passengers);
    }

    public boolean isLastStation(Station station) {
        //System.out.println("Последняя станция " + station.getStationId());
        return station.getStationId() == this.stations.size();
    }

    /** удаляем из списка пассажиров тех, кто выходит.
     * Через "==", а не "equals"  потому что это должны быть именно эти люди (???).
     */
    public void askToExit(List<Passenger> passengersToExit) {

        for (int i = 0; i < passengers.size(); i++) {
            for (int j = 0; j < passengersToExit.size(); j++) {
                if (passengers.get(i) == passengersToExit.get(j)) {
                    passengers.remove(i);
                }
            }
        }
    }

    // формируем список пассажиров на выход через сравнение точки назначения и текущей станции
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

        for (int i = 0; i < enteringPassengers.size(); i++) {
            if (enteringPassengers.get(i).getFinalDestination() > station.getStationId()) {
                if (this.passengers.size() <= capacity) {
                    this.passengers.add(enteringPassengers.get(i));
                    this.cash += price;
                } else {
                    this.lateForWork++;
                    //System.out.println("На станции " + station.getStationId() + " не смогли сесть все пассажиры");
                }
            } //else System.out.println("На станции " + station.getStationId() + " пассажиру нужен другой автобус -_- ");
        }
    }

    public List<Station> generateStations() {

        List<Station> stations = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            Station station = new Station();
            station.setStationId(i);
            //System.out.println("Generated station #" + station.getStationId());
            station.setPassengersOnStation(Passenger.generatePassengers(station.getPassengerSum()));
            stations.add(i-1, station);

            //System.out.println("#" + station.getPassengerSum() + " passengers.");
            //System.out.println();
        }
        return stations;
    }



}
