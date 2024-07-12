package org.chicho69.cesar.infix_to_postfix_advanced;

import javax.swing.*;
import java.util.Stack;

public class InfixToPostfixAdvanced {
    public static void run() {
        Stack<Character> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();
        String expression;
        char element;
        int iterator = 0;

        expression = JOptionPane.showInputDialog("Ingresa la cadena Infija: ");

        while (iterator < expression.length()) {
            if (!isOperator(expression.charAt(iterator))) {
                postfix.append(expression.charAt(iterator));
            } else {
                while (!stack.isEmpty() && precedence(stack.peek(), expression.charAt(iterator))) {
                    element = stack.pop();
                    postfix.append(element);
                }

                if (expression.charAt(iterator) != ')') {
                    stack.push(expression.charAt(iterator));
                } else {
                    stack.pop();
                }
            }

            iterator++;
        }

        while (!stack.isEmpty()) {
            element = stack.pop();
            postfix.append(element);
        }

        JOptionPane.showMessageDialog(null, "Cadena postfija:  " + postfix);
    }

    public static boolean isOperadorBasic(char character) {
        return switch (character) {
            case '+', '-', '*', '/', '^' -> true;
            default -> false;
        };
    }

    public static boolean isOperator(char character) {
        boolean result = isOperadorBasic(character);

        if (character == '(' || character == ')') {
            result = true;
        }

        return result;
    }

    public static boolean precedence(char operator1, char operator2) {
        boolean result = isOperadorBasic(operator1) && operator2 == ')';

        if (operator1 == '^' && (isOperadorBasic(operator2))) result = true;
        if ((operator1 == '*' || operator1 == '/') && (isOperadorBasic(operator2) && operator2 != '^')) result = true;
        if ((operator1 == '+' || operator1 == '-') && (operator2 == '+' || operator2 == '-')) result = true;

        return result;
    }
}
