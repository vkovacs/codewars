package hu.crs.codewars.validbraces;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

public class Kata {
    private Deque<Character> stack = new LinkedList<>();

    private Set<Character> openers = new HashSet<>();
    private Set<Character> closers = new HashSet<>();

    {
        openers.add('(');
        openers.add('[');
        openers.add('{');

        closers.add(')');
        closers.add(']');
        closers.add('}');
    }

    public boolean isValid(String braces) {
        for (int i = 0; i < braces.length(); i++) {
            if (!processNextCharacter(braces.charAt(i))) {
                return false;
            }
        }

        return stack.isEmpty();
    }

    private boolean processNextCharacter(Character character) {
        if (openers.contains(character)) {
            stack.push(character);
            return true;
        } else if (closers.contains(character)) {
            Character topCharacter = stack.peek();
            if (isPairOf(topCharacter, character)) {
                stack.pop();
                return true;
            } else {
                return false;
            }
        }

        throw new IllegalArgumentException("Not a brace character!");
    }

    private boolean isPairOf(Character a, Character b) {
        return (a == '(' && b == ')') ||
                (a == '[' && b == ']') ||
                (a == '{' && b == '}');

    }
}
