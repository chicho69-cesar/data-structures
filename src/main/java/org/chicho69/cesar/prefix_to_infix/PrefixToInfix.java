package org.chicho69.cesar.prefix_to_infix;

import java.util.Scanner;
import java.util.Stack;

public class PrefixToInfix {
    static Scanner reader = new Scanner(System.in);

    public static void run() {
        Stack<String> expressionStack = new Stack<>();
        Stack<Character> operatorsStack = new Stack<>();

        operatorsStack.push('^');
        expressionStack.push("+");

        String operator1, operator2, currentOperator, string, expression;
        int position = 0;

        System.out.print("Escribe la expresion prefija: ");
        expression = reader.nextLine();

        while (position < expression.length()) {
            if (isOperador(expression.charAt(position))) {
                expressionStack.push(String.valueOf(expression.charAt(position)));
                operatorsStack.push(expression.charAt(position));
            } else {
                expressionStack.push(String.valueOf(expression.charAt(position)));

                if (!isOperador(expressionStack.peek().charAt(0))) {
                    while (!(isOperador(expressionStack.get(expressionStack.size() - 2).charAt(0)))) {
                        operator2 = expressionStack.pop();
                        operator1 = expressionStack.pop();
                        currentOperator = expressionStack.pop();

                        string = operator1 + currentOperator + operator2;

                        if (!priority((operatorsStack.pop()), (operatorsStack.peek()))) {
                            string = "(" + string + ")";
                        }

                        expressionStack.push(string);
                    }
                }
            }

            position++;
        }

        String infix = expressionStack.pop();
        System.out.println("La expresion digitada en forma infija es: " + infix + "\n");
    }

    public static boolean isOperador(char character) {
        return switch (character) {
            case '+', '-', '*', '/', '^' -> true;
            default -> false;
        };
    }

    public static boolean priority(char operator1, char operator2) {
        boolean result = operator2 == '^';

        if ((operator1 == '*' || operator1 == '/') && (operator2 != '^')) result = true;
        if ((operator1 == '+' || operator1 == '-') && (operator2 == '+' || operator2 == '-')) result = true;

        return result;
    }
}
