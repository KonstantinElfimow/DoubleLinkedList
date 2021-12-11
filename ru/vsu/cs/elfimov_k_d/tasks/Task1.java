package ru.vsu.cs.elfimov_k_d.tasks;

import ru.vsu.cs.elfimov_k_d.model.Workers;
import ru.vsu.cs.elfimov_k_d.utils.DoubleLinkedList;

import java.util.HashSet;

public class Task1 {
    public Runnable test() {
        return new Runnable() {
            @Override
            public synchronized void run() {
                DoubleLinkedList<Workers> workers = new DoubleLinkedList<>();

                HashSet<Workers> workersSet = new HashSet<>();
                workersSet.add(new Workers(1, "Иван", "Алексеев", 2));
                workersSet.add(new Workers(2, "Дмитрий", "Мочалов", 4));
                workersSet.add(new Workers(3, "Семён", "Сидоров", 1));
                workersSet.add(new Workers(4, "Олег", "Бережной", 5));
                workersSet.add(new Workers(5, "Пётр", "Мычалов", 3));
                workersSet.add(new Workers(6, "Геннадий", "Мычалов", 3));
                workersSet.add(new Workers(7, "Дмитрий", "Мычалов", 3));
                workersSet.add(new Workers(7, "Дмитрий", "Мычалов", 3));
                workersSet.add(new Workers(7, "Дмитрий", "Мычалов", 3));
                workersSet.add(new Workers(7, "Дмитрий", "Мычалов", 3));
                workersSet.add(new Workers(7, "Дмитрий", "Мычалов", 3));

                System.out.println("WorkersSet [size = " + workersSet.size() + "]");


                fillInDoubleLinkedList(workersSet, workers);
                System.out.println("\nСортируем по возрастанию квалификации:");
                Workers[] out = countingSortByOrderOfQualification(workers.toArray());
                workers = new DoubleLinkedList<>(out);
                System.out.println(workers);
            }
        };
    }

    private static Workers[] countingSortByOrderOfQualification(Object[] workers) {

        final int MAX_VALUE = 10;

        int[] count = new int[MAX_VALUE];

        for (Object worker : workers) {
            int qualification = ((Workers) worker).getQualification();
            count[qualification] = count[qualification] + 1;
        }

        Workers[] out = new Workers[workers.length];

        for (int i = 1; i < count.length; i++) {
            count[i] = count[i] + count[i - 1];
        }

        for (int i = workers.length - 1; i >= 0; i--) {
            Workers worker = (Workers) workers[i];
            out[count[worker.getQualification()] - 1] = worker;
            count[worker.getQualification()]--;
        }
        return out;
    }

    private static <T> void fillInDoubleLinkedList(HashSet<T> workersSet, DoubleLinkedList<T> workers) {
        for (T objectValue : workersSet) {
            workers.addLast(objectValue);
        }
    }
}
