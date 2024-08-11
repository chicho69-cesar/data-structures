package org.chicho69.cesar.graphs_minimum_way;

import javax.swing.*;

public class Graph {
    private int[][] matrix;
    private int[][] minimums;
    private String[][] running;
    private String[] nodes;
    public boolean isCreated = false;

    public Graph() {}

    public void createGraph(int n) {
        matrix = new int[n][n];
        minimums = new int[n][n];
        running = new String[n][n];
        nodes = new String[n];

        readNodes(n);
        sortElements();
        fillRunning(n);
        loadMatrix(n);
        readElements(n);

        for (int i = 0; i < matrix.length; i++) {
            System.arraycopy(matrix[i], 0, minimums[i], 0, matrix[i].length);
        }

        JOptionPane.showMessageDialog(null, showMatrix(matrix, "Adyacencia"), "Matriz de Adyacencia", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, showRunning(), "Matriz de Recorridos", JOptionPane.INFORMATION_MESSAGE);

        minimumWay();

        isCreated = true;
    }

    private void readNodes(int n) {
        for (int i = 0; i < n; i++) {
            String nodeName = JOptionPane.showInputDialog("Escribe el nombre del nodo " + (i + 1));
            nodes[i] = nodeName;
        }
    }

    private void sortElements() {
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

    private void fillRunning(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    running[i][j] = "-";
                } else {
                    running[i][j] = nodes[j];
                }
            }
        }
    }

    private void loadMatrix(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    matrix[i][j] = 0;
                } else {
                    matrix[i][j] = 100;
                }
            }
        }
    }

    private void readElements(int n) {
        int relation, weight;
        Object[] options = new Object[n + 1];

        System.arraycopy(nodes, 0, options, 0, n);
        options[n] = "Siguiente";

        for (int i = 0; i < n; i++) {
            do {
                relation = JOptionPane.showOptionDialog(null, "¿Con quien tiene relacion el nodo " + options[i] + "?", "Escoge una opcion", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[n]);

                if (relation < n) {
                    weight = Integer.parseInt(JOptionPane.showInputDialog("Escribe el peso de la relacion: "));

                    if (relation == i) {
                        matrix[i][relation] = 0;
                    } else {
                        matrix[i][relation] = weight;
                    }

                    JOptionPane.showMessageDialog(null, options[i] + "  -->  " + options[relation] + "|" + weight, "Relacion", JOptionPane.INFORMATION_MESSAGE);
                }
            } while (relation != n);
        }
    }

    private void minimumWay() {
        for (int k = 0; k < minimums.length; k++) {
            for (int i = 0; i < minimums.length; i++) {
                for (int j = 0; j < minimums.length; j++) {
                    if (i != j) {
                        if (minimums[i][j] > (minimums[i][k] + minimums[k][j])) {
                            minimums[i][j] = minimums[i][k] + minimums[k][j];
                            running[i][j] = nodes[k];
                        }
                    }
                }
            }
        }
    }

    public String run() {
        StringBuilder way = new StringBuilder();

        Object[] nodeNames = new Object[nodes.length];
        System.arraycopy(nodes, 0, nodeNames, 0, nodes.length);

        int from = JOptionPane.showOptionDialog(null, "En que nodo inicia el recorrido", "Escoge una opcion", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, nodeNames, nodeNames[0]);
        int to = JOptionPane.showOptionDialog(null, "En que nodo finaliza el recorrido", "Escoge una opcion", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, nodeNames, nodeNames[0]);

        way.append("Para llegar de ").append(nodes[from]).append(" a ").append(nodes[to]).append(" debes de seguir el siguiente recorrido\n\n");
        way.append(nodes[from]).append(" -> ");

        int distance = minimums[from][to];

        if (from == to) {
            way.append(nodes[to]);
        } else if (nodes[to].equals(running[from][to])) {
            way.append(nodes[to]);
        } else {
            while (!(nodes[to].equals(running[from][to]))) {
                int pos1 = 0;

                while (!(nodes[pos1].equals(running[from][to]))) {
                    pos1++;
                }

                way.append(running[from][pos1]).append(" -> ");

                int pos2 = 0;

                while (!(nodes[pos2].equals(running[from][pos1]))) {
                    pos2++;
                }

                from = pos2;
            }

            way.append(nodes[to]);
        }

        way.append("     --->     Distancia = ");
        way.append((distance == 100) ? "Infinito" : distance);

        return way.toString();
    }

    public String distancesMatrix() {
        return showMatrix(matrix, "Distancias");
    }

    public String minimumWayMatrix() {
        return showMatrix(minimums, "Caminos Minimos");
    }

    public String showMatrix(int[][] matriz, String tipo) {
        StringBuilder matrix = new StringBuilder("Matriz de " + tipo + "\n\n");
        matrix.append("      ");

        for (String nodeName : nodes) {
            matrix.append(nodeName).append("    ");
        }

        matrix.append("\n");

        for (int i = 0; i < matriz.length; i++) {
            matrix.append(nodes[i]).append("   |");

            for (int j = 0; j < matriz[i].length; j++) {
                if (j == (matriz[i].length - 1)) {
                    matrix.append(matriz[i][j]).append("|");
                } else {
                    matrix.append(matriz[i][j]).append("    ");
                }
            }

            matrix.append("\n");
        }

        return matrix.toString();
    }

    public String showRunning() {
        StringBuilder matrix = new StringBuilder("Matriz de Recorridos\n\n");
        matrix.append("      ");

        for (String nodeName : nodes) {
            matrix.append(nodeName).append("    ");
        }

        matrix.append("\n");

        for (int i = 0; i < running.length; i++) {
            matrix.append(nodes[i]).append("   |");

            for (int j = 0; j < running[i].length; j++) {
                if (j == (running[i].length - 1)) {
                    matrix.append(running[i][j]).append("|");
                } else {
                    matrix.append(running[i][j]).append("    ");
                }
            }

            matrix.append("\n");
        }

        return matrix.toString();
    }
}
