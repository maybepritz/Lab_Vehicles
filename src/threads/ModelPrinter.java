package threads;

public class ModelPrinter implements Runnable {
    private VehicleSynchronizer synchronizer;

    public ModelPrinter(VehicleSynchronizer synchronizer) {
        this.synchronizer = synchronizer;
    }

    @Override
    public void run() {
        try {
            while (synchronizer.canPrintModel()) {
                synchronizer.printModel();
            }
        } catch (InterruptedException e) {
            System.out.println("ModelPrinter завершен");
        }
    }
}