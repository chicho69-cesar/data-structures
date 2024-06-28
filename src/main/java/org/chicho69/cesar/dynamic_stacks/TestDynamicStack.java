package org.chicho69.cesar.dynamic_stacks;

import javax.swing.*;

public class TestDynamicStack {
    private final DynamicStack<String> stack = new DynamicStack<>();

    public TestDynamicStack() {}

    public void menu() {
        int option;
        Object[] options = {"Insertar elementos", "Mostrar elementos", "Borrar elementos", "Limpiar la pila", "Salir"};

        do {
            option = JOptionPane.showOptionDialog(null, "Menu Principal", "Pilas", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

            switch (option) {
                case 0 -> {
                    String dato = JOptionPane.showInputDialog("Escribe el dato que deseas agregar a la Pila");
                    stack.insert(dato);
                    JOptionPane.showMessageDialog(null, "Nodo insertado correctamente :)", "Exito", JOptionPane.INFORMATION_MESSAGE);
                }

                case 1 -> {
                    if (stack.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "La pila esta vacia :(", "Pilas", JOptionPane.ERROR_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, stack.elements(), "Pilas", JOptionPane.INFORMATION_MESSAGE);
                    }
                }

                case 2 -> {
                    if (stack.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "La pila esta vacia :(", "Pilas", JOptionPane.ERROR_MESSAGE);
                    } else {
                        Node eliminar = stack.remove();
                        JOptionPane.showMessageDialog(null, "El nodo eliminado es: " + (String) eliminar.getInfo(), "Pilas", JOptionPane.INFORMATION_MESSAGE);
                    }
                }

                case 3 -> {
                    if (stack.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "La pila ya esta vacia :(", "Pilas", JOptionPane.ERROR_MESSAGE);
                    } else {
                        stack.clear();
                        JOptionPane.showMessageDialog(null, "La pila se ha vaciado con exito :)", "Pilas", JOptionPane.INFORMATION_MESSAGE);
                    }
                }

                case 4 -> {}
            }
        } while (option != 4);
    }
}
