package org.chicho69.cesar.hash_tables;

import java.util.Arrays;

public class HashTable {
    public String[] array;
    public int size;

    public HashTable(int size) {
        this.size = size;
        array = new String[size];
        Arrays.fill(array, "-1");
    }

    public void hashFunction(String[] stringsArray, String[] array) {
        for (String element : stringsArray) {
            int key = Integer.parseInt(element) % 7;
            System.out.println("Indice: " + key + "\tElemento: " + element);

            while (!array[key].equals("-1")) {
                key++;
                System.out.println("Ocurrio una colicion en la clave: " + (key - 1) + " -> " + key);
                key %= size;
            }

            array[key] = element;
        }
    }

    public String searchKey(String element) {
        int key = Integer.parseInt(element) % 7;
        int counter = 0;

        while (!"-1".equals(array[key])) {
            if (array[key].equals(element)) {
                System.out.println("\nIndice: " + key + "\tElemento: " + element);
                return array[key];
            }

            key++;
            key %= size;
            counter++;

            if (counter > 7) {
                break;
            }
        }

        return null;
    }

    public void show() {
        System.out.println("\nTabla Hash\n");

        for (int i = 0; i < array.length; i++) {
            System.out.println(i + " --> " + array[i]);
        }
    }
}
