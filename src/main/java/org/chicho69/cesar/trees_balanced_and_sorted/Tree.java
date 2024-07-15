package org.chicho69.cesar.trees_balanced_and_sorted;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {
    Node root = null;

    public Tree() {}

    public void insert(int data) {
        Queue<Node> queue = new LinkedList<>();

        Node node = new Node(data, null);
        Node runner;

        if (root == null) {
            root = node;
        } else {
            queue.add(root);

            while (!queue.isEmpty()) {
                runner = queue.poll();

                if (runner.getLeft() != null) {
                    queue.add(runner.getLeft());
                } else {
                    runner.setLeft(node);
                    node.setFather(runner);
                    break;
                }

                if (runner.getRight() != null) {
                    queue.add(runner.getRight());
                } else {
                    runner.setRight(node);
                    node.setFather(runner);
                    break;
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

    public Node search(Node tree, int data) {
        Queue<Node> queue = new LinkedList<>();
        Node search = null, runner;

        if (tree != null) {
            queue.add(tree);

            while (!queue.isEmpty()) {
                runner = queue.poll();

                if (runner.getData() == data) {
                    search = runner;
                    break;
                } else {
                    if (runner.getLeft() != null) {
                        queue.add(runner.getLeft());
                    }

                    if (runner.getRight() != null) {
                        queue.add(runner.getRight());
                    }
                }
            }
        }

        return search;
    }

    public Node delete(Node tree, int data) {
        Queue<Node> queue = new LinkedList<>();
        boolean isSheet = false;
        Node delete = null, runner;

        queue.add(tree);

        while (!queue.isEmpty()) {
            runner = queue.poll();

            if (runner.getData() == data) {
                delete = runner;

                if (!((delete.getLeft() != null) || (delete.getRight() != null))) {
                    isSheet = true;
                    break;
                }
            } else {
                if (runner.getLeft() != null) {
                    queue.add(runner.getLeft());
                }

                if (runner.getRight() != null) {
                    queue.add(runner.getRight());
                }
            }
        }

        if (delete != null && isSheet) {
            if (delete.getFather() != null) {
                if (delete.getFather().getLeft() != null && delete.getFather().getLeft().getData() == data) {
                    delete.getFather().setLeft(null);
                } else if (delete.getFather().getRight() != null && delete.getFather().getRight().getData() == data) {
                    delete.getFather().setRight(null);
                }
            } else {
                root = null;
            }

            return delete;
        } else {
            if (delete != null) {
                System.err.println("Este nodo no se puede elimar, no es una hoja :(");
            } else {
                System.err.println("El dato que digitaste no se encuentra en el arbol :(");
            }

            return null;
        }
    }

    public boolean isEmpty() {
        return (root == null);
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
}
