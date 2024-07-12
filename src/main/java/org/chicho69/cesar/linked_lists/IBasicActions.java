package org.chicho69.cesar.linked_lists;

public interface IBasicActions<T> {
    public int size();
    public boolean isEmpty();
    public void clear();
    public T get(int pos);
    public T getFirst();
    public T getLast();
}
