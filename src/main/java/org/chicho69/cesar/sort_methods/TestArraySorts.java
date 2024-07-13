package org.chicho69.cesar.sort_methods;

import java.util.Arrays;
import java.util.Random;

public class TestArraySorts {
    public static void run() {
        final int MAX = 75000;
        Random random = new Random();

        int[] bubble = new int[MAX];
        int[] improvedBubble = new int[MAX];
        int[] bidirectionalBubble = new int[MAX];
        int[] selection = new int[MAX];
        int[] improvedSelection = new int[MAX];
        int[] intersection = new int[MAX];
        int[] shell = new int[MAX];
        int[] quick = new int[MAX];
        int[] radixLSD = new int[MAX];
        int[] bucket = new int[MAX];
        int[] counting = new int[MAX];
        int[] heap = new int[MAX];
        int[] intercalation = new int[MAX];
        int[] merge = new int[MAX];
        int[] directlyMerge = new int[MAX];
        int[] naturalMerge = new int[MAX];
        int[] radix = new int[MAX];
        int[] sort = new int[MAX];

        for (int i = 0; i < MAX; i++) {
            int numero = random.nextInt(100000);

            bubble[i] = numero;
            improvedBubble[i] = numero;
            bidirectionalBubble[i] = numero;
            selection[i] = numero;
            improvedSelection[i] = numero;
            intersection[i] = numero;
            shell[i] = numero;
            quick[i] = numero;
            radixLSD[i] = numero;
            bucket[i] = numero;
            counting[i] = numero;
            heap[i] = numero;
            intercalation[i] = numero;
            merge[i] = numero;
            directlyMerge[i] = numero;
            naturalMerge[i] = numero;
            radix[i] = numero;
            sort[i] = numero;
        }

        printResults(bubble, "Bubble", false);
        printResults(improvedBubble, "Improved Bubble", false);
        printResults(bidirectionalBubble, "Bidirectional Bubble", false);
        printResults(selection, "Selection", false);
        printResults(improvedSelection, "Improved Selection", false);
        printResults(intersection, "Insertion", false);
        printResults(shell, "Shell", false);
        printResults(quick, "Quick", false);
        // printResults(radixLSD, "Radix LSD", false);
        printResults(bucket, "Bucket", false);
        printResults(counting, "Counting", false);
        printResults(heap, "Heap", false);
        printResults(intercalation, "Intercalation", false);
        printResults(merge, "Merge", false);
        printResults(directlyMerge, "Directly Merge", false);
        printResults(naturalMerge, "Natural Merge", false);
        printResults(radix, "Radix", false);
        printResults(sort, "Sort", false);
    }

    public static void printResults(int[] array, String method, boolean show) {
        long start, end;

        if (show) {
            System.out.println("\n" + list(array));
        }

        start = System.currentTimeMillis();

        switch(method) {
            case "Bubble" -> {
                ArraySorts.bubbleSort(array);
            }

            case "Improved Bubble" -> {
                ArraySorts.improvedBubbleSort(array);
            }

            case "Bidirectional Bubble" -> {
                ArraySorts.bidirectionalBubbleSort(array);
            }

            case "Selection" -> {
                ArraySorts.selectionSort(array);
            }

            case "Improved Selection" -> {
                ArraySorts.improvedSelectionSort(array);
            }

            case "Insertion" -> {
                ArraySorts.insertionSort(array);
            }

            case "Shell" -> {
                ArraySorts.shellSort(array);
            }

            case "Quick" -> {
                ArraySorts.quickSort(array, 0, (array.length - 1));
            }

            case "Radix LSD" -> {
                ArraySorts.radixLSDSort(array);
            }

            case "Bucket" -> {
                ArraySorts.bucketSort(array);
            }

            case "Counting" -> {
                array = ArraySorts.countingSort(array);
            }

            case "Heap" -> {
                ArraySorts.heapSort(array);
            }

            case "Intercalation" -> {
                int size1 = array.length / 2;
                int size2 = array.length - size1;

                int[] array1 = new int[size1];
                int[] array2 = new int[size2];

                System.arraycopy(array, 0, array1, 0, array1.length);

                for (int j = size1, i = 0; j < array.length; j++, i++) {
                    array2[i] = array[j];
                }

                Arrays.sort(array1);
                Arrays.sort(array2);

                ArraySorts.interSort(array, array1, array2);
            }

            case "Merge" -> {
                ArraySorts.mergeSort(array);
            }

            case "Directly Merge" -> {
                ArraySorts.directlyMergeSort(array);
            }

            case "Natural Merge" -> {
                ArraySorts.naturalMergeSort(array);
            }

            case "Radix" -> {
                ArraySorts.radixSort(array);
            }

            case "Sort" -> {
                Arrays.sort(array);
            }
        }

        end = System.currentTimeMillis();

        System.out.println(method + ": " + (end - start));

        if (show) {
            System.out.println(list(array));
        }
    }

    public static String list(int[] array) {
        StringBuilder arreglo = new StringBuilder("[" + array[0]);

        for (int i = 1; i < array.length; i++) {
            arreglo.append(", ").append(array[i]);
        }

        arreglo.append("]");

        return arreglo.toString();
    }
}
