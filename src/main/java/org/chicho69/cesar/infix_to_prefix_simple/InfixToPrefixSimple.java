package org.chicho69.cesar.infix_to_prefix_simple;

import javax.swing.*;
import java.util.Stack;

public class InfixToPrefixSimple {
    public static void run() {
        Stack<Character> operatorsStack = new Stack<>();
        Stack<Character> stack = new Stack<>();
        StringBuilder prefix = new StringBuilder();
        String expression;
        char element;

        expression = JOptionPane.showInputDialog("Ingresa la cadena Infija: ");

        int iterator = expression.length() - 1;

        while (iterator >= 0) {
            if (!isOperador(expression.charAt(iterator))) {
                stack.push(expression.charAt(iterator));
            } else {
                if (operatorsStack.isEmpty()) {
                    operatorsStack.push(expression.charAt(iterator));
                } else {
                    while (!operatorsStack.isEmpty() && precedence(operatorsStack.peek(), expression.charAt(iterator))) {
                        element = operatorsStack.pop();
                        stack.push(element);
                    }

                    operatorsStack.push(expression.charAt(iterator));
                }
            }

            iterator--;
        }

        while (!operatorsStack.isEmpty()) {
            element = operatorsStack.pop();
            stack.push(element);
        }

        while (!stack.isEmpty()) {
            prefix.append(stack.pop());
        }

        JOptionPane.showMessageDialog(null, "Cadena prefija:  " + prefix.toString());
    }

    public static boolean isOperador(char character) {
        return switch (character) {
            case '+', '-', '*', '/', '^' -> true;
            default -> false;
        };
    }

    public static boolean precedence(char operator1, char operator2) {
        boolean result = operator1 == '^' && operator2 != '^';

        if ((operator1 == '*' || operator1 == '/') && (operator2 == '+' || operator2 == '-')) result = true;

        return result;
    }
}
