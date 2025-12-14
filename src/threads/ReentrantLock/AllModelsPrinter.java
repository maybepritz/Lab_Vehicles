package threads.ReentrantLock;

import vehicles.Vehicle;

import java.util.concurrent.locks.ReentrantLock;

public class AllModelsPrinter implements Runnable {
    private Vehicle vehicle;
    private ReentrantLock lock = new ReentrantLock();

    public AllModelsPrinter(Vehicle vehicle, ReentrantLock lock) {
        this.vehicle = vehicle;
        this.lock = lock;
    }

    @Override
    public void run() {
        lock.lock();
        try {
            String[] models = vehicle.getModelsName();
            for (String model : models) {
                System.out.println("Модель: " + model);
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            lock.unlock();
        }
    }
}