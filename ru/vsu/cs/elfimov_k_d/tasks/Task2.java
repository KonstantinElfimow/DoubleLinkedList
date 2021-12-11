package ru.vsu.cs.elfimov_k_d.tasks;

import org.w3c.dom.ls.LSOutput;
import ru.vsu.cs.elfimov_k_d.utils.DoubleLinkedList;

public class Task2 {
    public Runnable test() {
        return new Runnable() {
            @Override
            public synchronized void run() {
                DoubleLinkedList<Integer> workers = new DoubleLinkedList<>();
                for (int i = 0; i < 10; i++) {
                    workers.addLast(i);
                }
                System.out.println(workers);

                System.out.println("Добавляем на 8 индекс число 100. Теперь 100 находится между 8 и 9. Посмотрим, удалится ли 9, не повредив ссылок:");
                workers.insert(9, 100);
                workers.remove(10);
                System.out.println(workers);
                System.out.println("Всё работает!\n");

                System.out.println("Очистим список. Проверим работу.");
                workers.clear();
                System.out.println(workers.isEmpty());
                System.out.println("Всё работает!\n");
            }
        };
    }
}
