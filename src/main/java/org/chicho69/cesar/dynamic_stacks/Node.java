package org.chicho69.cesar.dynamic_stacks;

public class Node<T> {
    private T info;
    private Node<T> previous;
    private Node<T> next;

    public Node(T info) {
        this.info = info;
        this.previous = null;
        this.next = null;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}
