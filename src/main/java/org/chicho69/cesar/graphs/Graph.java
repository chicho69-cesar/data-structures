package org.chicho69.cesar.graphs;

import javax.swing.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {
    private int[][] adjacencyMatrix;
    private Node[] adjacencyList, finals;
    private String[] nodes;
    private Node node;
    private final boolean isWeighted;
    private final boolean isDirected;

    public Graph(int numberOfElements, boolean isWeighted, boolean isDirected) {
        this.adjacencyMatrix = new int[numberOfElements][numberOfElements];
        this.adjacencyList = new Node[numberOfElements];
        this.finals = new Node[numberOfElements];
        this.nodes = new String[numberOfElements];
        this.isWeighted = isWeighted;
        this.isDirected = isDirected;
    }

    public void createGraph(int numberOfElements) {
        adjacencyMatrix = new int[numberOfElements][numberOfElements];
        adjacencyList = new Node[numberOfElements];
        finals = new Node[numberOfElements];
        nodes = new String[numberOfElements];

        for (int i = 0; i < numberOfElements; i++) {
            String nodeName = JOptionPane.showInputDialog("Escribe el nombre del nodo " + (i + 1));
            nodes[i] = nodeName;
        }

        sortElements();
        fillMatrix(numberOfElements);
        loadList(numberOfElements);
        fillList(numberOfElements);
    }

    public void fillMatrix(int numberOfElements) {
        int relation, weight;
        Object[] options = new Object[numberOfElements + 1];

        System.arraycopy(nodes, 0, options, 0, numberOfElements);
        options[numberOfElements] = "Siguiente";

        for (int i = 0; i < numberOfElements; i++) {
            do {
                relation = JOptionPane.showOptionDialog(null, "¿Con quien tiene relacion el nodo " + options[i] + "?", "Escoge una opcion", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[numberOfElements]);

                if (relation < numberOfElements) {
                    if (this.isWeighted && this.isDirected) {
                        weight = Integer.parseInt(JOptionPane.showInputDialog("Escribe el peso de la relacion: "));
                        adjacencyMatrix[i][relation] = weight;
                        JOptionPane.showMessageDialog(null, options[i] + " -> " + options[relation] + " -> " + weight, "Relacion", JOptionPane.INFORMATION_MESSAGE);
                    } else if (!this.isWeighted && this.isDirected) {
                        adjacencyMatrix[i][relation] = 1;
                        JOptionPane.showMessageDialog(null, options[i] + " -> " + options[relation], "Relacion", JOptionPane.INFORMATION_MESSAGE);
                    } else if (this.isWeighted && !this.isDirected) {
                        weight = Integer.parseInt(JOptionPane.showInputDialog("Escribe el peso de la relacion: "));
                        adjacencyMatrix[i][relation] = weight;
                        adjacencyMatrix[relation][i] = weight;
                        JOptionPane.showMessageDialog(null, options[i] + " -> " + options[relation] + " -> " + weight, "Relacion", JOptionPane.INFORMATION_MESSAGE);
                    } else if (!this.isWeighted && !this.isDirected) {
                        adjacencyMatrix[i][relation] = 1;
                        adjacencyMatrix[relation][i] = 1;
                        JOptionPane.showMessageDialog(null, options[i] + " -> " + options[relation], "Relacion", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            } while (relation != numberOfElements);
        }
    }

    public void fillList(int numberOfElements) {
        if (this.isWeighted) {
            for (int i = 0; i < numberOfElements; i++) {
                node = new Node(nodes[i]);

                adjacencyList[i] = node;
                finals[i] = node;

                for (int j = 0; j < numberOfElements; j++) {
                    if (adjacencyMatrix[i][j] != 0) {
                        node = new Node(nodes[j], adjacencyMatrix[i][j]);

                        finals[i].setNext(node);
                        finals[i] = node;
                    }
                }
            }
        } else {
            for (int i = 0; i < numberOfElements; i++) {
                node = new Node(nodes[i]);

                adjacencyList[i] = node;
                finals[i] = node;

                for (int j = 0; j < numberOfElements; j++) {
                    if (adjacencyMatrix[i][j] == 1) {
                        node = new Node(nodes[j]);

                        finals[i].setNext(node);
                        finals[i] = node;
                    }
                }
            }
        }
    }

    public void sortElements() {
        String aux;

        for (int i = 0; i < nodes.length; i++) {
            for (int j = 0; j < nodes.length; j++) {
                if (nodes[i].compareTo(nodes[j]) < 0) {
                    aux = nodes[i];
                    nodes[i] = nodes[j];
                    nodes[j] = aux;
                }
            }
        }
    }

    public void loadList(int numElementos) {
        for (int i = 0; i < numElementos; i++) {
            adjacencyList[i] = null;
            finals[i] = null;
        }
    }

    public String walkInWidth() {
        Queue<String> queue = new LinkedList<>();
        Queue<String> processing = new LinkedList<>();
        Object[] elements = new Object[nodes.length];
        StringBuilder width = new StringBuilder();

        System.arraycopy(nodes, 0, elements, 0, nodes.length);

        int startAt = JOptionPane.showOptionDialog(null, "¿En que nodo deseas comenzar el recorrido?", "Anchura", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, elements, elements[0]);

        String w, v = nodes[startAt];

        queue.offer(v);

        while (!queue.isEmpty()) {
            w = queue.poll();

            if (!processing.contains(w)) {
                width.append(w).append(", ");
                processing.offer(w);
            }

            int pos = 0;

            while (!nodes[pos].equals(w)) {
                pos++;
            }

            for (int i = 0; i < nodes.length; i++) {
                if ((adjacencyMatrix[pos][i] != 0) && !processing.contains(nodes[i])) {
                    queue.offer(nodes[i]);
                }
            }
        }

        return width.toString();
    }

    public String walkInHeight() {
        Stack<String> stack = new Stack<>();
        Stack<String> processing = new Stack<>();
        Object[] elements = new Object[nodes.length];
        StringBuilder height = new StringBuilder();

        System.arraycopy(nodes, 0, elements, 0, nodes.length);

        int startAt = JOptionPane.showOptionDialog(null, "¿En que nodo deseas comenzar el recorrido?", "Profundidad", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, elements, elements[0]);

        String w, v = nodes[startAt];

        stack.push(v);

        while (!stack.isEmpty()) {
            w = stack.pop();

            if (!processing.contains(w)) {
                height.append(w).append(", ");
                processing.push(w);
            }

            int pos = 0;

            while (!nodes[pos].equals(w)) {
                pos++;
            }

            for (int i = 0; i < nodes.length; i++) {
                if ((adjacencyMatrix[pos][i] != 0) && !processing.contains(nodes[i])) {
                    stack.push(nodes[i]);
                }
            }
        }

        return height.toString();
    }

    public String showMatrix() {
        StringBuilder matrix = new StringBuilder("Matriz de Adyacencia\n\n");
        matrix.append("      ");

        for (String nodeName : nodes) {
            matrix.append(nodeName).append("    ");
        }

        matrix.append("\n");

        for (int i = 0; i < adjacencyMatrix.length; i++) {
            matrix.append(nodes[i]).append("   |");

            for (int j = 0; j < adjacencyMatrix[i].length; j++) {
                if (j == (adjacencyMatrix[i].length - 1)) {
                    matrix.append(adjacencyMatrix[i][j]).append("|");
                } else {
                    matrix.append(adjacencyMatrix[i][j]).append("    ");
                }
            }

            matrix.append("\n");
        }

        return matrix.toString();
    }

    public String showList() {
        StringBuilder list = new StringBuilder("Lista de Adyacencia\n\n");

        for (Node nodeName : adjacencyList) {
            node = nodeName;

            while (node != null) {
                list.append(node.getNode());
                node = node.getNext();
            }

            list.append("/\n");
        }

        return list.toString();
    }
}
