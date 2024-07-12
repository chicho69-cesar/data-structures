package org.chicho69.cesar.linked_lists;

public abstract class List<T> implements IBasicActions<T> {
    protected Node<T> node, start = null, end = null;
    protected int size = 0;

    @Override
    public final int size() {
        return this.size;
    }

    @Override
    public final boolean isEmpty() {
        return start == null;
    }

    @Override
    public final void clear() {
        node = null;
        start = null;
        end = null;

        System.gc();
    }

    @Override
    public final T get(int pos) throws ListException {
        T element;

        if ((isEmpty()) || (pos < 0 || pos >= size)) {
            throw new ListException("Error. Ocurrio un error al obtener el dato");
        }

        if (pos == 0) {
            element = (T) start.getInfo();
        } else if (pos == size - 1) {
            element = (T) end.getInfo();
        } else {
            node = start;
            int position = 0;

            while (position < pos) {
                node = node.getNext();
                position++;
            }

            element = (T) node.getInfo();
        }

        return element;
    }

    @Override
    public final T getFirst() throws ListException {
        return (T) get(0);
    }

    @Override
    public final T getLast() throws ListException {
        return (T) get(size - 1);
    }

    public final void set(int pos, T info) throws ListException {
        if ((isEmpty()) || (pos < 0 || pos >= size)) {
            throw new ListException("Error. Ocurrio un error al momento de cambiar un valor");
        }

        if (pos == 0) {
            start.setInfo(info);
        } else if(pos == size - 1) {
            end.setInfo(info);
        } else {
            node = start;
            int position = 0;

            while (position < pos) {
                node = node.getNext();
                position++;
            }

            node.setInfo(info);
        }
    }

    public final void setFirst(T info) throws ListException {
        set(0, info);
    }

    public final void setLast(T info) throws ListException {
        set((size - 1), info);
    }

    public final boolean contains(T info) {
        boolean flag = false;

        node = start;

        while (node != null) {
            if (node.getInfo() == info) {
                flag = true;
                break;
            } else {
                node = node.getNext();
            }
        }

        return flag;
    }

    public final int getIndex(T info) {
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
}
