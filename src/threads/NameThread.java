package threads;

import vehicles.Vehicle;
public class NameThread extends Thread {
    private final Vehicle vehicle;
    private final String threadName;

    public NameThread(Vehicle vehicle, String threadName) {
        super(threadName);
        this.vehicle = vehicle;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        System.out.println("\n[" + threadName + "] Запущен (приоритет: " + getPriority() + ")");

        String[] models = vehicle.getModelsName();

        for (int i = 0; i < models.length; i++) {
            System.out.printf("[%s] Название модели #%d: %s%n",
                    threadName, (i + 1), models[i]);
        }

        System.out.println("[" + threadName + "] Завершен");
    }
}