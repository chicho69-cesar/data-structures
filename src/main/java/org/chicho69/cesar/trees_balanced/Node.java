package org.chicho69.cesar.trees_balanced;

public class Node {
    private Node father;
    private Node left;
    private Node right;
    private int data;
    private int balance;
    private int height;
    private boolean sign;

    public Node(int data, Node father) {
        this(data, father, null, null);
    }

    public Node(int data, Node father, Node left, Node right) {
        this.data = data;
        this.father = father;
        this.left = left;
        this.right = right;

        this.sign = true;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getFather() {
        return father;
    }

    public void setFather(Node father) {
        this.father = father;
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

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean getSign() {
        return sign;
    }

    public void setSign(boolean sign) {
        this.sign = sign;
    }
}
