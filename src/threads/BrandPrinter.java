package threads;

import vehicles.Vehicle;

public class BrandPrinter implements Runnable {
    private Vehicle vehicle;

    public BrandPrinter(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println("[" + threadName + "] Марка: " + vehicle.getBrand());
    }
}