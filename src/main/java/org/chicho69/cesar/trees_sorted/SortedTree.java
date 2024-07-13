package org.chicho69.cesar.trees_sorted;

public class SortedTree {
    private Node root = null;

    public SortedTree() {}

    public void insert(int data) {
        Node node = new Node(data, null);

        if (root == null) {
            root = node;
        } else {
            Node runner = root;

            while (true) {
                if (node.getData() > runner.getData()) {
                    if (runner.getRight() == null) {
                        runner.setRight(node);
                        runner.getRight().setFather(runner);
                        break;
                    } else {
                        runner = runner.getRight();
                    }
                } else {
                    if (runner.getLeft() == null) {
                        runner.setLeft(node);
                        runner.getLeft().setFather(runner);
                        break;
                    } else {
                        runner = runner.getLeft();
                    }
                }
            }
        }
    }

    public void show(Node tree, int counter) {
        if (!(tree == null)) {
            show(tree.getRight(), counter + 1);

            for (int i = 0; i < counter; i++) {
                System.out.print("\t");
            }

            System.out.println(tree.getData());

            show(tree.getLeft(), counter + 1);
        }
    }

    public boolean search(Node tree, int data) {
        if (tree == null) {
            return false;
        } else if (tree.getData() == data) {
            return true;
        } else if (data < tree.getData()) {
            return search(tree.getLeft(), data);
        } else {
            return search(tree.getRight(), data);
        }
    }

    public String preOrden(Node root) {
        if (root != null) {
            return root.getData() + ", " +
                    preOrden(root.getLeft()) +
                    preOrden(root.getRight());
        } else {
            return "";
        }
    }

    public String inOrden(Node root) {
        if (root != null) {
            return inOrden(root.getLeft()) +
                    root.getData() + ", " +
                    inOrden(root.getRight());
        } else {
            return "";
        }
    }

    public String postOrden(Node root) {
        if (root != null) {
            return postOrden(root.getLeft()) +
                    postOrden(root.getRight()) +
                    root.getData() + ", ";
        } else {
            return "";
        }
    }

    public void delete(Node tree, int data) {
        if (tree == null) {
            return;
        } else if (data < tree.getData()) {
            delete(tree.getLeft(), data);
        } else if (data > tree.getData()) {
            delete(tree.getRight(), data);
        } else {
            deleteNode(tree);
        }
    }

    public void deleteNode(Node nodeToDelete) {
        if ((nodeToDelete.getLeft() != null) && (nodeToDelete.getRight() != null)) {
            Node menor = minimum(nodeToDelete.getRight());
            nodeToDelete.setData(menor.getData());
            deleteNode(menor);
        } else if (nodeToDelete.getLeft() != null) {
            replace(nodeToDelete, nodeToDelete.getLeft());
        } else if (nodeToDelete.getRight() != null) {
            replace(nodeToDelete, nodeToDelete.getRight());
        } else if (nodeToDelete != root) {
            replace(nodeToDelete, null);
        } else {
            root = null;
        }
    }

    public Node minimum(Node tree) {
        if (tree == null) {
            return null;
        }

        if (tree.getLeft() != null){
            return minimum(tree.getLeft());
        } else {
            return tree;
        }
    }

    public void replace(Node tree, Node newNode) {
        if (tree.getFather() != null) {
            if (tree.getFather().getLeft() != null && tree.getData() == tree.getFather().getLeft().getData()) {
                tree.getFather().setLeft(newNode);
            } else if (tree.getFather().getRight() != null && tree.getData() == tree.getFather().getRight().getData()) {
                tree.getFather().setRight(newNode);
            }
        } else {
            if (tree.getLeft() != null && tree.getData() == tree.getLeft().getFather().getData()) {
                root = tree.getLeft();
            }

            if (tree.getRight() != null && tree.getData() == tree.getRight().getFather().getData()) {
                root = tree.getRight();
            }
        }

        if (newNode != null) {
            newNode.setFather(tree.getFather());
        }
    }

    public boolean isEmpty() {
        return root == null;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
}
