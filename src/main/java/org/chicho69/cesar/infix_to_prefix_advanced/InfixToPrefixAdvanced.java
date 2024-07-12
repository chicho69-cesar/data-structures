package org.chicho69.cesar.infix_to_prefix_advanced;

import javax.swing.*;
import java.util.Stack;

public class InfixToPrefixAdvanced {
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

                    if (expression.charAt(iterator) != '(') {
                        operatorsStack.push(expression.charAt(iterator));
                    } else {
                        operatorsStack.pop();
                    }
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

        JOptionPane.showMessageDialog(null, "Cadena prefija:  " + prefix);
    }

    public static boolean isOperadorBasic(char character) {
        return switch (character) {
            case '+', '-', '*', '/', '^' -> true;
            default -> false;
        };
    }

    public static boolean isOperador(char character) {
        boolean result = isOperadorBasic(character);

        if (character == '(' || character == ')') {
            result = true;
        }

        return result;
    }

    public static boolean precedence(char operator1, char operator2) {
        boolean result = isOperadorBasic(operator1) && operator2 == '(';

        if (operator1 == '^' && (isOperadorBasic(operator2) && operator2 != '^')) result = true;
        if ((operator1 == '*' || operator1 == '/') && (operator2 == '+' || operator2 == '-')) result = true;

        return result;
    }
}
