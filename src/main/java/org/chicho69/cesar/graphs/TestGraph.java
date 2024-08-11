package org.chicho69.cesar.graphs;

import javax.swing.*;

public class TestGraph {
    private boolean graphIsCreated;
    private Graph graph;

    public TestGraph() {
        this.graphIsCreated = false;
    }

    public void menu() {
        int option;
        Object[] op1 = {"Crear", "Recorrer", "Mostrar", "Salir"};

        do {
            option = JOptionPane.showOptionDialog(null, "Escoge una opcion", "Menu Principal Grafos", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, op1, op1[0]);

            switch (option) {
                case 0:
                    createGraph();
                    this.graphIsCreated = true;

                    break;
                case 1:
                    if (this.graphIsCreated) {
                        walkGraph();
                    } else {
                        JOptionPane.showMessageDialog(null, "Aun no has creado ningun grafo", "Error", JOptionPane.WARNING_MESSAGE);
                    }

                    break;
                case 2:
                    if (this.graphIsCreated) {
                        showGraph();
                    } else {
                        JOptionPane.showMessageDialog(null, "Aun no has creado ningun grafo", "Error", JOptionPane.WARNING_MESSAGE);
                    }

                    break;
                case 3: break;
            }
        } while (option != 3);
    }

    public void createGraph() {
        boolean flag = false;
        int numberOfElements = 0;
        Object[] options = {"Si", "NO"};

        int pondered = JOptionPane.showOptionDialog(null, "¿Es ponderado?", "Escoge una opcion", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        int directed = JOptionPane.showOptionDialog(null, "¿Es dirigido?", "Escoge una opcion", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        boolean isDirected = directed == 0;
        boolean isWeighted = pondered == 0;

        while (!flag) {
            try {
                numberOfElements = Integer.parseInt(JOptionPane.showInputDialog("¿Cuatos nodos tiene?"));
                flag = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error. Escribe un numero valido", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }

        this.graph = new Graph(numberOfElements, isWeighted, isDirected);
        this.graph.createGraph(numberOfElements);
        this.graphIsCreated = true;
    }

    public void walkGraph() {
        int option;
        Object[] options = {"Anchura", "Profundidad", "Regresar"};

        do {
            option = JOptionPane.showOptionDialog(null, "¿Como deseas recorrer el Grafo?", "Recorrer el Grafo", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

            switch (option) {
                case 0:
                    JOptionPane.showMessageDialog(null, "El recorrido por Anchura es: " + this.graph.walkInWidth(), "Recorrido por anchura", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 1:
                    JOptionPane.showMessageDialog(null, "El recorrido por Profundidad es: " + this.graph.walkInHeight(), "Recorrido por profundidad", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 2: break;
            }
        } while (option != 2);
    }

    public void showGraph() {
        int option;
        Object[] options = {"Matriz de adyacencia", "Lista de adyacencia", "Regresar"};

        do {
            option = JOptionPane.showOptionDialog(null, "¿Como deseas ver el Grafo?", "Mostrar el Grafo", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

            switch (option) {
                case 0:
                    JOptionPane.showMessageDialog(null, this.graph.showMatrix(), "Matriz de Adyacencia", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 1:
                    JOptionPane.showMessageDialog(null, this.graph.showList(), "Lista de Adyacencia", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 2: break;
            }
        } while (option != 2);
    }
}
