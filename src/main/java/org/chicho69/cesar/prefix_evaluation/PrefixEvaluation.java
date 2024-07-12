package org.chicho69.cesar.prefix_evaluation;

import javax.swing.*;
import java.util.Stack;

public class PrefixEvaluation {
    public static void run() {
        Stack<String> stack = new Stack<>();
        String expression, currentOperator;
        int operator1, operator2, value = 0, iterator = 0;

        expression = JOptionPane.showInputDialog("Escribe la expresion para resolver: ");

        while (iterator < expression.length()) {
            if (isOperador(expression.charAt(iterator))) {
                stack.push(String.valueOf(expression.charAt(iterator)));
            } else {
                if (isOperador(stack.peek().charAt(0))) {
                    stack.push(String.valueOf(expression.charAt(iterator)));
                } else {
                    stack.push(String.valueOf(expression.charAt(iterator)));

                    while (stack.size() > 1 && !isOperador(stack.get(stack.size() - 2).charAt(0))) {
                        operator2 = Integer.parseInt(stack.pop());
                        operator1 = Integer.parseInt(stack.pop());
                        currentOperator = stack.pop();
                        value = doOperation(operator1, operator2, currentOperator.charAt(0));
                        stack.push(String.valueOf(value));
                    }
                }
            }

            iterator++;
        }

        JOptionPane.showMessageDialog(null, "El resultado es: " + stack.pop(), "Resultado", JOptionPane.PLAIN_MESSAGE);
    }

    public static boolean isOperador(char character) {
        return switch (character) {
            case '+', '-', '*', '/', '^' -> true;
            default -> false;
        };
    }

    public static int doOperation(int operator1, int operator2, char character) {
        return switch (character) {
            case '+' -> operator1 + operator2;
            case '-' -> operator1 - operator2;
            case '*' -> operator1 * operator2;
            case '/' -> operator1 / operator2;
            case '^' -> (int) Math.pow(operator1, operator2);
            default -> 0;
        };
    }
}
