package org.chicho69.cesar.graphs_minimum_way;

import javax.swing.*;

public class TestGraphMinimumWay {
    private Graph graph;

    public TestGraphMinimumWay() {
        graph = new Graph();
    }

    public void menu() {
        Object[] options = {"Crear grafo", "Mostrar matriz de distancias", "Camino de nodo a nodo", "Salir"};

        int option;

        do {
            option = JOptionPane.showOptionDialog(null, "¿Escoge una opcion?", "Grafos", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[3]);

            switch (option) {
                case 0 -> {
                    int size = Integer.parseInt(JOptionPane.showInputDialog("Escribe el numero de elementos del grafo: "));
                    graph.createGraph(size);
                }

                case 1 -> {
                    if (graph.isCreated) {
                        JOptionPane.showMessageDialog(null, graph.distancesMatrix(), "Matriz de Adyacencia", JOptionPane.INFORMATION_MESSAGE);
                        JOptionPane.showMessageDialog(null, graph.minimumWayMatrix(), "Matriz de Adyacencia", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "No has creado un grafo", "Matriz de Adyacencia", JOptionPane.ERROR_MESSAGE);
                    }
                }

                case 2 -> {
                    if (graph.isCreated) {
                        JOptionPane.showMessageDialog(null, graph.showRunning(), "Matriz de Adyacencia", JOptionPane.INFORMATION_MESSAGE);
                        JOptionPane.showMessageDialog(null, graph.run(), "Camino mas corto", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "No has creado un grafo", "Matriz de Adyacencia", JOptionPane.ERROR_MESSAGE);
                    }
                }

                case 3 -> {}
            }
        } while (option != 3);
    }
}
