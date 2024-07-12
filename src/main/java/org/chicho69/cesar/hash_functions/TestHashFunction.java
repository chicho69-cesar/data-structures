package org.chicho69.cesar.hash_functions;

public class TestHashFunction {
    public void run() {
        final int MAX = 10;
        int size = (int) (MAX * 1.2);

        int[] array = {1020, 787, 415, 616, 24, 5, 10284, 37, 99, 121};

        int[] array1 = new int[MAX];
        int[] array2 = new int[size];

        for (int i = 0; i < MAX; i++) {
            array1[i] = (int) (10 + Math.random() * (90));
        }

        HashFunction.insertModule(array1, array2);
        HashFunction.doSearch(array, array2, "Funcion Modulo");
    }
}
