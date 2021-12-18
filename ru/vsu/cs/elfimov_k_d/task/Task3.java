package ru.vsu.cs.elfimov_k_d.task;

import ru.vsu.cs.elfimov_k_d.collection.CloseLinkedList;

import java.util.Arrays;

public class Task3 {
    public Runnable test() {
        return new Runnable() {
            @Override
            public synchronized void run() {
                CloseLinkedList<Integer> list = CloseLinkedList.of(1, 3, 5, 6, 7, 8);
                System.out.println("Size: " + list.size() + "; values: " + list);
                for (int index = 0; index < 10; index++) {
                    list.addFirst(index + 1);
                    list.addLast(index * 2);
                    list.add(index / 2);
                }
                System.out.println("Size: " + list.size() + "; values: " + list);
                list.clear();
                System.out.println("Size: " + list.size() + "; values: " + list);

                list = CloseLinkedList.of(2, 3, 4, 5, 8, 3, null, 3, 4);

                System.out.println("Size: " + list.size() + "; values: " + list);
                System.out.println("Contains [3] : " + list.contains(3));
                System.out.println("Contains [10]: " + list.contains(10));

                System.out.println("IndexOf(2) : " + list.indexOf(2));
                System.out.println("IndexOf(8) : " + list.indexOf(8));
                System.out.println("IndexOf(10): " + list.indexOf(10));

                System.out.println("Get(5): " + list.get(5));
                System.out.println("Get(7): " + list.get(7));
                System.out.println("Get(6): " + list.get(6));

                System.out.println("Get(0): " + list.get(0));
                System.out.println("Get(2): " + list.get(2));
                System.out.println("Get(4): " + list.get(4));

                list.clear();

                list.add(1);
                System.out.println("Size: " + list.size() + "; values: " + list);
                System.out.println("getFirst: " + list.getFirst());
                System.out.println("getLast: " + list.getLast());

                list.addAll(Arrays.asList(2, 3));
                System.out.println("Size: " + list.size() + "; values: " + list);
                System.out.println("getFirst: " + list.getFirst());
                System.out.println("getLast: " + list.getLast());

                list.addAll(Arrays.asList(2, 3, 4));
                System.out.println("Size: " + list.size() + "; values: " + list);
                list.add(0, 9);
                list.add(list.size() - 1, 9);
                list.add(5, 9);
                System.out.println("Size: " + list.size() + "; values: " + list);

                list.set(0, 7);
                list.set(list.size() - 1, 7);
                list.set(3, 7);
                System.out.println("Size: " + list.size() + "; values: " + list);

                System.out.println("lastIndexOf(7): " + list.lastIndexOf(7));
                System.out.println("lastIndexOf(2): " + list.lastIndexOf(2));
                System.out.println("lastIndexOf(1): " + list.lastIndexOf(1));
                System.out.println("lastIndexOf(9): " + list.lastIndexOf(9));

                list.clear();
                list.add(0, 1);
                System.out.println("Size: " + list.size() + "; values: " + list);
                System.out.println("lastIndexOf(1): " + list.lastIndexOf(1));
                System.out.println("indexOf(1): " + list.indexOf(1));
                list.add(0, 2);
                System.out.println("Size: " + list.size() + "; values: " + list);
                System.out.println("lastIndexOf(1): " + list.lastIndexOf(1));
                System.out.println("indexOf(2): " + list.indexOf(2));

                list.addAll(Arrays.asList(1, 2, 3));
                System.out.println("Size: " + list.size() + "; values: " + list);
                System.out.println("removeLast() : " + list.removeLast() + "; list: " + list);
                System.out.println("removeLast() : " + list.removeLast() + "; list: " + list);
                System.out.println("removeFirst() : " + list.removeFirst() + "; list: " + list);
                System.out.println("removeFirst() : " + list.removeFirst() + "; list: " + list);
                System.out.println("removeFirst() : " + list.removeFirst() + "; list: " + list);

                list.add(0, 1);
                list.add(0, 2);
                list.add(0, 3);
                list.add(0, 4);
                list.add(0, 5);
                System.out.println("Size: " + list.size() + "; values: " + list);

                System.out.println("remove(0): " + list.remove(0) + "; list: " + list);
                System.out.println("remove(1): " + list.remove(1) + "; list: " + list);
                System.out.println("remove(2): " + list.remove(2) + "; list: " + list);
                System.out.println("remove(0): " + list.remove(0) + "; list: " + list);

                list.addAll(Arrays.asList(1, 2, 3, 4, 5));
                System.out.println("Size: " + list.size() + "; values: " + list);
                System.out.print("Foreach: ");
                for (int value : list) {
                    System.out.print(value + "  ");
                }
                System.out.println();
                list.removeLast();
                list.removeFirst();
                list.remove(0);
                list.remove(0);
                list.remove(0);

                System.out.println("Size: " + list.size() + "; values: " + list);
                System.out.print("Foreach: ");
                for (int value : list) {
                    System.out.print(value + "  ");
                }

                list.addAll(Arrays.asList(1, 2, 3, 4, 5, 6));
                System.out.println("Size: " + list.size() + "; values: " + list);
                Integer[] values = list.toArray(new Integer[0]);
                System.out.println("List to Integer[]: " + Arrays.toString(values));

                list.stream().forEach(System.out::println);
                int sum = list.stream().mapToInt(Integer::intValue).sum();
                System.out.println("Sum: " + sum);
            }
        };
    }
}
