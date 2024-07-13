package org.chicho69.cesar.search_methods;

public class ArraySearches {
    /* MÉTODO PARA REALIZAR LA BÚSQUEDA SECUENCIAL*/
    public static int sequentialSearch(int[] array, int element) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                return i;
            }
        }

        return -1;
    }

    /* MÉTODO PARA REALIZAR LA BÚSQUEDA BINARIA*/
    public static int binarySearch(int[] array, int element) {
        int n = array.length;
        int pivot, lower = 0, upper = n - 1;

        while (lower <= upper) {
            pivot = (upper + lower) / 2;

            if (array[pivot] == element) {
                return pivot;
            } else {
                if (element < array[pivot]) {
                    upper = pivot - 1;
                } else {
                    lower = pivot + 1;
                }
            }
        }

        return -1;
    }
}
