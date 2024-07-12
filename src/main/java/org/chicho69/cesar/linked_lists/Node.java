package org.chicho69.cesar.linked_lists;

public class Node<T> {
    private T info;
    private Node<T> next;
    private Node<T> previous;

    public Node(T info) {
        this.info = info;
        this.next = null;
        this.previous = null;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }
}
