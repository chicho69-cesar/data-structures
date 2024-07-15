package org.chicho69.cesar.trees_balanced;

import java.util.Stack;

public class BalancedTree {
    private Node root = null;

    public BalancedTree() {}

    public boolean insert(int data) {
        if (root == null) {
            root = new Node(data, null);
        } else {
            Node node = root;
            Node father;

            while (true) {
                if (node.getData() == data) {
                    return false;
                }

                father = node;

                boolean goLeft = node.getData() > data;
                node = (goLeft)? node.getLeft() : node.getRight();

                if (node == null) {
                    if (goLeft) {
                        father.setLeft(new Node(data, father));
                    } else {
                        father.setRight(new Node(data, father));
                    }

                    rebalanced(father);
                    break;
                }
            }
        }

        return true;
    }

    public void rebalanced(Node node) {
        setBalance(node);

        if (node.getBalance() == -2) {
            if (height(node.getLeft().getLeft()) >= height(node.getLeft().getRight())) {
                node = rotateToRight(node);
            } else {
                node = rotateFromLeftToRight(node);
            }
        } else if (node.getBalance() == 2) {
            if (height(node.getRight().getRight()) >= height(node.getRight().getLeft())) {
                node = rotateToLeft(node);
            } else {
                node = rotateFromRightToLeft(node);
            }
        }

        if (node.getFather() != null) {
            rebalanced(node.getFather());
        } else {
            root = node;
        }
    }

    public void setBalance(Node... nodes) {
        for (Node node : nodes) {
            reHeight(node);
            node.setBalance(height(node.getRight()) - height(node.getLeft()));
        }
    }

    public int height(Node node) {
        if (node == null) {
            return -1;
        } else {
            return node.getHeight();
        }
    }

    public void reHeight(Node node) {
        if (node != null) {
            node.setHeight(1 + Math.max(height(node.getLeft()), height(node.getRight())));
        }
    }

    public void showTree(Node tree, int counter) {
        if (!(tree == null)) {
            showTree(tree.getRight(), counter + 1);

            for (int i = 0; i < counter; i++) {
                System.out.print("\t");
            }

            System.out.println(tree.getData());

            showTree(tree.getLeft(), counter + 1);
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
        Stack<Node> stack = new Stack<>();
        Node runner;
        StringBuilder preOrden = new StringBuilder();

        stack.push(null);
        runner = root;

        while (runner != null) {
            preOrden.append(runner.getData()).append(", ");

            if (runner.getRight() != null) {
                stack.push(runner.getRight());
            }

            if (runner.getLeft() != null) {
                runner = runner.getLeft();
            } else {
                runner = stack.pop();
            }
        }

        return preOrden.toString();
    }

    public String inOrden(Node root) {
        Stack<Node> stack = new Stack<>();
        Node runner;
        StringBuilder inOrden = new StringBuilder();

        stack.push(null);
        runner = root;

        while (runner != null) {
            while (runner != null) {
                stack.push(runner);
                runner = runner.getLeft();
            }

            runner = stack.pop();

            while (runner != null) {
                inOrden.append(runner.getData()).append(", ");

                if (runner.getRight() != null) {
                    runner = runner.getRight();
                    break;
                }

                runner = stack.pop();
            }
        }

        return inOrden.toString();
    }

    public String postOrden(Node root) {
        Stack<Node> stack = new Stack<>();
        Node runner;
        StringBuilder postOrden = new StringBuilder();

        stack.push(null);
        runner = root;

        while (runner != null) {
            while (runner != null) {
                stack.push(runner);

                if (runner.getRight() != null) {
                    runner.getRight().setSign(false);
                    stack.push(runner.getRight());
                }

                runner = runner.getLeft();
            }

            runner = stack.pop();

            while (runner != null && runner.getSign()) {
                postOrden.append(runner.getData()).append(", ");
                runner = stack.pop();
            }

            if (runner != null && !runner.getSign()) {
                runner.setSign(true);
            }
        }

        return postOrden.toString();
    }

    public void delete(int data) {
        if (root == null) {
            return;
        }

        Node node;
        Node son = root;

        while (son != null) {
            node = son;

            son = (data > node.getData())? node.getRight() : node.getLeft();

            if (data == node.getData()) {
                deleteNode(node);
                return;
            }
        }
    }

    public void deleteNode(Node node) {
        if (node.getLeft() == null && node.getRight() == null) {
            if (node.getFather() == null) {
                root = null;
            } else {
                Node father = node.getFather();

                if (father.getLeft() == node) {
                    father.setLeft(null);
                } else {
                    father.setRight(null);
                }

                rebalanced(father);
            }

            return;
        }

        Node son;

        if (node.getLeft() != null) {
            son = node.getLeft();

            while (son.getRight() != null) {
                son = son.getRight();
            }
        } else {
            son = node.getRight();

            while (son.getLeft() != null) {
                son = son.getLeft();
            }
        }

        node.setData(son.getData());
        deleteNode(son);
    }

    public Node rotateToRight(Node node) {
        Node aux = node.getLeft();
        aux.setFather(node.getFather());

        node.setLeft(aux.getRight());

        if (node.getLeft() != null) {
            node.getLeft().setFather(node);
        }

        aux.setRight(node);
        node.setFather(aux);

        if (aux.getFather() != null) {
            if (aux.getFather().getRight() == node) {
                aux.getFather().setRight(aux);
            } else {
                aux.getFather().setLeft(aux);
            }
        }

        setBalance(node, aux);

        return aux;
    }

    public Node rotateToLeft(Node node) {
        Node aux = node.getRight();
        aux.setFather(node.getFather());

        node.setRight(aux.getLeft());

        if (node.getRight() != null) {
            node.getRight().setFather(node);
        }

        aux.setLeft(node);
        node.setFather(aux);

        if (aux.getFather() != null) {
            if (aux.getFather().getRight() == node) {
                aux.getFather().setRight(aux);
            } else {
                aux.getFather().setLeft(aux);
            }
        }

        setBalance(node, aux);

        return aux;
    }

    public Node rotateFromLeftToRight(Node node) {
        node.setLeft(rotateToLeft(node.getLeft()));
        return rotateToRight(node);
    }

    public Node rotateFromRightToLeft(Node node) {
        node.setRight(rotateToRight(node.getRight()));
        return rotateToLeft(node);
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
