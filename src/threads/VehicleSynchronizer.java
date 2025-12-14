package threads;

import vehicles.Vehicle;

public class VehicleSynchronizer {
    private Vehicle vehicle;
    private volatile int current = 0;
    private Object lock = new Object();
    private boolean set = false;

    public VehicleSynchronizer(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void printPrice() throws InterruptedException {
        double val;
        synchronized(lock) {
            double[] p = vehicle.getModelsCost();
            if (!canPrintPrice()) throw new InterruptedException();
            while (!set)
                lock.wait();
            val = p[current++];
            System.out.println("Цена: " + val);
            set = false;
            lock.notifyAll();
        }
    }

    public void printModel() throws InterruptedException {
        synchronized(lock) {
            String[] s = vehicle.getModelsName();
            if (!canPrintModel()) throw new InterruptedException();
            while (set)
                lock.wait();
            System.out.println("Модель: " + s[current]);
            set = true;
            lock.notifyAll();
        }
    }

    public boolean canPrintPrice() {
        return current < vehicle.getSize();
    }

    public boolean canPrintModel() {
        return (!set && current < vehicle.getSize()) || (set && current < vehicle.getSize() - 1);
    }
}