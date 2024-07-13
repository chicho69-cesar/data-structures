package org.chicho69.cesar.simple_queues;

import java.util.Scanner;

public class TestSimpleQueue {
    private final SimpleQueue<Character> queue;
    private final Scanner reader;
    private final Scanner readerForChar;

    public TestSimpleQueue() {
        reader = new Scanner(System.in);
        readerForChar = new Scanner(System.in);
        queue = new SimpleQueue<>(100);
    }

    public void menu() {
        int option;

        do{
            System.out.println("\n-----MENU-----");
            System.out.println("1.- Insertar elemento en la cola");
            System.out.println("2.- Borrar elemento de la cola");
            System.out.println("3.- Mostrar la cola");
            System.out.println("4.- Salir");
            System.out.print("Escoge una opcion: ");
            option = reader.nextInt();

            switch (option) {
                case 1:
                    System.out.print("\nEscribe el elemento que deseas insertar: ");
                    char character = readerForChar.next().charAt(0);

                    queue.insert(character);

                    break;
                case 2:
                    if (!queue.isEmpty()) {
                        System.out.println("\nEl elemento eliminado es: " + queue.delete());
                    } else {
                        System.out.println("\nNo es posible borrar elementos. La cola esta vacia");
                    }

                    break;
                case 3:
                    if (!queue.isEmpty()) {
                        queue.printQueue();
                    } else {
                        System.out.println("\nLa cola esta vacia");
                    }

                    break;
                case 4: break;
                default:
                    System.err.println("\nError. Escoge una opcion valida");
                    break;
            }
        } while (option != 4);
    }
}
