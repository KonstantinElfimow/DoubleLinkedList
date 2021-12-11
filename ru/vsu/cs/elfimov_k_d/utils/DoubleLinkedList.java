package ru.vsu.cs.elfimov_k_d.utils;

import java.util.Iterator;

public class DoubleLinkedList<T> implements Iterable<T> {
    private ListNode<T> head = null;
    private ListNode<T> tail = null;
    private int count = 0;

    public DoubleLinkedList(T[] array) {
        for (T t : array) {
            this.addLast(t);
        }
        count = array.length;
    }

    public DoubleLinkedList() {

    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    private static class ListNode<T> {
        T value;
        ListNode<T> previous;
        ListNode<T> next;

        ListNode(T value, ListNode<T> previous, ListNode<T> next) {
            this.value = value;
            this.previous = previous;
            this.next = next;
        }
    }

    public void add(T value) {
        addFirst(value);
    }

    public void addFirst(T value) {
        head = new ListNode<>(value, null, head);
        if (count == 0) {
            tail = head;
        }
        count++;
    }

    public void addLast(T value) {
        ListNode<T> newNode = new ListNode<>(value, tail,null);
        if (count > 0) {
            tail.next = newNode;
        } else {
            head = newNode;
        }
        tail = newNode;
        count++;
    }

    private void emptyError() throws NullPointerException {
        if (count == 0) {
            throw new NullPointerException();
        }
    }

    public T getFirst() throws NullPointerException {
        emptyError();
        return head.value;
    }

    public T getLast() throws NullPointerException {
        emptyError();
        return tail.value;
    }

    private ListNode<T> getNode(int index) throws NullPointerException {
        if (index < 0 || index >= count) {
            throw new NullPointerException();
        }
        ListNode<T> curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr;
    }

    public T get(int index) throws NullPointerException {
        return getNode(index).value;
    }

    public T removeFirst() throws NullPointerException {
        T value = getFirst();
        head = head.next;
        head.previous = null;
        count--;
        if (count == 0) {
            tail = null;
        }
        return value;
    }

    public T removeLast() throws NullPointerException {
        T value = getLast();
        count--;
        if (count == 0) {
            head = tail = null;
        } else {
            tail = tail.previous;
            tail.next = null;
        }
        return value;
    }

    public T remove(int index) throws NullPointerException {
        if (index < 0 || index >= count) {
            throw new NullPointerException();
        }

        T value;
        if (index == 0) {
            value = head.value;
            head = head.next;
            head.previous = null;
            count--;
            if (count == 0) {
                head = tail = null;
            }
        } else {
            ListNode<T> removing = getNode(index);
            value = removing.value;
            removing.previous.next = removing.next;
            if (tail != removing) {
                removing.next.previous = removing.previous;
            } else {
                tail = removing.previous;
            }
            count--;
        }
        return value;
    }

    public void insert(int index, T value) throws NullPointerException {
        if (index < 0 || index > count) {
            throw new NullPointerException();
        }
        if (index == 0) {
            addFirst(value);
        } else {
            ListNode<T> node = getNode(index - 1);
            node.next = new ListNode<>(value, node, node.next);
            node.next.next.previous = node.next;
            count++;
        }
    }

    public void clear() {
        head = tail = null;
        count = 0;
    }

    @Override
    public Iterator<T> iterator() {
        class LinkedListIterator implements Iterator<T> {
            private ListNode<T> curr;

            private LinkedListIterator(ListNode<T> head) {
                curr = head;
            }

            @Override
            public boolean hasNext() {
                return curr != null;
            }

            @Override
            public T next() {
                T result = curr.value;
                curr = curr.next;
                return result;
            }
        }
        return new LinkedListIterator(head);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (ListNode<T> node = head; node != null; node = node.next) {
            sb.append(node.value).append("\n");
        }
        return sb.toString();
    }

    public Object[] toArray() {
        Object[] values = new Object[count];
        int index = 0;
        for (ListNode node = head; node != null; node = node.next) {
            values[index++] = node.value;
        }
        return values;
    }
}