package hu.crs.codewars;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Kata {
    private static String FUNCTION_GROUPS_PATTERN = "(\\[[a-zA-Z ]*\\])(.*)";
    public List<String> compile(String prog) {
        return pass3(pass2(pass1(prog)));
    }
    private static Set<String> OPERATORS = new HashSet<>();

    static {
        OPERATORS.add("+");
        OPERATORS.add("-");
        OPERATORS.add("*");
        OPERATORS.add("/");
    }

    /**
     * Returns an un-optimized AST
     */
    public Ast pass1(String function) {
        String functionArguments = extractFunctionArguments(function);
        Map<String, Integer> functionArgumentsMap = calculateFunctionArgumentsMap(functionArguments);

        String functionBody = extractFunctionBody(function);

        if (functionBody == null) {
            return null;
        }

        String prefixedFunctionBody = toPrefixNotation(functionBody);
        List<String> prefixedFunctionBodyTokens = new ArrayList<>(tokenize(prefixedFunctionBody));

        return buildAst(prefixedFunctionBodyTokens, functionArgumentsMap);
    }

    private Ast buildAst(List<String> tokens, Map<String, Integer> functionArgumentsMap) {
        Deque<Ast> stack = new LinkedList<>();
        String currentToken;
        for (int i = tokens.size() - 1; i >= 0; i--) {
            currentToken = tokens.get(i);
            if (isNumber(currentToken)) {
                stack.push(new UnOp(UnOp.IMMUTABLE, Integer.valueOf(currentToken)));
            }
            else if (isArgument(currentToken, functionArgumentsMap.keySet())) {
                stack.push(new UnOp(UnOp.ARGUMENT, functionArgumentsMap.get(currentToken)));
            } else if (isBinop(currentToken)) {
                //binary operator
                Ast a = stack.removeFirst();
                Ast b = stack.removeFirst();
                stack.push(new BinOp(String.valueOf(currentToken), a, b));
            } else {
                throw new IllegalArgumentException();
            }
        }
        return stack.removeFirst();
    }

    private boolean isBinop(String op) {
        return OPERATORS.contains(op);
    }

    private boolean isArgument(String currentToken, Set<String> arguments) {
        return arguments.contains(currentToken);
    }

    private boolean isNumber(String character) {
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(character);
        return matcher.matches();
    }

    private Map<String, Integer> calculateFunctionArgumentsMap(String functionArguments) {
        Map<String, Integer> functionArgumentsMap = new HashMap<>();
        int order = 0;
        for (String token : tokenize(functionArguments)) {
            if (!token.equals("[") && !token.equals("]")) {
                functionArgumentsMap.put(token, order);
                order++;
            }
        }
        return functionArgumentsMap;
    }

    private String extractFunctionArguments(String function) {
        Pattern pattern = Pattern.compile(FUNCTION_GROUPS_PATTERN);
        Matcher matcher = pattern.matcher(function);
        if (matcher.matches()) {
            if (!matcher.group(1).equals("")) {
                return matcher.group(1);
            }
        }
        throw new IllegalArgumentException();
    }

    private String extractFunctionBody(String function) {
        Pattern pattern = Pattern.compile(FUNCTION_GROUPS_PATTERN);
        Matcher matcher = pattern.matcher(function);
        if (matcher.matches()) {
            if (!matcher.group(2).equals("")) {
                return matcher.group(2);
            }
            return null;
        }
        throw new IllegalArgumentException();
    }

    /**
     * Returns an AST with constant expressions reduced
     */
    public Ast pass2(Ast ast) {
        return simplify(ast);
    }

    private Ast simplify(Ast ast) {
        String op = ast.op();
        if (isBinop(op)) {
            BinOp binOp = (BinOp) ast;
            Ast a = binOp.a();
            Ast b = binOp.b();

            if (!isBinop(a.op()) && !isBinop(b.op())) {
                UnOp aUnop = (UnOp) a;
                UnOp bUnop = (UnOp) b;

                int result = Integer.MIN_VALUE;
                if (aUnop.op().equals(UnOp.IMMUTABLE) && bUnop.op().equals(UnOp.IMMUTABLE)) {
                    switch (op) {
                        case "+" :
                            result = aUnop.value() + bUnop.value();break;
                        case "-" :
                            result = aUnop.value() - bUnop.value();break;
                        case "*" :
                            result = aUnop.value() * bUnop.value();break;
                        case "/" :
                            result = aUnop.value() / bUnop.value();break;
                    }
                    return new UnOp(UnOp.IMMUTABLE, result);
                } else {
                    return ast;
                }
            } else if (isBinop(a.op()) && !isBinop(b.op())) {
                ((BinOp) ast).setA(simplify(a));
                return ast;
            } else {
                ((BinOp) ast).setB(simplify(b));
                return ast;
            }
        } else {
            return ast;
        }
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
        return tokens;
    }

    public String toPrefixNotation(String infixExpression) {
        Deque<String> tokens = tokenize(infixExpression);

        Deque<String> stack = new LinkedList<>();
        Deque<String> prefixDeck = new LinkedList<>();
        while (tokens.size() > 0) {
            String currentToken = tokens.removeLast();

            if (!isOperand(currentToken) && !isParenthesis(currentToken)) {
                    prefixDeck.addFirst(currentToken);

            } else if (")".equals(currentToken)) {
                stack.push(currentToken);
            } else if ("(".equals(currentToken)) {
                String top = stack.removeFirst();
                while (!")".equals(top)) {
                    prefixDeck.addFirst(top);
                    top = stack.removeFirst();
                }
            } else {
                //current character is an operand
                String top = stack.peekFirst();
                while (!stack.isEmpty() && !")".equals(top) && firstHasHigherPrecedence(top, currentToken) > 0) {
                    prefixDeck.addFirst(top);
                    stack.removeFirst();
                    top = stack.peekFirst();
                }
                stack.push(currentToken);
            }
        }
        //leftovers in stack
        while (stack.size() > 0) {
            String top = stack.removeFirst();
            prefixDeck.addFirst(top);
        }
        return prefixDeck.stream()
                .collect(Collectors.joining(" "));
    }

    private static boolean isParenthesis(String currentString) {
        return "(".equals(currentString) || ")".equals(currentString);
    }

    private static boolean isOperand(String string) {
        return "+".equals(string) || "-".equals(string) || "/".equals(string) || "*".equals(string);
    }

    /**
     * Returns 0 if op0 precedence == op1 precedence
     * Returns 1 if op0 has higher precedence
     * Return -1 if op1 has higher precedence
     */
    private static int firstHasHigherPrecedence(String op0, String op1) {
        if (("+".equals(op0) || "-".equals(op0)) && ("+".equals(op1) || "-".equals(op1)) || ("*".equals(op0) || "/".equals(op0)) && ("*".equals(op1) || "/".equals(op1))) {
            return 0;
        } else if ((("+".equals(op0) || "-".equals(op0)) && ("/".equals(op1) || "*".equals(op1)))) {
            return -1;
        } else if (("/".equals(op0) || "*".equals(op0)) && ("+".equals(op1) || "-".equals(op1))) {
            return 1;
        } else {
            throw new IllegalStateException();
        }
    }
}
