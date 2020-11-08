package cyclist;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Cyclist implements Runnable {

    private final String name;
    private final CyclicBarrier raceStageBarrier;
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    public Cyclist(String name, CyclicBarrier raceStageBarrier) {
        this.name = name;
        this.raceStageBarrier = raceStageBarrier;
    }


    @Override
    public void run() {
        try {
            goOutHome();
        } catch (InterruptedException e) {
            System.out.printf("%s -> %s: tuvo un accidente de camino a la gasolinera, y jamás volvió a saberse " +
                            "de él. Descanse en paz.\n",
                    LocalTime.now().format(dateTimeFormatter),
                    name);
            return;
        }
        try {
            raceStageBarrier.await();
        } catch (InterruptedException e) {
            System.out.printf("%s -> %s: fue calcinado esperando en la galoniera porque esta explotó.\n",
                    LocalTime.now().format(dateTimeFormatter),
                    name);
            return;
        } catch (BrokenBarrierException e) {
            System.out.printf("%s -> %s: pasa de seguir esperando y se va a la siguiente etapa.\n",
                    LocalTime.now().format(dateTimeFormatter),
                    name);
        }
        try {
            goToInn();
        } catch (InterruptedException e) {
            System.out.printf("%s -> %s: Recordó que tenía que entregar un trabajo importante mañana" +
                            "¡Y que no lo había ni empezado! Corrió como nunca hacia casa. Lo terminaron despidiendo.\n",
                    LocalTime.now().format(dateTimeFormatter),
                    name);
            return;
        }
        try {
            raceStageBarrier.await();
        } catch (InterruptedException e) {
            System.out.printf("%s -> %s: Comió algo en mal estado en la venta mientras esperaba... Atascó el baño " +
                            "de la venta.\n",
                    LocalTime.now().format(dateTimeFormatter),
                    name);
            return;
        } catch (BrokenBarrierException e) {
            System.out.printf("%s -> %s: pasa de seguir esperando y se va a la siguiente etapa.\n",
                    LocalTime.now().format(dateTimeFormatter),
                    name);
        }
        try {
            goToFuelStation();
        } catch (InterruptedException e) {
            System.out.printf("%s -> %s: Recordó que tenía que entregar un trabajo importante mañana" +
                            "¡Y que no lo había ni empezado! Corrió como nunca hacia casa. Lo terminaron despidiendo.\n",
                    LocalTime.now().format(dateTimeFormatter),
                    name);
            return;
        }
        try {
            raceStageBarrier.await();
        } catch (InterruptedException e) {
            System.out.printf("%s -> %s: fue calcinado esperando en la galoniera porque esta explotó.\n",
                    LocalTime.now().format(dateTimeFormatter),
                    name);
            return;
        } catch (BrokenBarrierException e) {
            System.out.printf("%s -> %s: pasa de seguir esperando y se va a la siguiente etapa.\n",
                    LocalTime.now().format(dateTimeFormatter),
                    name);
        }
        try {
            goToHome();
        } catch (InterruptedException e) {
            System.out.printf("%s -> %s: Recordó que tenía que ir a comprar antes de ir a casa.\n",
                    LocalTime.now().format(dateTimeFormatter),
                    name);
        }
    }

    private void goOutHome() throws InterruptedException {
        System.out.printf("%s -> %s: ha salido de casa dirección a la gasolinera\n",
                LocalTime.now().format(dateTimeFormatter),
                name);
        TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(1, 4));
        System.out.printf("%s -> %s: Ha llegado a la gasolinera\n",
                LocalTime.now().format(dateTimeFormatter),
                name);
    }

    private void goToInn() throws InterruptedException {
        System.out.printf("%s -> %s: ha salido de la gasolinera dirección a la venta\n",
                LocalTime.now().format(dateTimeFormatter),
                name);
        TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(5, 11));
        System.out.printf("%s -> %s: Ha llegado a la venta\n",
                LocalTime.now().format(dateTimeFormatter),
                name);
    }

    private void goToFuelStation() throws InterruptedException {
        System.out.printf("%s -> %s: ha salido de la venta dirección a la gasolinera\n",
                LocalTime.now().format(dateTimeFormatter),
                name);
        TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(5, 11));
        System.out.printf("%s -> %s: Ha llegado a la gasolinera\n",
                LocalTime.now().format(dateTimeFormatter),
                name);
    }

    private void goToHome() throws InterruptedException {
        System.out.printf("%s -> %s: ha salido de la gasolinera dirección a casa\n",
                LocalTime.now().format(dateTimeFormatter),
                name);
        TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(1, 4));
        System.out.printf("%s -> %s: Ya en casa\n",
                LocalTime.now().format(dateTimeFormatter),
                name);
    }
}
