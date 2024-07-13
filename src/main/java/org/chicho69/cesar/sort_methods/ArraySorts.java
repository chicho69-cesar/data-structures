package org.chicho69.cesar.sort_methods;

import java.util.LinkedList;

public class ArraySorts {
    public static int n;

    /* MÉTODO DE ORDENAMIENTO BURBUJA */
    public static void bubbleSort(int[] array) {
        int movements, i, aux;

        do {
            movements = 0;

            for (i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    aux = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = aux;
                    movements++;
                }
            }
        } while (movements != 0);
    }

    /* MÉTODO DE ORDENAMIENTO BURBUJA MEJORADO */
    public static void improvedBubbleSort(int[] array) {
        int movements, i, aux, turns = 0;

        do {
            movements = 0;
            turns++;

            for (i = 0; i < array.length - turns; i++) {
                if (array[i] > array[i + 1]) {
                    aux = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = aux;
                    movements++;
                }
            }
        } while (movements != 0);
    }

    /* MÉTODO DE ORDENAMIENTO BURBUJA BIDIRECCIONAL */
    public static void bidirectionalBubbleSort(int[] array) {
        int left = 0, right = array.length - 1, aux, last = array.length - 1;

        do {
            for (int i = left; i < right; i++) {
                if (array[i] > array[i + 1]) {
                    aux = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = aux;
                    last = i;
                }
            }

            right = last;

            for (int i = right; i > left; i--) {
                if (array[i - 1] > array[i]) {
                    aux = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = aux;
                    last = i;
                }
            }

            left = last;
        } while (left < right);
    }

    /* MÉTODO DE ORDENAMIENTO SELECCIÓN */
    public static void selectionSort(int[] array) {
        int aux;

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[i]) {
                    aux = array[j];
                    array[j] = array[i];
                    array[i] = aux;
                }
            }
        }
    }

    /* MÉTODO DE ORDENAMIENTO SELECCIÓN MEJORADO */
    public static void improvedSelectionSort(int[] array) {
        int aux, min;

        for (int i = 0; i < array.length - 1; i++) {
            min = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }

            if (min != i) {
                aux = array[min];
                array[min] = array[i];
                array[i] = aux;
            }
        }
    }

    /* MÉTODO DE ORDENAMIENTO POR INSERCIÓN */
    public static void insertionSort(int[] array) {
        int i, j, current;

        for (i = 1; i < array.length; i++) {
            current = array[i];

            for (j = i; j > 0 && array[j - 1] > current; j--) {
                array[j] = array[j - 1];
            }

            array[j] = current;
        }
    }

    /* MÉTODO DE ORDENAMIENTO SHELL */
    public static void shellSort(int[] array) {
        int leap = array.length / 2;
        int movements, i, aux;

        while (leap >= 1) {
            do {
                movements = 0;

                for (i = 0; i < array.length - leap; i++) {
                    if (array[i + leap] < array[i]) {
                        aux = array[i + leap];
                        array[i + leap] = array[i];
                        array[i] = aux;
                        movements++;
                    }
                }
            } while (movements != 0);

            leap /= 2;
        }
    }

    /* MÉTODO DE ORDENAMIENTO QUICKSORT */
    public static void quickSort(int[] array, int first, int last) {
        int i = first, j = last, aux;
        int pivot = array[(first + last) / 2];

        do {
            while (array[i] < pivot) {
                i++;
            }

            while (array[j] > pivot) {
                j--;
            }

            if (i <= j) {
                aux = array[i];
                array[i] = array[j];
                array[j] = aux;

                i++;
                j--;
            }
        } while (i <= j);

        if (first < j) {
            quickSort(array, first, j);
        }

        if (last > i) {
            quickSort(array, i, last);
        }
    }

    /* MÉTODO DE ORDENAMIENTO RADIX LSD */
    public static void radixLSDSort(int[] array) {
        // Paso 1.- Pasar el arreglo a la lista
        LinkedList<Integer> list = new LinkedList<>();
        for (int j : array) {
            list.add(j);
        }

        // Paso 2.- Obtener el elemento más grande
        int max = list.getFirst();

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > max) {
                max = list.get(i);
            }
        }

        // Paso 3.- Calculamos el número de digits del número más grande
        int numberOfDigits = (String.valueOf(max)).length();

        // Paso 4.- Crear el arreglo de listas para los subíndices del 0 al 9
        LinkedList<Integer>[] lists = new LinkedList[10];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new LinkedList<>();
        }

        // Paso 5.- Realizar los ordenamientos
        for (int i = numberOfDigits - 1, turn = 1; i >= 0; i--, turn++) {
            while (!list.isEmpty()) {
                int element = list.removeFirst();
                String aux = String.valueOf(element);
                int size = aux.length();

                if (size < numberOfDigits) {
                    if (size < turn) {
                        lists[0].add(element);
                    } else {
                        int numberOfPosition = size - turn;
                        char charPosition = aux.charAt(numberOfPosition);
                        String position = String.valueOf(charPosition);
                        int finalPosition = Integer.parseInt(position);

                        lists[finalPosition].add(element);
                    }
                } else {
                    char charPosition = aux.charAt(i);
                    String position = String.valueOf(charPosition);
                    int finalPosition = Integer.parseInt(position);

                    lists[finalPosition].add(element);
                }
            }

            for (LinkedList<Integer> listIterator : lists) {
                for (int k = 0; k < listIterator.size(); k++) {
                    listIterator.add(list.get(k));
                }

                listIterator.clear();
            }
        }

        // Paso 6.- Pasamos la lista de regreso al arreglo
        for (int i = 0; i < array.length; i++) {
            array[i] = list.get(i);
        }
    }

    /* MÉTODO DE ORDENAMIENTO BUCKET SORT */
    public static void bucketSort(int[] array) {
        int position = 0;
        int max = array[0];

        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }

        int[] bucket = new int[max + 1];

        for (int k : array) {
            bucket[k]++;
        }

        for (int i = 0; i < bucket.length; i++) {
            for (int j = 0; j < bucket[i]; j++) {
                array[position++] = i;
            }
        }
    }

    /* MÉTODO DE ORDENAMIENTO COUNTING SORT */
    public static int[] countingSort(int[] array) {
        int size = array.length - 1;
        int k = array[0];

        for (int i = 1; i <= size; i++) {
            if (array[i] > k) {
                k = array[i];
            }
        }

        int[] array2 = new int[k + 1];

        for (int i = 0; i <= k; i++) {
            array2[i] = 0;
        }

        for (int i = 0; i <= size; i++) {
            array2[array[i]]++;
        }

        for (int i = 1; i <= k; i++) {
            array2[i] = array2[i] + array2[i - 1];
        }

        int[] array3 = new int[size + 1];

        for (int i = size; i >= 0; i--) {
            array2[array[i]] = array2[array[i]] - 1;
            array3[array2[array[i]]] = array[i];
        }

        return array3;
    }

    /* MÉTODO DE ORDENAMIENTO HEAP SORT */
    public static void heapSort(int[] array) {
        cheapish(array);

        for (int i = n; i > 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            n--;

            maxHeap(array, 0);
        }
    }

    public static void cheapish(int[] array) {
        n = array.length - 1;

        for (int i = n / 2; i >= 0; i--) {
            maxHeap(array, i);
        }
    }

    public static void maxHeap(int[] array, int i) {
        int left = 2 * i;
        int right = (2 * i) + 1;
        int max = i;

        if (left <= n && array[left] > array[i]) {
            max = left;
        }

        if (right <= n && array[right] > array[max]) {
            max = right;
        }

        if (max != i) {
            int temp = array[i];
            array[i] = array[max];
            array[max] = temp;

            maxHeap(array, max);
        }
    }

    /* MÉTODO DE ORDENAMIENTO INTERCALACIÓN */
    public static void interSort(int[] array, int[] array1, int[] array2) {
        int i, j, k;

        for (i = j = k = 0; i < array1.length && j < array2.length; k++) {
            if (array1[i] < array2[j]) {
                array[k] = array1[i];
                i++;
            } else {
                array[k] = array2[j];
                j++;
            }
        }

        for (; i < array1.length; i++, k++) {
            array[k] = array1[i];
        }

        for (; j < array1.length; j++, k++) {
            array[k] = array1[j];
        }
    }

    /* MÉTODO DE ORDENAMIENTO MERGE SORT */
    public static void mergeSort(int[] array) {
        int n = array.length;

        if (n >= 2) {
            int mid = n / 2;

            int[] left = new int[mid];
            int[] right = new int[n - mid];

            System.arraycopy(array, 0, left, 0, mid);
            if (n - mid >= 0) System.arraycopy(array, mid, right, 0, n - mid);

            mergeSort(left);
            mergeSort(right);
            merge(left, right, array);
        }
    }

    public static void merge(int[] left, int[] right, int[] array) {
        int nl = left.length, nr = right.length;
        int i = 0, j = 0, k = 0;

        while (i < nl && j < nr) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        while (i < nl) {
            array[k++] = left[i++];
        }

        while (j < nr) {
            array[k++] = right[j++];
        }
    }

    /* MÉTODO DE ORDENAMIENTO DIRECTLY MERGE SORT */
    public static void directlyMergeSort(int[] array) {
        int i, j, k;

        if (array.length > 1) {
            int numberOfLeftElements = array.length / 2;
            int numberOfRightElements = array.length - numberOfLeftElements;

            int[] arrayLeft = new int[numberOfLeftElements];
            int[] arrayRight = new int[numberOfRightElements];

            for (i = 0; i < numberOfLeftElements; i++) {
                arrayLeft[i] = array[i];
            }

            for (i = numberOfLeftElements; i < array.length; i++) {
                arrayRight[i - numberOfLeftElements] = array[i];
            }

            directlyMergeSort(arrayLeft);
            directlyMergeSort(arrayRight);

            i = 0; j = 0; k = 0;

            while (arrayLeft.length != j && arrayRight.length != k) {
                if (arrayLeft[j] < arrayRight[k]) {
                    array[i] = arrayLeft[j];
                    i++; j++;
                } else {
                    array[i] = arrayRight[k];
                    i++; k++;
                }
            }

            while (arrayLeft.length != j) {
                array[i] = arrayLeft[j];
                i++; j++;
            }

            while (arrayRight.length != k) {
                array[i] = arrayRight[k];
                i++; k++;
            }
        }
    }

    /* MÉTODO DE ORDENAMIENTO NATURAL MERGE SORT */
    public static void naturalMergeSort(int[] array) {
        int leftElement, left, rightElement = array.length - 1, right;
        boolean isSorted;

        do {
            isSorted = true;
            leftElement = 0;

            while (leftElement < rightElement) {
                left = leftElement;

                while (left < rightElement && array[left] <= array[left + 1]) {
                    left++;
                }

                right = left + 1;

                while (right == (rightElement - 1) || right < rightElement && array[right] <= array[right + 1]) {
                    right++;
                }

                if (right <= rightElement) {
                    directlyMergeSort(array);
                    isSorted = false;
                }

                leftElement = left;
            }
        } while (!isSorted);
    }

    /* MÉTODO DE ORDENAMIENTO RADIX SORT */
    public static void radixSort(int[] array) {
        int n = array.length;
        int max = array[0];

        for (int i = 1; i < n; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        for (int exp = 1; max / exp > 0; exp *= 10) {
            int[] out = new int[n];
            int i;
            int[] count = new int[10];

            for (i = 0; i < n; i++) {
                count[(array[i] / exp) % 10]++;
            }

            for (i = 1; i < 10; i++) {
                count[i] += count[i - 1];
            }

            for (i = n - 1; i >= 0; i--) {
                out[count[(array[i] / exp) % 10] - 1] = array[i];
                count[(array[i] / exp) % 10]--;
            }

            for (i = 0; i < n; i++) {
                array[i] = out[i];
            }
        }
    }
}
