package org.chicho69.cesar;

import org.chicho69.cesar.graphs.TestGraph;
import org.chicho69.cesar.graphs_minimum_way.TestGraphMinimumWay;
import org.chicho69.cesar.hash_tables.TestHashTable;
import org.chicho69.cesar.infix_to_postfix_advanced.InfixToPostfixAdvanced;
import org.chicho69.cesar.infix_to_postfix_simple.InfixToPostfixSimple;
import org.chicho69.cesar.infix_to_prefix_advanced.InfixToPrefixAdvanced;
import org.chicho69.cesar.infix_to_prefix_simple.InfixToPrefixSimple;
import org.chicho69.cesar.linked_lists.TestLinkedList;
import org.chicho69.cesar.prefix_evaluation.PrefixEvaluation;
import org.chicho69.cesar.search_methods.TestArraySearches;
import org.chicho69.cesar.simple_queues.TestSimpleQueue;
import org.chicho69.cesar.simple_stacks.TestSimpleStack;
import org.chicho69.cesar.sort_methods.TestArraySorts;
import org.chicho69.cesar.trees_balanced.TestBalancedTree;
import org.chicho69.cesar.trees_balanced_and_sorted.TestTree;
import org.chicho69.cesar.trees_sorted.TestTreeSorted;

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
        hashTable.run();

        TestLinkedList linkedList = new TestLinkedList();
        linkedList.run();

        TestArraySearches.run();
        TestArraySorts.run();

        TestSimpleQueue simpleQueue = new TestSimpleQueue();
        simpleQueue.menu();

        TestSimpleStack simpleStack = new TestSimpleStack();
        simpleStack.menu();

        InfixToPostfixSimple.run();
        InfixToPrefixSimple.run();
        InfixToPostfixAdvanced.run();
        InfixToPrefixAdvanced.run();
        PostfixEvaluation.run();
        PrefixEvaluation.run();
        PostfixToInfix.run();
        PrefixToInfix.run();

        TestTreeSorted treeSorted = new TestTreeSorted();
        treeSorted.menu();

        TestBalancedTree balancedTree = new TestBalancedTree();
        balancedTree.menu();

        TestTree tree = new TestTree();
        tree.menu();

        TestGraph testGraph = new TestGraph();
        testGraph.menu(); */

        TestGraphMinimumWay testGraphMinimumWay = new TestGraphMinimumWay();
        testGraphMinimumWay.menu();
    }
}
