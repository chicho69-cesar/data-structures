package org.chicho69.cesar.search_methods;

import java.util.Arrays;
import java.util.Random;

public class TestArraySearches {
    public static void run() {
        Random rnd = new Random();
        final int MAX1 = 50000;
        final int MAX2 = 100000;

        int[] array1 = new int[MAX1];
        int[] sequential = new int[MAX2];
        int[] binary = new int[MAX2];
        int[] binarySearch = new int[MAX2];

        for (int i = 0; i < MAX1; i++) {
            array1[i] = rnd.nextInt(100000);
        }

        for (int i = 0; i < MAX2; i++) {
            int numero = rnd.nextInt(100000);
            sequential[i] = numero;
            binary[i] = numero;
            binarySearch[i] = numero;
        }

        doSearch(array1, sequential, "Secuencial");
        doSearch(array1, binary, "Binaria");
        doSearch(array1, binarySearch, "BinarySearch");
    }

    public static void doSearch(int[] array1, int[] array2, String search) {
        long start, end;
        int found = 0;

        if (search.equals("BinarySearch") || search.equals("Binaria")) {
            Arrays.sort(array2);
        }

        start = System.currentTimeMillis();

        switch (search) {
            case "Secuencial" -> {
                for (int j : array1) {
                    if (ArraySearches.sequentialSearch(array2, j) != -1) {
                        found++;
                    }
                }
            }

            case "Binaria" -> {
                for (int j : array1) {
                    if (ArraySearches.binarySearch(array2, j) != -1) {
                        found++;
                    }
                }
            }

            case "BinarySearch" -> {
                for (int j : array1) {
                    if (Arrays.binarySearch(array2, j) > -1) {
                        found++;
                    }
                }
            }
        }

        end = System.currentTimeMillis();

        System.out.println("Tiempo " + search + ": " + (end - start) + " milisegundos");
        System.out.println("Cantidad de datos encontrados: " + found + "\n");
    }
}
