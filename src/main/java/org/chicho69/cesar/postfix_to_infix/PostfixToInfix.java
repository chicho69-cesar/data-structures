package org.chicho69.cesar.postfix_to_infix;

import java.util.Scanner;
import java.util.Stack;

public class PostfixToInfix {
    static Scanner reader = new Scanner(System.in);

    public static void run() {
        Stack<String> expressionStack = new Stack<>();
        Stack<Character> operatorsStack = new Stack<>();

        String operatorInStack1, operatorInStack2, string, expression;
        char operator1, operator2;
        int position = 0;

        System.out.println("Escribe la expresión postfija: ");
        expression = reader.nextLine();

        while (position < expression.length()) {
            if (!(isOperador(expression.charAt(position)))) {
                expressionStack.push(String.valueOf(expression.charAt(position)));
            } else {
                if (operatorsStack.isEmpty()) {
                    operatorsStack.push(expression.charAt(position));

                    operatorInStack2 = expressionStack.pop();
                    operatorInStack1 = expressionStack.pop();

                    string = operatorInStack1 + String.valueOf(expression.charAt(position)) + operatorInStack2;

                    expressionStack.push(string);
                } else {
                    operatorsStack.push(expression.charAt(position));

                    operator1 = operatorsStack.getLast();
                    operator2 = operatorsStack.get(operatorsStack.size() - 2);

                    operatorInStack2 = expressionStack.pop();
                    operatorInStack1 = expressionStack.pop();

                    if ((priority(operator1, operator2)) && (operatorInStack1.length() > 1 || operatorInStack2.length() > 1)) {
                        if (operatorInStack1.length() > 1) operatorInStack1 = "(" + operatorInStack1 + ")";
                        if (operatorInStack2.length() > 1) operatorInStack2 = "(" + operatorInStack2 + ")";
                    }

                    string = operatorInStack1 + String.valueOf(expression.charAt(position)) + operatorInStack2;
                    expressionStack.push(string);
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
        boolean result = operator1 == '^' && operator2 != '^';

        if ((operator1 == '*' || operator1 == '/') && (operator2 == '*' || operator2 == '/')) result = true;
        if ((operator1 == '*' || operator1 == '/') && (operator2 == '+' || operator2 == '-')) result = true;
        if ((operator1 == '+' || operator1 == '-') && (operator2 == '+' || operator2 == '-')) result = true;

        return result;
    }
}
