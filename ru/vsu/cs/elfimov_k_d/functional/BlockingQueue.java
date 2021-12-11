package ru.vsu.cs.elfimov_k_d.functional;
import java.util.ArrayList;

public class BlockingQueue {
    private ArrayList<Runnable> tasks = new ArrayList<>();

    public synchronized Runnable get() {
        try {
            while (tasks.isEmpty()) {
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Runnable task = tasks.get(0);
        tasks.remove(task);
        return task;
    }
    public synchronized void put(Runnable task) {
        tasks.add(task);
        notify();
    }
}
