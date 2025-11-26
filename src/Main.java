import threads.NameThread;
import threads.PriceThread;
import vehicles.Automobile;
import vehicles.Vehicle;

public class Main {

    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════╗");
        System.out.println("║   ЛАБОРАТОРНАЯ РАБОТА №4: МНОГОПОТОЧНОСТЬ         ║");
        System.out.println("╚════════════════════════════════════════════════════╝\n");

        System.out.println("┌─────────────────────────────────────────────────────┐");
        System.out.println("│ ТЕСТ 1: Равные приоритеты (NORM_PRIORITY)          │");
        System.out.println("│ Транспорт: Automobile                               │");
        System.out.println("└─────────────────────────────────────────────────────┘");
        runTest(Thread.NORM_PRIORITY, Thread.NORM_PRIORITY);

        System.out.println("\n┌─────────────────────────────────────────────────────┐");
        System.out.println("│ ТЕСТ 2: Поток ЦЕН приоритетнее                      │");
        System.out.println("│ Цены: MAX_PRIORITY (10) | Имена: MIN_PRIORITY (1)   │");
        System.out.println("│ Транспорт: Automobile                               │");
        System.out.println("└─────────────────────────────────────────────────────┘");
        runTest(Thread.MAX_PRIORITY, Thread.MIN_PRIORITY);

        System.out.println("\n┌─────────────────────────────────────────────────────┐");
        System.out.println("│ ТЕСТ 3: Поток ИМЕН приоритетнее                     │");
        System.out.println("│ Цены: MIN_PRIORITY (1) | Имена: MAX_PRIORITY (10)   │");
        System.out.println("│ Транспорт: Automobile                               │");
        System.out.println("└─────────────────────────────────────────────────────┘");
        runTest(Thread.MIN_PRIORITY, Thread.MAX_PRIORITY);

    }

    private static void runTest(int pricePriority, int namePriority) {
        try {
            Vehicle vehicle = new Automobile("BMW", 100000);

            System.out.println("→ Марка: " + vehicle.getBrand());
            System.out.println("→ Количество моделей: " + vehicle.getSize() + "\n");

            PriceThread priceThread = new PriceThread(vehicle, "ПОТОК_ЦЕН");
            NameThread nameThread = new NameThread(vehicle, "ПОТОК_ИМЕН");

            priceThread.setPriority(pricePriority);
            nameThread.setPriority(namePriority);

            priceThread.start();
            nameThread.start();

            priceThread.join();
            nameThread.join();

        } catch (InterruptedException e) {
            System.err.println("Основной поток был прерван");
            Thread.currentThread().interrupt();
        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
            e.printStackTrace();
        }
    }
}