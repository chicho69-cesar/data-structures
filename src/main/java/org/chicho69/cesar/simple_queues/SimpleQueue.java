package org.chicho69.cesar.simple_queues;

public class SimpleQueue<T> {
    private final int maxSize;
    private int start;
    private int end;
    private final T[] elements;

    public SimpleQueue(int maxSize) {
        this.maxSize = maxSize;
        start = 0;
        end = -1;
        elements = (T[]) new Object[maxSize];
    }

    public void insert(T d) {
        if (!isFull()){
            elements[++end] = d;
        } else {
            if ((end - start + 1) == maxSize) {
                System.out.println("La Cola Esta Llena");
            } else {
                flat();
                elements[++end] = d;
            }
        }
    }

    public T delete() {
        if (!isEmpty()) {
            return elements[start++];
        } else {
            System.out.println("La Cola Esta Vacia");
            return null;
        }
    }

    public void printQueue() {
        if (!isEmpty()) {
            System.out.println("\nElementos");

            for (int i = start; i <= end; i++) {
                System.out.print(elements[i] + " -> ");
            }

            System.out.println();
        }
    }

    public boolean isEmpty() {
        return end < start;
    }

    public boolean isFull() {
        return end == maxSize - 1;
    }

    public void flat() {
        int size = (end - start + 1);
        T[] elements = (T[]) new Object[size];
        int front = start;
        int aux = 0;

        for (int i = front; i < maxSize; i++) {
            elements[aux] = this.elements[i];
            aux++;
        }

        start = 0;
        end = -1;

        for (T element : elements) {
            this.elements[++end] = element;
        }
    }
}
