import threads.*;
import vehicles.Automobile;
import vehicles.Motorcycle;
import vehicles.Scooter;
import vehicles.Vehicle;
import vehicles.Atv;

import threads.ReentrantLock.AllPricesPrinter;
import threads.ReentrantLock.AllModelsPrinter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;


public class Main {

    public static void main(String[] args) {
        try {
            Vehicle vehicle = new Automobile("BMW", 4);

//             1
//                PriceThread priceThread = new PriceThread(vehicle);
//                NameThread nameThread = new NameThread(vehicle);
//
//                priceThread.setPriority(Thread.MAX_PRIORITY);
//                nameThread.setPriority(Thread.MIN_PRIORITY);
//
//                priceThread.start();
//                nameThread.start();
//
//             1

            // 2
//                VehicleSynchronizer sync = new VehicleSynchronizer(vehicle);
//
//                Thread modelThread = new Thread(new ModelPrinter(sync));
//                Thread priceThread = new Thread(new PricePrinter(sync));
//
//                modelThread.start();
//                priceThread.start();

            // 2

            // 3
//            ReentrantLock lock = new ReentrantLock();
//
//            Thread priceThread = new Thread(new AllPricesPrinter(vehicle, lock));
//            Thread modelThread = new Thread(new AllModelsPrinter(vehicle, lock));
//
//            priceThread.start();
//            modelThread.start();

            // 3

            // 4
//            Vehicle vehicle1 = new Automobile("1", 2);
//            Vehicle vehicle2 = new Motorcycle("2", 2);
//            Vehicle vehicle3 = new Scooter("3", 2);
//            Vehicle vehicle4 = new Atv("4", 2);
//
//            ExecutorService executor = Executors.newFixedThreadPool(2);
//
//            executor.execute(new BrandPrinter(vehicle1));
//            executor.execute(new BrandPrinter(vehicle2));
//            executor.execute(new BrandPrinter(vehicle3));
//            executor.execute(new BrandPrinter(vehicle4));
//
//            executor.shutdown();
            // 4

            //5
            String[] filenames = {
                    "data/task5/brand1.txt", "data/task5/brand2.txt", "data/task5/brand3.txt",
                    "data/task5/brand4.txt", "data/task5/brand5.txt"
            };

            int capacity = 3;
            BlockingQueue<Vehicle> queue = new ArrayBlockingQueue<>(capacity);


            for (String filename : filenames) {
                Thread thread = new Thread(new VehicleFileReader(filename, queue));
                thread.start();
            }

            for (int i = 0; i < filenames.length; i++) {
                Vehicle vehicle5 = queue.take();
                System.out.println("Получено из очереди: " + vehicle5.getBrand());
            }
            //5

        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
            e.printStackTrace();
        }



    }
}