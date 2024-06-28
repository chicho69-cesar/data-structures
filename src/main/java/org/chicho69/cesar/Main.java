package org.chicho69.cesar;

import org.chicho69.cesar.bi_queues.TestBiQueue;
import org.chicho69.cesar.circular_queues.TestCircularQueues;
import org.chicho69.cesar.dynamic_arrays.TestDynamicArray;
import org.chicho69.cesar.dynamic_queues.TestDynamicQueue;
import org.chicho69.cesar.dynamic_stacks.TestDynamicStack;

public class Main {
    public static void main(String[] args) {
        /*TestBiQueue biQueue = new TestBiQueue();
        biQueue.menu();

        TestCircularQueues circularQueues = new TestCircularQueues();
        circularQueues.menu();

        TestDynamicArray dynamicArray = new TestDynamicArray();
        dynamicArray.run();

        TestDynamicQueue dynamicQueue = new TestDynamicQueue();
        dynamicQueue.menu(); */

        TestDynamicStack dynamicStack = new TestDynamicStack();
        dynamicStack.menu();
    }
}
