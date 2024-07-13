package org.chicho69.cesar.simple_stacks;

import java.util.Scanner;

public class TestSimpleStack {
    private final SimpleStack<Character> stack;
    private final Scanner reader;
    private final Scanner readerForChar;

    public TestSimpleStack() {
        reader = new Scanner(System.in);
        readerForChar = new Scanner(System.in);
        stack = new SimpleStack<>(100);
    }

    public void menu() {
        int option;

        do{
            System.out.println("\n-----MENU-----");
            System.out.println("1.- Insertar elemento en la pila");
            System.out.println("2.- Borrar elemento de la pila");
            System.out.println("3.- Mostrar la pila");
            System.out.println("4.- Salir");
            System.out.print("Escoge una opcion: ");
            option = reader.nextInt();

            switch (option) {
                case 1:
                    System.out.print("\nEscribe el elemento que deseas insertar: ");
                    char character = readerForChar.next().charAt(0);

                    stack.insert(character);

                    break;
                case 2:
                    if (!stack.isEmpty()) {
                        System.out.println("\nEl elemento eliminado es: " + stack.delete());
                    } else {
                        System.out.println("\nNo es posible borrar elementos. La pila esta vacia");
                    }

                    break;
                case 3:
                    if (!stack.isEmpty()) {
                        stack.printStack();
                    } else {
                        System.out.println("\nLa pila esta vacia");
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
