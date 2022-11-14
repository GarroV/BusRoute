import models.Bus;

public class Main {
    public static void main(String[] args) {

        Bus bus = new Bus();

        for (int i = 0; i < 100; i++) {
            bus.drive();
        }
    }
}