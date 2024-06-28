package org.chicho69.cesar.bi_queues;

public class BIQueue<T> {
    private final int maxSize;
    private int front;
    private int rear;
    private final T[] queueArray;

    public BIQueue(int maxSize) {
        this.maxSize = maxSize;
        this.front = 0;
        this.rear = -1;
        this.queueArray = (T[]) new Object[maxSize];
    }

    public void insertInRight(T d) {
        if (!isFull()) {
            if (rear == (maxSize - 1)) {
                System.err.println("\nNo es posible insertar en la derecha, prueba a la izquierda");
            } else {
                queueArray[++rear] = d;
            }
        } else {
            System.err.println("\nLa Bicola Esta Llena");
        }
    }

    public void insertInLeft(T d) {
        if (!isFull()) {
            if (front == 0) {
                System.err.println("\nNo es posible insertar en la izquierda, prueba a la derecha");
            } else {
                queueArray[--front] = d;
            }
        } else {
            System.err.println("\nLa Bicola Esta Llena");
        }
    }

    public T deleteRight() {
        if (!isEmpty()) {
            return queueArray[rear--];
        } else {
            System.err.println("\nLa Bicola Esta Vacia");
            return null;
        }
    }

    public T deleteLeft() {
        if (!isEmpty()) {
            return queueArray[front++];
        } else {
            System.err.println("\nLa Bicola Esta Vacia");
            return null;
        }
    }

    public void printQueue() {
        if (!isEmpty()) {
            System.out.println("\nElementos");

            for(int i = front; i <= rear; i++){
                System.out.print(queueArray[i] + " -> ");
            }

            System.out.println();
        }
    }

    public boolean isEmpty() {
        return rear < front;
    }

    public boolean isFull() {
        return (rear - front + 1) == maxSize;
    }
}
