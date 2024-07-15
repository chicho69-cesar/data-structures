package org.chicho69.cesar.trees_balanced_and_sorted;

public class Node {
    private Node father;
    private int data;
    private Node left;
    private Node right;

    public Node(int data, Node father) {
        this(father, data, null, null);
    }

    public Node(Node father, int data, Node left, Node right) {
        this.father = father;
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public Node getFather() {
        return father;
    }

    public void setFather(Node father) {
        this.father = father;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
