package threads.ReentrantLock;

import vehicles.Vehicle;

import java.util.concurrent.locks.ReentrantLock;

public class AllPricesPrinter implements Runnable {
    private Vehicle vehicle;
    private ReentrantLock lock = new ReentrantLock();

    public AllPricesPrinter(Vehicle vehicle, ReentrantLock lock) {
        this.vehicle = vehicle;
        this.lock = lock;
    }

    @Override
    public void run() {
        lock.lock();
        try{
            double[] prices = vehicle.getModelsCost();
            for (double price : prices) {
                System.out.println("Цена: " + price);
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