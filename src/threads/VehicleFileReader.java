package threads;

import vehicles.Automobile;
import vehicles.Vehicle;

import java.io.*;
import java.util.concurrent.BlockingQueue;

public class VehicleFileReader implements Runnable {
    private String file;
    private BlockingQueue<Vehicle> queue;

    public VehicleFileReader(String file, BlockingQueue<Vehicle> queue) {
        this.file = file;
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String brand = reader.readLine();

            if (brand != null && !brand.trim().isEmpty()) {
                Vehicle vehicle = new Automobile(brand.trim(), 0);

                queue.add(vehicle);

                System.out.println("Добавлено в очередь: " + brand);
            }

            reader.close();
        } catch (Exception e) {
            System.err.println("Ошибка" + e.getMessage());
        }
    }
}