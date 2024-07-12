package org.chicho69.cesar.hash_functions;

public class HashFunction {
    /* MÉTODO PARA INSERTAR VALORES CON ESTRUCTURA HASH */
    public static void insertModule(int[] array1, int[] array2) {
        int module = module(array2.length);

        for (int element : array1) {
            int position = hashFunctionModule(element, module);

            if (array2[position] != 0) {
                position = linearTest(position, element, array2);

                if (position != -1) {
                    array2[position] = element;
                }

            } else {
                array2[position] = element;
            }
        }
    }

    /* ----- FUNCIONES HASH ----- */
    /* FUNCIÓN HASH DE MODULO */
    public static int hashFunctionModule(int number, int module) {
        return number % module;
    }

    public static int module(int size) {
        int module = size;

        while (!(isPrime(module))) {
            module--;
        }

        return module;
    }

    public static boolean isPrime(int number) {
        int counter = 0;

        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                counter++;
            }
        }

        return !(counter > 2);
    }

    /* ----- SOLUCIÓN DE COALICIONES ----- */
    /* SOLUCIÓN REASIGNACIÓN - PRUEBA LINEAL */
    public static int linearTest(int position, int value, int[] array) {
        int index = position, counter = 0;
        boolean flag = false;

        while (!flag && counter <= array.length) {
            if (array[index] != 0 && array[index] != value) {
                index++;
                counter++;
            } else if (array[index] != 0 && array[index] == value) {
                index = -1;
                flag = true;
            } else {
                flag = true;
            }

            if (index == array.length && !flag) {
                index = 0;
            }
        }

        index = (flag)? index : -1;

        return index;
    }

    /* ----- MÉTODOS DE BÚSQUEDA FUNCIONES HASH ----- */
    /* MÉTODO PARA REALIZAR LAS BÚSQUEDAS */
    public static void doSearch(int[] array1, int[] array2, String search) {
        long start = 0, end = 0;
        int found = 0;

        if (search.equals("Funcion Modulo")) {
            int module = module(array2.length);

            start = System.currentTimeMillis();

            for (int j : array1) {
                if (searchFunctionModule(array2, j, module) != -1) {
                    found++;
                }
            }

            end = System.currentTimeMillis();
        }

        System.out.println("Tiempo " + search + ": " + (end - start) + " milisegundos");
        System.out.println("Cantidad de datos encontrados: " + found + "\n");
    }

    /* BÚSQUEDA FUNCIÓN MODULO */
    public static int searchFunctionModule(int[] array, int element, int module) {
        int key = hashFunctionModule(element, module);
        int counter = 0;

        while (array[key] != 0) {
            if (array[key] == element) {
                return array[key];
            }

            key++;
            counter++;
            key %= array.length;

            if (counter > array.length) {
                break;
            }
        }

        return -1;
    }
}
