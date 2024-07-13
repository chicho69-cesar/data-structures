package org.chicho69.cesar.trees_sorted;

import java.util.Scanner;

public class TestTreeSorted {
    private final SortedTree tree;
    private final Scanner reader = new Scanner(System.in);

    public TestTreeSorted() {
        tree = new SortedTree();
    }

    public void menu() {
        int option, data;

        do {
            System.out.println("\n-----MENU PRINCIPAL-----");
            System.out.println("1.- Insertar un nuevo nodo");
            System.out.println("2.- Mostrar el arbol");
            System.out.println("3.- Buscar un elemento en el arbol");
            System.out.println("4.- Recorrer el arbol en PreOrden");
            System.out.println("5.- Recorrer el arbol en InOrden");
            System.out.println("6.- Recorrer el arbol en PostOrden");
            System.out.println("7.- Eliminar un nodo del arbol");
            System.out.println("8.- Salir");
            System.out.print("Escoge una opcion: ");
            option = reader.nextInt();

            switch (option) {
                case 1:
                    System.out.print("\nEscribe el dato que deseas insertar: ");
                    data = reader.nextInt();
                    tree.insert(data);

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
                    System.out.print("\nEscribe el dato que buscas: ");
                    data = reader.nextInt();

                    if (tree.search(tree.getRoot(), data)) {
                        System.out.println("\nEl elemento " + data + " si se encuentra en el arbol :)");
                    } else {
                        System.err.println("\nEl elemento " + data + " no se encuentra en el arbol :(");
                    }

                    break;
                case 4:
                    if (tree.isEmpty()) {
                        System.err.println("\nEl arbol actualmente esta vacio :(");
                    } else {
                        System.out.println("\n" + tree.preOrden(tree.getRoot()));
                    }

                    break;
                case 5:
                    if (tree.isEmpty()) {
                        System.err.println("\nEl arbol actualmente esta vacio :(");
                    } else {
                        System.out.println("\n" + tree.inOrden(tree.getRoot()));
                    }

                    break;
                case 6:
                    if (tree.isEmpty()) {
                        System.err.println("\nEl arbol actualmente esta vacio :(");
                    } else {
                        System.out.println("\n" + tree.postOrden(tree.getRoot()));
                    }

                    break;
                case 7:
                    if (tree.isEmpty()) {
                        System.err.println("\nEl arbol no tiene elementos para eliminar :(");
                    } else {
                        System.out.print("\nEscribe el valor del nodo que deseas eliminar: ");
                        data = reader.nextInt();

                        if (tree.search(tree.getRoot(), data)) {
                            tree.delete(tree.getRoot(), data);
                            System.out.println("El nodo con el valor " + data + " se elimino con exito :)");
                        } else {
                            System.err.println("El valor digitado no se encuentra en el arbol :(");
                        }
                    }

                    break;
                case 8: break;
                default:
                    System.err.println("\nError escoge una opcion valida");
                    break;
            }
        } while (option != 8);
    }
}
