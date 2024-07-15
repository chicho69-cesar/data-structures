package org.chicho69.cesar.trees_balanced_and_sorted;

import java.util.Scanner;

public class TestTree {
    private final Tree tree;
    private final Scanner leer = new Scanner(System.in);

    public TestTree() {
        tree = new Tree();
    }

    public void menu() {
        int option;

        do {
            System.out.println("\n-----MENU PRINCIPAL-----");
            System.out.println("1.- Insertar un nuevo nodo");
            System.out.println("2.- Mostrar el arbol");
            System.out.println("3.- Buscar un elemento en el arbol");
            System.out.println("4.- Eliminar un nodo del arbol");
            System.out.println("5.- Salir");
            System.out.print("Escoge una opcion: ");
            option = leer.nextInt();

            int data;

            switch(option) {
                case 1:
                    System.out.print("\nEscribe el dato que deseas insertar: ");
                    data = leer.nextInt();

                    tree.insert(data);

                    System.out.println("Nodo agregado correctamente :)");

                    break;
                case 2:
                    if (tree.isEmpty()) {
                        System.err.println("\nEl arbol actualmente esta vacio :(");
                    } else {
                        System.out.println("\nEl arbol que digitaste es: \n");
                        tree.show(tree.getRoot(), 0);
                    }

                    break;
                case 3:
                    if (tree.isEmpty()) {
                        System.err.println("\nEl arbol actualmente esta vacio :(");
                    } else {
                        System.out.print("\nEscribe el dato que deseas buscar: ");
                        data = leer.nextInt();

                        if (tree.search(tree.getRoot(), data) == null) {
                            System.err.println("El nodo con el valor " + data + " no existe en el arbol :(");
                        } else {
                            System.out.println("El nodo con el valor " + data + " si se encuentra en el arbol :)");
                        }
                    }

                    break;
                case 4:
                    if (tree.isEmpty()) {
                        System.err.println("\nEl arbol actualmente esta vacio, no es posible eliminar elementos :(");
                    } else {
                        System.out.print("\nEscribe el dato que deseas eliminar: ");
                        data = leer.nextInt();

                        if (tree.delete(tree.getRoot(), data) != null) {
                            System.out.println("El nodo con el valor " + data + " se elimino correctamente :)");
                        }
                    }

                    break;
                case 5: break;
                default:
                    System.err.println("\nError escoge una opcion valida");
                    break;
            }
        } while (option != 5);
    }
}
