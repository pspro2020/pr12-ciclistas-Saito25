package main;

import cyclist.Cyclist;
import cyclist.StageManager;

import java.util.concurrent.CyclicBarrier;

public class Main {

    public Main() {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10, new StageManager());

        for (int i = 0; i < 10; i++) {
            new Thread(new Cyclist("Friend #" + (i + 1), cyclicBarrier)).start();
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}
