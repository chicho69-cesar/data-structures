package org.chicho69.cesar.postfix_evaluation;

import javax.swing.*;
import java.util.Stack;

public class PostfixEvaluation {
    public static void run() {
        Stack<Integer> stack = new Stack<>();
        String expression;
        int position = 0, operator1, operator2, value = 0;

        expression = JOptionPane.showInputDialog("Escribe la expresion para resolver: ");

        while (position < expression.length()) {
            if (Character.isDigit(expression.charAt(position))) {
                stack.push(Integer.parseInt(String.valueOf(expression.charAt(position))));
            } else {
                if (isOperador(expression.charAt(position))) {
                    operator2 = stack.pop();
                    operator1 = stack.pop();
                    value = doOperation(operator1, operator2, expression.charAt(position));
                    stack.push(value);
                }
            }

            position++;
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
