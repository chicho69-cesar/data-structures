package org.chicho69.cesar.linked_lists;

public class TestLinkedList {
    public void run() {
        SimpleList<Integer> listaSimple = new SimpleList<>();
        DoubleList<Integer> listaDoble = new DoubleList<>();

        for (int i = 1; i <= 5; i++) {
            listaSimple.add(i);
            listaDoble.add(i);
        }

        System.out.println("Lista simple");
        for (int i = 0; i < listaSimple.size(); i++) {
            System.out.print(listaSimple.get(i) + " -> ");
        }
        System.out.println("\n");

        System.out.println("Lista doble");
        for (int i = 0; i < listaDoble.size(); i++) {
            System.out.print(listaDoble.get(i) + " <-> ");
        }
        System.out.println("\n");
    }
}
