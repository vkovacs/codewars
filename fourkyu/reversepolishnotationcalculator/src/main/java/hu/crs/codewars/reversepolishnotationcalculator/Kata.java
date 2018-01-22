package hu.crs.codewars.reversepolishnotationcalculator;

import java.util.Deque;
import java.util.LinkedList;

public class Kata {
    public double evaluate(String expr) {
        if ("".equals(expr)) {
            return 0;
        }
        return calculate(parse(expr));
    }

    private String[] parse(String expr) {
        return expr.split(" ");
    }

    private Double calculate(String[] parsedExpr) {
        Deque<Double> stack = new LinkedList<>();
        for (String element : parsedExpr) {
            final char c = element.charAt(0);
            if (Character.isDigit(c)) {
                stack.push(Double.parseDouble(element));
            } else {
                Double operand1 = stack.pop();
                Double operand0 = stack.pop();
                final Double result = operate(operand0, operand1, c);
                stack.push(result);
            }
        }
        return stack.pop();
    }

    private Double operate(Double operand0, Double operand1, char operator) {
        switch (operator) {
            case '+':
                return operand0 + operand1;
            case '-':
                return operand0 - operand1;
            case '*':
                return operand0 * operand1;
            case '/':
                return operand0 / operand1;
            default:
                throw new IllegalArgumentException("Invalid character in input");
        }
    }
}
