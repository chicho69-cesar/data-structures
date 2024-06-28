package org.chicho69.cesar.circular_queues;

public class CircularQueue<T> {
    private final int maxSize;
    private int front;
    private int rear;
    private final T[] queueArray;

    public CircularQueue(int maxSize) {
        front = 0;
        rear = maxSize - 1;
        this.maxSize = maxSize;
        queueArray = (T[]) new Object[maxSize];
    }

    public void insert(T d) {
        if (!isFull()) {
            rear = next(rear);
            queueArray[rear] = d;
        } else {
            System.out.println("La Cola Esta Llena");
        }
    }

    public T delete() {
        T d;

        if (!isEmpty()) {
            d = queueArray[front];
            front = next(front);
            return d;
        } else {
            System.out.println("La Cola Esta Vacia");
            return null;
        }
    }

    public void printQueue() {
        if (!isEmpty()) {
            System.out.println("\nElementos");

            for (int i = front; i <= rear; i++) {
                System.out.print(queueArray[i] + " -> ");
            }

            System.out.println();
        }
    }

    public boolean isEmpty() {
        return  (front == next(rear));
    }

    public boolean isFull() {
        return (front == next(next(rear)));
    }

    public int next(int n) {
        return ((n + 1) % maxSize);
    }
}
