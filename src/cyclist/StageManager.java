package cyclist;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class StageManager implements Runnable {

    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    private int currentStage = 0;

    @Override
    public void run() {
        switch (currentStage) {
            case 0:
                System.out.printf("%s -> %s: Comienza la etapa\n",
                        LocalTime.now().format(dateTimeFormatter),
                        Thread.currentThread().getName());
                break;
            case 1:
                System.out.printf("%s -> %s: De vuelta a casa\n",
                        LocalTime.now().format(dateTimeFormatter),
                        Thread.currentThread().getName());
                break;
            case 2:
                System.out.printf("%s -> %s: Etapa finalizada\n",
                        LocalTime.now().format(dateTimeFormatter),
                        Thread.currentThread().getName());
                break;
        }
        currentStage++;
    }
}
