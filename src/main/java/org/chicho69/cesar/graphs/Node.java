package org.chicho69.cesar.graphs;

public class Node {
    private String name;
    private int weight;
    private Node next;

    public Node() {
        this.next = null;
    }

    public Node(String name) {
        this.name = name;
        this.next = null;
    }

    public Node(String name, int weight) {
        this.name = name;
        this.weight = weight;
        this.next = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public String getNode() {
        return this.weight == 0 ? this.name + " -> " : this.name + "|" + this.weight + " -> ";
    }
}
