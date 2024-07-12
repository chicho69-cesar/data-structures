package org.chicho69.cesar.graphs;

import javax.swing.*;

public class TestGraph {
    private boolean graphIsCreated;

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
                    // Crear grafo
                    System.out.println("Crear grafo");
                    this.graphIsCreated = true;

                    break;
                case 1:
                    if (this.graphIsCreated) {
                        // Recorrer grafo
                        System.out.println("Recorrer grafo");
                    } else {
                        JOptionPane.showMessageDialog(null, "Aun no has creado ningun grafo", "Error", JOptionPane.WARNING_MESSAGE);
                    }

                    break;
                case 2:
                    if (this.graphIsCreated) {
                        // Mostrar grafo
                        System.out.println("Mostrar grafo");
                    } else {
                        JOptionPane.showMessageDialog(null, "Aun no has creado ningun grafo", "Error", JOptionPane.WARNING_MESSAGE);
                    }

                    break;
                case 3: break;
            }
        } while (option != 3);
    }
}
