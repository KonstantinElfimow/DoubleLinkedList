package ru.vsu.cs.elfimov_k_d;

import ru.vsu.cs.elfimov_k_d.functional.BlockingQueue;
import ru.vsu.cs.elfimov_k_d.task.Task1;
import ru.vsu.cs.elfimov_k_d.task.Task2;
import ru.vsu.cs.elfimov_k_d.task.Task3;

public class Main {

    public static void main(String[] args) {
        BlockingQueue queue = new BlockingQueue();

        Thread worker = new Thread(() -> {
            while (true) {
                Runnable task = queue.get();
                System.out.println("Task started: " + task);
                measureTime(task);
                System.out.println("Task finished: " + task + '\n');
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        worker.start();

        queue.put(new Task1().test());
        queue.put(new Task2().test());
        queue.put(new Task3().test());
    }
    private static void measureTime(Runnable task) {
        long startTime = System.currentTimeMillis();
        task.run();
        long elapsed = System.currentTimeMillis() - startTime;
        System.out.println("Затраченное время: " + elapsed + " ms");
    }
}
