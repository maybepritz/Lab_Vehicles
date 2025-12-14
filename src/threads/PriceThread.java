package threads;

import vehicles.Vehicle;

public class PriceThread extends Thread {
    private Vehicle vehicle;

    public PriceThread(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public void run() {
        double[] prices = vehicle.getModelsCost();
        for (double price : prices) {
            System.out.println("Цена: " + price);
        }
    }
}