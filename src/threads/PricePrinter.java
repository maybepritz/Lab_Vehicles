package threads;

public class PricePrinter implements Runnable {
    private VehicleSynchronizer synchronizer;

    public PricePrinter(VehicleSynchronizer synchronizer) {
        this.synchronizer = synchronizer;
    }

    @Override
    public void run() {
        try {
            while (synchronizer.canPrintPrice()) {
                synchronizer.printPrice();
            }
        } catch (InterruptedException e) {
            System.out.println("PricePrinter завершен");
        }
    }
}
