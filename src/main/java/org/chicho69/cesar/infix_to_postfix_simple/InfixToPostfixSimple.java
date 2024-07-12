package org.chicho69.cesar.infix_to_postfix_simple;

import javax.swing.*;
import java.util.Stack;

public class InfixToPostfixSimple {
    public static void run() {
        Stack<Character> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();
        String expression;
        char element;
        int iterator = 0;

        expression = JOptionPane.showInputDialog("Ingresa la cadena Infija: ");

        while (iterator < expression.length()) {
            if (!isOperador(expression.charAt(iterator))) {
                postfix.append(expression.charAt(iterator));
            } else {
                while (!stack.isEmpty() && precedence(stack.peek(), expression.charAt(iterator))) {
                    element = stack.pop();
                    postfix.append(element);
                }

                stack.push(expression.charAt(iterator));
            }

            iterator++;
        }

        while (!stack.isEmpty()) {
            element = stack.pop();
            postfix.append(element);
        }

        JOptionPane.showMessageDialog(null, "Cadena postfija:  " + postfix.toString());
    }

    public static boolean isOperador(char character) {
        return switch (character) {
            case '+', '-', '*', '/', '^' -> true;
            default -> false;
        };
    }

    public static boolean precedence(char operator1, char operator2) {
        boolean result = operator1 == '^';

        if ((operator1 == '*' || operator1 == '/') && (operator2 != '^')) result = true;
        if ((operator1 == '+' || operator1 == '-') && (operator2 == '+' || operator2 == '-')) result = true;

        return result;
    }
}
