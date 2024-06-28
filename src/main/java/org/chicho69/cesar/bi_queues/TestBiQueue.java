package org.chicho69.cesar.bi_queues;

import java.util.Scanner;

public class TestBiQueue {
    static Scanner scanner = new Scanner(System.in);
    static Scanner scannerChars = new Scanner(System.in);
    public BIQueue<Character> biQueue;

    public TestBiQueue() {
        biQueue = new BIQueue<>(5);
    }

    public void menu() {
        int option;

        do {
            System.out.println("\n-----MENU-----");
            System.out.println("1.- Insertar elemento en la cola");
            System.out.println("2.- Borrar elemento de la cola");
            System.out.println("3.- Mostrar la cola");
            System.out.println("4.- Salir");
            System.out.print("Escoge una opcion: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    if (!biQueue.isFull()) {
                        insert();
                    } else {
                        System.err.println("\nNo es posible insertar elementos. La bicola esta llena");
                    }

                    break;
                case 2:
                    if (!biQueue.isEmpty()) {
                        delete();
                    } else {
                        System.err.println("\nNo es posible borrar elementos. La cola esta vacia");
                    }

                    break;
                case 3:
                    if (!biQueue.isEmpty()) {
                        biQueue.printQueue();
                    } else {
                        System.err.println("\nLa bicola esta vacia");
                    }

                    break;
                case 4: break;
                default:
                    System.err.println("\nError. Escoge una opcion valida");
                    break;
            }
        } while (option != 4);
    }

    public void insert() {
        System.out.println("\n-----Opciones para insertar-----");
        System.out.println("1.- Insertar al frente");
        System.out.println("2.- Insertar al final");
        System.out.print("Escoge una opcion: ");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                System.out.print("\nEscribe el elemento que deseas insertar: ");
                char character1 = scannerChars.next().charAt(0);

                biQueue.insertInLeft(character1);

                break;
            case 2:
                System.out.print("\nEscribe el elemento que deseas insertar: ");
                char character2 = scannerChars.next().charAt(0);

                biQueue.insertInRight(character2);

                break;
            default:
                System.err.println("\nError. Escogiste una opcion invalida");
                break;
        }
    }

    public void delete() {
        System.out.println("\n-----Opciones para borrar-----");
        System.out.println("1.- Borrar al frente");
        System.out.println("2.- Borrar al final");
        System.out.print("Escoge una opcion: ");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                System.out.println("\nEl elemento eliminado es: " + biQueue.deleteLeft());
                break;
            case 2:
                System.out.println("\nEl elemento eliminado es: " + biQueue.deleteRight());
                break;
            default:
                System.err.println("\nError. Escogiste una opcion invalida");
                break;
        }
    }
}
