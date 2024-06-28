package org.chicho69.cesar.dynamic_queues;

public class DynamicQueue<T> {
    private Node<T> node, front = null, rear = null;
    private static int size = 0;

    public DynamicQueue() {}

    public void insert(T info) {
        node = new Node<T>(info);

        if (isEmpty()) {
            front = node;
        } else {
            rear.setNext(node);
        }

        rear = node;
        size++;
    }

    public Node<T> remove() {
        Node<T> remove = null;

        if (!isEmpty()) {
            remove = front;

            if (front == rear) {
                node = null;
                front = null;
                rear = null;
            } else {
                node = front;
                front = front.getNext();
                node.setNext(null);
                node = null;
            }
        }

        size--;

        return remove;
    }

    public void clear() {
        node = null;
        front = null;
        rear = null;
        size = 0;
    }

    public String elements() {
        StringBuilder queue = new StringBuilder("Los elementos en la cola son: \n\n");

        if (!isEmpty()) {
            node = front;

            queue.append("frente");

            while (node != null) {
                queue.append(" -> ").append(node.getInfo());
                node = node.getNext();
            }

            queue.append(" <- final");
        }

        return queue.toString();
    }

    public Node<T> front() {
        return (isEmpty())? null : front;
    }

    public Node<T> rear() {
        return (isEmpty())? null : rear;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (front == null);
    }
}
