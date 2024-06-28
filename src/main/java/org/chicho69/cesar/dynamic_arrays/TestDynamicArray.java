package org.chicho69.cesar.dynamic_arrays;

public class TestDynamicArray {
    public DynamicArray<Integer> dynamicArray;

    public TestDynamicArray() {
        dynamicArray = new DynamicArray<>();
    }

    public void run() {
        for (int i = 1; i <= 10; i++) {
            dynamicArray.insert(i);
        }

        for (int i = 0; i < dynamicArray.size(); i++) {
            System.out.print(dynamicArray.get(i) + " - ");
        }

        System.out.println();

        dynamicArray.insert(10, 11);
        dynamicArray.insert(11, 12);

        dynamicArray.delete(10);

        System.out.println(dynamicArray.remove(10));

        System.out.println((dynamicArray.contains(5))? "Si esta" : "No esta");

        System.out.println(dynamicArray.getIndex(7));

        dynamicArray.set(6, 77);
        System.out.println(dynamicArray.get(6));

        dynamicArray.delete(2);

        for (int i = 0; i < dynamicArray.size(); i++) {
            System.out.print(dynamicArray.get(i) + " - ");
        }

        System.out.println();
    }
}
