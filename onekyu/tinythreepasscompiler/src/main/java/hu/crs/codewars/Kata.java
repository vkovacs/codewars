package hu.crs.codewars;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Kata {
    public List<String> compile(String prog) {
        return pass3(pass2(pass1(prog)));
    }

    /**
     * Returns an un-optimized AST
     */
    public Ast pass1(String prog) {
        Deque<String> tokens = tokenize(prog);
        return null;
    }

    /**
     * Returns an AST with constant expressions reduced
     */
    public Ast pass2(Ast ast) {
        return null;
    }

    /**
     * Returns assembly instructions
     */
    public List<String> pass3(Ast ast) {
        return null;
    }

    private static Deque<String> tokenize(String prog) {
        Deque<String> tokens = new LinkedList<>();
        Pattern pattern = Pattern.compile("[-+*/()\\[\\]]|[a-zA-Z]+|\\d+");
        Matcher m = pattern.matcher(prog);
        while (m.find()) {
            tokens.add(m.group());
        }
        tokens.add("$"); // end-of-stream
        return tokens;
    }

    public static String infoxToPrefix(String infixString) {
        Deque<Character> stack = new LinkedList<>();
        StringBuilder result = new StringBuilder();
        for (int i = infixString.length() - 1; i > - 1; i--) {
            char currentCharacter = infixString.charAt(i);
            if (!isOperand(currentCharacter) && !parenthesis(currentCharacter)) {
                result.insert(0, currentCharacter);
            } else if (currentCharacter == ')') {
                stack.push(currentCharacter);
            } else if (currentCharacter == '(') {
                Character top = stack.removeFirst();
                while (top != ')') {
                    result.insert(0, top);
                    top = stack.removeFirst();
                }
            } else {
                //current character is an operand
                while (!stack.isEmpty() && stack.peekFirst() != ')' && precedence(stack.peekFirst(), currentCharacter) < 0) {
                    result.insert(0, stack.removeFirst());
                }
                stack.push(currentCharacter);
            }
        }
        while (stack.size() > 0) {
            Character character = stack.removeFirst();
            result.insert(0, character);
        }
        return result.toString();
    }

    private static boolean parenthesis(char currentCharacter) {
        return currentCharacter == '(' || currentCharacter == ')';
    }

    private static boolean isOperand(char c) {
        return c == '+' || c == '-' || c == '/' || c == '*';
    }

    /**
     * Returns 0 if op0 precedence == op1 precedence
     * Returns -1 if op0 has higher precedence
     * Return 1 if op1 has higher precedence
     */
    private static int precedence(char op0, char op1) {
        if ((op0 == '+' || op0 == '-') && (op1 == '+' || op1 == '-') || (op0 == '*' || op0 == '/') && (op1 == '*' || op1 == '/')) {
            return 0;
        } else if (((op0 == '+' || op0 == '-') && (op1 == '/' || op1 == '*'))) {
            return 1;
        } else if ((op0 == '/' || op0 == '*') && (op1 == '+' || op1 == '-')) {
            return -1;
        } else {
            throw new IllegalStateException();
        }
    }
}