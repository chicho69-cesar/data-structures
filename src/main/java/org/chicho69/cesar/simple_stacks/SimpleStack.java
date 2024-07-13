package org.chicho69.cesar.simple_stacks;

public class SimpleStack<T> {
    private final int maxSize;
    private int top;
    private final T[] elements;

    public SimpleStack(int maxSize) {
        this.maxSize = maxSize;
        top = -1;
        elements = (T[]) new Object[maxSize];
    }

    public void insert(T d) {
        if (!isFull()) {
            elements[++top] = d;
        }
    }

    public T delete() {
        if (!isEmpty()) {
            return elements[top--];
        } else {
            return null;
        }
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == (maxSize - 1);
    }

    public void printStack() {
        if (!isEmpty()) {
            System.out.println("\nElementos");

            for (int i = 0; i <= top; i++) {
                System.out.print(elements[i] + " -> ");
            }

            System.out.println();
        }
    }

    public void clean() {
        for (int i = 0; i < maxSize; i++) {
            elements[i] = null;
        }

        top = -1;
    }

    public int top() {
        return top;
    }

    public T topElement() {
        if (!isEmpty()) {
            return elements[top];
        } else {
            return null;
        }
    }
}
