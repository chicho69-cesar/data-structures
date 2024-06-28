package org.chicho69.cesar.dynamic_stacks;

public class DynamicStack<T> {
    private Node<T> node, end = null, start = null;
    private static int size = 0;

    public DynamicStack() {}

    public void insert(T info) {
        node = new Node<T>(info);

        if (isEmpty()) {
            end = node;
        } else {
            start.setNext(node);
            node.setPrevious(start);
        }

        start = node;
        size++;
    }

    public Node<T> remove() {
        Node<T> remove = null;

        if (!isEmpty()) {
            remove = start;

            if (start == end) {
                node = null;
                start = null;
                end = null;
            } else {
                node = start;
                start = start.getPrevious();
                start.setNext(null);
                node.setPrevious(null);
                node = null;
            }
        }

        size--;

        return remove;
    }

    public void clear() {
        node = null;
        start = null;
        end = null;
        size = 0;
    }

    public String elements() {
        StringBuilder stack = new StringBuilder("Los elementos en la pila son: \n\n");

        if (!isEmpty()) {
            node = start;

            stack.append("cima -> ").append(String.valueOf(node.getInfo())).append("\n");
            node = node.getPrevious();

            while (node != null) {
                stack.append("               ").append(String.valueOf(node.getInfo())).append("\n");
                node = node.getPrevious();
            }
        }

        return stack.toString();
    }

    public Node<T> element() {
        return (isEmpty())? null : start;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (start == null);
    }
}
