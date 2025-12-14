package threads;

import vehicles.Vehicle;
public class NameThread extends Thread {
    private Vehicle vehicle;

    public NameThread(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public void run() {
        String[] models = vehicle.getModelsName();
        for (String model : models) {
            System.out.println("Модель: " + model);
        }
    }
}