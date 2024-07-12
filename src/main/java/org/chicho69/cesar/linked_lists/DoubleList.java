package org.chicho69.cesar.linked_lists;

public class DoubleList<T> extends List<T> {
    public DoubleList() {}

    public void add(T info) {
        addLast(info);
    }

    @SafeVarargs
    public final void addSome(T... info) {
        for (T inf : info) {
            add(inf);
        }
    }

    public void addFirst(T info) {
        node = new Node<T>(info);

        if (isEmpty()) {
            end = node;
        } else {
            node.setNext(start);
            start.setPrevious(node);
        }

        start = node;
        size++;
    }

    public void addLast(T info) {
        node = new Node<T>(info);

        if (isEmpty()) {
            start = node;
        } else {
            end.setNext(node);
            node.setPrevious(end);
        }

        end = node;
        size++;
    }

    public void insert(int position, T info) throws ListException {
        node = new Node<T>(info);

        if ((position > size) || (position < 0)) {
            throw new ListException("Error. Posicion indefinida en la lista");
        }

        if (position == size && position != 0) {
            addLast(info);
        } else if(position == 0) {
            addFirst(info);
        } else {
            int pos = 0;
            Node<T> auxiliar = start, before = auxiliar, after = before.getNext();

            while (pos < position) {
                before = auxiliar;
                after = before.getNext();
                auxiliar = auxiliar.getNext();
                pos++;
            }

            before.setNext(node);
            node.setPrevious(before);
            node.setNext(after);
            after.setPrevious(node);

            size++;
        }
    }

    public T remove(int pos) throws ListException {
        T element;

        if ((isEmpty()) || (pos < 0 || pos >= size)) {
            throw new ListException("Error. Ocurrio un error al querer eliminar un elemento");
        }

        if (start == end && pos == 0) {
            element = (T) start.getInfo();
            start = null;
            end = null;
            node = null;
        } else if (pos == 0) {
            element = (T) start.getInfo();
            node = start;
            start = start.getNext();
            start.setPrevious(null);
            node.setNext(null);
            node = null;
        } else if (pos == size - 1) {
            element = (T) end.getInfo();
            node = start;

            while (node.getNext() != end) {
                node = node.getNext();
            }

            end.setPrevious(null);
            node.setNext(null);
            end = node;
        } else {
            Node<T> before = start;
            node = before.getNext();
            int position = 1;

            while (position < pos) {
                before = node;
                node = before.getNext();
                position++;
            }

            element = (T) node.getInfo();
            before.setNext(node.getNext());
            node.getNext().setPrevious(before);
            node.setNext(null);
            node.setPrevious(null);
            node = null;
        }

        System.gc();

        size--;
        return element;
    }

    public T removeFirst() throws ListException {
        return (T) remove(0);
    }

    public T removeLast() throws ListException {
        return (T) remove(size - 1);
    }

    public void delete(int pos) throws ListException {
        remove(pos);
    }

    public void deleteFirst() throws ListException {
        removeFirst();
    }

    public void deleteLast() throws ListException {
        removeLast();
    }
}
