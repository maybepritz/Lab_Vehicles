package threads;

import vehicles.Vehicle;

public class PriceThread extends Thread {
    private final Vehicle vehicle;
    private final String threadName;

    public PriceThread(Vehicle vehicle, String threadName) {
        super(threadName);
        this.vehicle = vehicle;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        System.out.println("\n[" + threadName + "] Запущен (приоритет: " + getPriority() + ")");

        String[] models = vehicle.getModelsName();
        double[] prices = vehicle.getModelsCost();

        for (int i = 0; i < models.length; i++) {
            System.out.printf("[%s] Цена модели %s: %.2f руб.%n",
                    threadName, models[i], prices[i]);
        }

        System.out.println("[" + threadName + "] Завершен");
    }
}