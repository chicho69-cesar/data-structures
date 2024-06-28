package org.chicho69.cesar.dynamic_arrays;

public class DynamicArray<T> {
    private Node<T> node, start = null, end = null;
    private int size = 0;

    public DynamicArray() {}

    public void insert(T info) {
        node = new Node<T>(info);

        if (isEmpty()) {
            start = node;
        } else {
            end.setNext(node);
        }

        end = node;
        size++;
    }

    public void insert(int position, T info) throws ArrayPositionException {
        node = new Node<T>(info);

        if ((position > size) || (position < 0)) {
            throw new ArrayPositionException("The position is out of the limits of the array");
        }

        if (position == size && position != 0) {
            insert(info);
        } else if (position == 0) {
            if (isEmpty()) {
                start = node;
                end = node;
            } else {
                node.setNext(start);
                start = node;
            }

            size++;
        } else {
            int pos = 0;
            Node<T> aux = start, previous = aux, after = previous.getNext();

            while (pos < position) {
                previous = aux;
                after = previous.getNext();
                aux = aux.getNext();
                pos++;
            }

            previous.setNext(node);
            node.setNext(after);

            size++;
        }
    }

    public void insertFirst(T info) throws ArrayPositionException {
        insert(0, info);
    }

    public void insertLast(T info) throws ArrayPositionException {
        insert(info);
    }

    public T remove(int pos) throws ArrayPositionException {
        T data;

        if (isEmpty()) {
            throw new ArrayPositionException("The array is empty");
        }

        if (pos < 0 || pos >= size) {
            throw new ArrayPositionException("The position is out of the limits of the array");
        }

        if (start == end && pos == 0) {
            data = (T) start.getInfo();
            node = null;
            start = null;
            end = null;
        } else if (pos == 0) {
            data = (T) start.getInfo();
            node = start;
            start = start.getNext();
            node.setNext(null);
            node = null;
        } else if (pos == (size - 1)) {
            data = (T) end.getInfo();
            node = start;

            while (node.getNext() != end) {
                node = node.getNext();
            }

            node.setNext(null);
            end = node;
        } else {
            Node<T> previous = start;
            node = previous.getNext();
            int position = 1;

            while (position < pos) {
                previous = node;
                node = previous.getNext();
                position++;
            }

            data = (T) node.getInfo();
            previous.setNext(node.getNext());
            node.setNext(null);
            node = null;
        }

        size--;
        return data;
    }

    public T removeFirst() throws ArrayPositionException {
        return (T) remove(0);
    }

    public T removeLast() throws ArrayPositionException {
        return (T) remove(size() - 1); //removemos al final
    }

    public void delete(int pos) throws ArrayPositionException {
        if (isEmpty()) {
            throw new ArrayPositionException("The array is empty");
        }

        if (pos < 0 || pos >= size) {
            throw new ArrayPositionException("The position is out of the limits of the array");
        }

        if (start == end && pos == 0) {
            node = null;
            start = null;
            end = null;
        } else if (pos == 0) {
            node = start;
            start = start.getNext();
            node.setNext(null);
            node = null;
        } else if (pos == (size - 1)) {
            node = start;

            while (node.getNext() != end) {
                node = node.getNext();
            }

            node.setNext(null);
            end = node;
        } else {
            Node<T> previous = start;
            node = previous.getNext();
            int position = 1;

            while (position < pos) {
                previous = node;
                node = previous.getNext();
                position++;
            }

            previous.setNext(node.getNext());
            node.setNext(null);
            node = null;
        }

        size--;
    }

    public T get(int pos) throws ArrayPositionException {
        T data;

        if (isEmpty()) {
            throw new ArrayPositionException("The array is empty");
        }

        if (pos < 0 || pos >= size) {
            throw new ArrayPositionException("The position is out of the limits of the array");
        }

        if (pos == 0) {
            data = (T) start.getInfo();
        } else if (pos == (size - 1)) {
            data = (T) end.getInfo();
        } else {
            node = start;
            int position = 0;

            while (position != pos) {
                node = node.getNext();
                position++;
            }

            data = (T) node.getInfo();
        }

        return data;
    }

    public T getFirst() throws ArrayPositionException {
        return (T) get(0);
    }

    public T getLast() throws ArrayPositionException {
        return (T) get(size() - 1);
    }

    public void set(int pos, T info) throws ArrayPositionException {
        if (isEmpty()) {
            throw new ArrayPositionException("The array is empty");
        }

        if (pos < 0 || pos >= size) {
            throw new ArrayPositionException("The position is out of the limits of the array");
        }

        if (pos == 0) {
            start.setInfo(info);
        } else if (pos == (size - 1)) {
            end.setInfo(info);
        } else {
            node = start;
            int position = 0;

            while (position != pos) {
                node = node.getNext();
                position++;
            }

            node.setInfo(info);
        }
    }

    public boolean contains(T info) {
        boolean band = false;

        node = start;

        while (node != null) {
            if (node.getInfo() == info) {
                band = true;
                break;
            } else {
                node = node.getNext();
            }
        }

        return band;
    }

    public int getIndex(T info) {
        int index = 0;

        if (contains(info)) {
            node = start;

            while (node != null) {
                if (node.getInfo() == info) {
                    break;
                } else {
                    index++;
                    node = node.getNext();
                }
            }
        } else {
            index = -1;
        }

        return index;
    }

    public void clear() {
        node = null;
        start = null;
        end = null;

        System.gc();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (start == null);
    }

    private static class Node<P> {
        private P info;
        private Node<P> next;

        public Node(P info) {
            this.info = info;
            this.next = null;
        }

        public P getInfo() {
            return info;
        }

        public void setInfo(P info) {
            this.info = info;
        }

        public Node<P> getNext() {
            return next;
        }

        public void setNext(Node<P> next) {
            this.next = next;
        }
    }

    private static class ArrayPositionException extends RuntimeException {
        public ArrayPositionException(String e) {
            super(e);
        }
    }
}
