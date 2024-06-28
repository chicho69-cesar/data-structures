package org.chicho69.cesar.dynamic_queues;

import javax.swing.*;

public class TestDynamicQueue {
    public DynamicQueue<String> dynamicQueue;

    public TestDynamicQueue() {
        dynamicQueue = new DynamicQueue<>();
    }

    public void menu() {
        int option;
        Object[] options = { "Insertar elementos", "Mostrar elementos", "Borrar elementos", "Limpiar la cola", "Salir" };

        do {
            option = JOptionPane.showOptionDialog(null, "Menu Principal", "Colas", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

            switch (option) {
                case 0 -> {
                    String data = JOptionPane.showInputDialog("Escribe el dato que deseas agregar a la Cola");
                    dynamicQueue.insert(data);
                    JOptionPane.showMessageDialog(null, "Nodo insertado correctamente :)", "Exito", JOptionPane.INFORMATION_MESSAGE);
                }

                case 1 -> {
                    if (dynamicQueue.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "La cola esta vacia :(", "Colas", JOptionPane.ERROR_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, dynamicQueue.elements(), "Colas", JOptionPane.INFORMATION_MESSAGE);
                    }
                }

                case 2 -> {
                    if (dynamicQueue.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "La cola esta vacia :(", "Colas", JOptionPane.ERROR_MESSAGE);
                    } else {
                        Node<String> eliminar = dynamicQueue.remove();
                        JOptionPane.showMessageDialog(null, "El nodo eliminado es: " + (String) eliminar.getInfo(), "Colas", JOptionPane.INFORMATION_MESSAGE);
                    }
                }

                case 3 -> {
                    if (dynamicQueue.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "La cola ya esta vacia :(", "Colas", JOptionPane.ERROR_MESSAGE);
                    } else {
                        dynamicQueue.clear();
                        JOptionPane.showMessageDialog(null, "La cola se ha vaciado con exito :)", "Colas", JOptionPane.INFORMATION_MESSAGE);
                    }
                }

                case 4 -> {}
            }
        } while (option != 4);
    }
}
