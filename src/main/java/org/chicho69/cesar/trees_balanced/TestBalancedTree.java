package org.chicho69.cesar.trees_balanced;

import java.util.Scanner;

public class TestBalancedTree {
    private final BalancedTree tree;
    private final Scanner reader = new Scanner(System.in);

    public TestBalancedTree() {
        tree = new BalancedTree();
    }

    public void menu() {
        int option, data;

        do {
            System.out.println("\n-----Menu principal-----");
            System.out.println("1.- Insertar un nodo al arbol AVL");
            System.out.println("2.- Mostrar el arbol AVL completo");
            System.out.println("3.- Buscar un nodo en el arbol");
            System.out.println("4.- Recorrido del arbol en PreOrden");
            System.out.println("5.- Recorrido del arbol en InOrden");
            System.out.println("6.- Recorrido del arbol en PostOrden");
            System.out.println("7.- Eliminar un nodo del arbol AVL");
            System.out.println("8.- Salir");
            System.out.print("Escoge una opcion: ");
            option = reader.nextInt();

            switch (option) {
                case 1:
                    System.out.print("\nEscribe el dato que deseas agregar: ");
                    data = reader.nextInt();

                    if (tree.insert(data)) {
                        System.out.println("Nodo agregado con exito :)");
                    } else {
                        System.err.println("Error. Nodo duplicado");
                    }

                    break;
                case 2:
                    if (tree.isEmpty()) {
                        System.err.println("\nError. El arbol esta vacio :(");
                    } else {
                        System.out.println("\nEl arbol balanceado es el siguiente: \n");
                        tree.showTree(tree.getRoot(), 0);
                    }

                    break;
                case 3:
                    if (tree.isEmpty()) {
                        System.err.println("\nEl arbol actualmente esta vacio :(");
                    } else {
                        System.out.print("\nEscribe el dato que buscas: ");
                        data = reader.nextInt();

                        if (tree.search(tree.getRoot(), data)) {
                            System.out.println("El elemento " + data + " si se encuentra en el arbol :)");
                        } else {
                            System.err.println("El elemento " + data + " no se encuentra en el arbol :(");
                        }
                    }

                    break;
                case 4:
                    if (tree.isEmpty()) {
                        System.err.println("\nEl arbol actualmente esta vacio :(");
                    } else {
                        System.out.println("\nEl recorrido en PreOrden es: " + tree.preOrden(tree.getRoot()));
                    }

                    break;
                case 5:
                    if (tree.isEmpty()) {
                        System.err.println("\nEl arbol actualmente esta vacio :(");
                    } else {
                        System.out.println("\nEl recorrido en inOrden es: " + tree.inOrden(tree.getRoot()));
                    }

                    break;
                case 6:
                    if (tree.isEmpty()) {
                        System.err.println("\nEl arbol actualmente esta vacio :(");
                    } else {
                        System.out.println("\nEl recorrido en PostOrden es: " + tree.postOrden(tree.getRoot()));
                    }

                    break;
                case 7:
                    if (tree.isEmpty()) {
                        System.err.println("\nEl arbol no tiene elementos para eliminar :(");
                    } else {
                        System.out.print("\nEscribe el valor del nodo que deseas eliminar: ");
                        data = reader.nextInt();

                        if (tree.search(tree.getRoot(), data)) {
                            tree.delete(data);
                            System.out.println("El nodo con el valor " + data + " se elimino con exito :)");
                        } else {
                            System.err.println("El valor digitado no se encuentra en el arbol :(");
                        }
                    }

                    break;
                case 8: break;
                default:
                    System.err.println("\nError escoge una opcion valida :(");
                    break;
            }
        } while (option != 8);
    }
}
