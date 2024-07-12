package org.chicho69.cesar;

import org.chicho69.cesar.hash_tables.TestHashTable;
import org.chicho69.cesar.infix_to_postfix_advanced.InfixToPostfixAdvanced;
import org.chicho69.cesar.infix_to_postfix_simple.InfixToPostfixSimple;
import org.chicho69.cesar.infix_to_prefix_advanced.InfixToPrefixAdvanced;
import org.chicho69.cesar.infix_to_prefix_simple.InfixToPrefixSimple;
import org.chicho69.cesar.linked_lists.TestLinkedList;
import org.chicho69.cesar.prefix_evaluation.PrefixEvaluation;

public class Main {
    public static void main(String[] args) {
        /*TestBiQueue biQueue = new TestBiQueue();
        biQueue.menu();

        TestCircularQueues circularQueues = new TestCircularQueues();
        circularQueues.menu();

        TestDynamicArray dynamicArray = new TestDynamicArray();
        dynamicArray.run();

        TestDynamicQueue dynamicQueue = new TestDynamicQueue();
        dynamicQueue.menu();

        TestDynamicStack dynamicStack = new TestDynamicStack();
        dynamicStack.menu();

        TestHashTable hashTable = new TestHashTable();
        hashTable.run();

        TestHashTable hashTable = new TestHashTable();
        hashTable.run(); */

        TestLinkedList linkedList = new TestLinkedList();
        linkedList.run();

        /* InfixToPostfixSimple.run();
        InfixToPrefixSimple.run();
        InfixToPostfixAdvanced.run();
        InfixToPrefixAdvanced.run();
        PostfixEvaluation.run();
        PrefixEvaluation.run();
        PostfixToInfix.run();
        PrefixToInfix.run(); */
    }
}
