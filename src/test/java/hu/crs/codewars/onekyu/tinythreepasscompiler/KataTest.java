package hu.crs.codewars.onekyu.tinythreepasscompiler;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class KataTest {

    @Test
    public void testSimpleProg() {
        String program = "[ x y z ] ( 2*3*x + 5*y - 3*z ) / (1 + 3 + 2*2)";
        Kata compiler = new Kata();

        // {'op':'/','a':{'op':'-','a':{'op':'+','a':{'op':'*','a':{'op':'*','a':{'op':'imm','n':2},'b':{'op':'imm','n':3}},'b':{'op':'arg','n':0}},'b':{'op':'*','a':{'op':'imm','n':5},'b':{'op':'arg','n':1}}},'b':{'op':'*','a':{'op':'imm','n':3},'b':{'op':'arg','n':2}}},'b':{'op':'+','a':{'op':'+','a':{'op':'imm','n':1},'b':{'op':'imm','n':3}},'b':{'op':'*','a':{'op':'imm','n':2},'b':{'op':'imm','n':2}}}}
        Ast t1 = new BinOp("/", new BinOp("-", new BinOp("+", new BinOp("*", new BinOp("*", new UnOp("imm", 2), new UnOp("imm", 3)), new UnOp("arg", 0)), new BinOp("*", new UnOp("imm", 5), new UnOp("arg", 1))), new BinOp("*", new UnOp("imm", 3), new UnOp("arg", 2))), new BinOp("+", new BinOp("+", new UnOp("imm", 1), new UnOp("imm", 3)), new BinOp("*", new UnOp("imm", 2), new UnOp("imm", 2))));
        Ast p1 = compiler.pass1(program);
        assertEquals(t1, p1);

        // {'op':'/','a':{'op':'-','a':{'op':'+','a':{'op':'*','a':{'op':'imm','n':6},'b':{'op':'arg','n':0}},'b':{'op':'*','a':{'op':'imm','n':5},'b':{'op':'arg','n':1}}},'b':{'op':'*','a':{'op':'imm','n':3},'b':{'op':'arg','n':2}}},'b':{'op':'imm','n':8}}
        Ast t2 = new BinOp("/", new BinOp("-", new BinOp("+", new BinOp("*", new UnOp("imm", 6), new UnOp("arg", 0)), new BinOp("*", new UnOp("imm", 5), new UnOp("arg", 1))), new BinOp("*", new UnOp("imm", 3), new UnOp("arg", 2))), new UnOp("imm", 8));
        Ast p2 = compiler.pass2(p1);
        assertEquals(t2, p2);

        List<String> p3 = compiler.pass3(p2);
        assertEquals(3, Simulator.simulate(p3, 4, 0, 0));
        assertEquals(8, Simulator.simulate(p3, 4, 8, 0));
        assertEquals(2, Simulator.simulate(p3, 4, 8, 16));
    }

    @Test
    public void testInfixToPrefixJustEqualPrecedence() {
        assertEquals("- + A B C", new Kata().toPrefixNotation("A + B - C"));
    }

    @Test
    public void testInfixToPrefixHasHigherPrecedence() {
        assertEquals("+ A / B 2", new Kata().toPrefixNotation("A + B / 2"));

    }

    @Test
    public void testInfixToPrefixHasHigherPrecedenceAndMultipleLower() {
        assertEquals("- + A / B 2 3", new Kata().toPrefixNotation("A + B / 2 - 3"));
    }

    @Test
    public void testInfixToPrefixHasMultipleHigherPrecedence() {
        assertEquals("- / * A B 2 3", new Kata().toPrefixNotation("A * B / 2 - 3"));
    }

    @Test
    public void testInfixToPrefixHandleParenthesis() {
        assertEquals("+ A / B - 2 3", new Kata().toPrefixNotation("A + B / ( 2 - 3)"));
    }

    @Test
    public void testInfixToPrefixNestedParenthesises() {
        assertEquals("- * / 15 - 7 + 1 1 3 + 2 + 1 1", new Kata().toPrefixNotation("((15 / (7 - (1 + 1))) * 3) - (2 + (1 + 1))"));
    }

    @Test
    public void testPass1EmptyInput() {
        assertNull(new Kata().pass1("[]"));
    }

    @Test
    public void testUnaryOperatorWithOneImmutableValue() {
        UnOp expectedAst = new UnOp(Kata.IMMEDIATE, 1);
        assertEquals(expectedAst, new Kata().pass1("[] 1"));
    }

    @Test
    public void testUnaryOperatorWithOneArgumentReturnsConstant() {
        UnOp expectedAst = new UnOp(Kata.IMMEDIATE, 1);
        assertEquals(expectedAst, new Kata().pass1("[x] 1"));
    }

    @Test
    public void testUnaryOperatorWithIncorrectSyntax() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            UnOp expectedAst = new UnOp(Kata.IMMEDIATE, 0);
            new Kata().pass1("0");
        });
    }

    @Test
    public void testUnaryOperatorWithOneArgumentReturnsSameArgument() {
        UnOp expectedAst = new UnOp(Kata.ARGUMENT, 0);
        assertEquals(expectedAst, new Kata().pass1("[x] x"));
    }

    @Test
    public void testUnaryOperatorWithOneIllegalArgument() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Kata().pass1("[x] y"));
    }

    @Test
    public void testBinaryOperatorReturnsConstant() {
        UnOp expectedA = new UnOp(Kata.IMMEDIATE, 1);
        UnOp expectedB = new UnOp(Kata.IMMEDIATE, 2);
        BinOp expectedAst = new BinOp("+", expectedA, expectedB);
        assertEquals(expectedAst, new Kata().pass1("[x y] 1 + 2"));
    }

    @Test
    public void testBinaryOperatorReturnsArguments() {
        UnOp expectedA = new UnOp(Kata.ARGUMENT, 0);
        UnOp expectedB = new UnOp(Kata.ARGUMENT, 1);
        BinOp expectedAst = new BinOp("+", expectedA, expectedB);
        assertEquals(expectedAst, new Kata().pass1("[x y] x + y"));
    }

    @Test
    public void testBinaryOperatorComplexFunctionBody() {
        BinOp expectedAst = new BinOp("/", new BinOp("+", new UnOp(Kata.ARGUMENT, 0), new UnOp(Kata.ARGUMENT, 1)), new UnOp(Kata.IMMEDIATE, 2));
        assertEquals(expectedAst, new Kata().pass1("[ x y ] ( x + y ) / 2"));
    }

    @Test
    public void testASTSimplification() {
        BinOp expectedAst = new BinOp("+", new UnOp("arg", 0), new UnOp(Kata.IMMEDIATE, 10));
        Kata kata = new Kata();
        assertEquals(expectedAst, kata.pass2(kata.pass1("[ x ] x + 2 * 5")));
    }

    @Test
    public void testUnaryOperatorWithOneImmutableValueSimplified() {
        UnOp expectedAst = new UnOp(Kata.IMMEDIATE, 1);
        Kata kata = new Kata();
        assertEquals(expectedAst, kata.pass2(kata.pass1("[] 1")));
    }

    @Test
    public void testUnaryOperatorWithOneArgumentReturnsConstantSimplified() {
        UnOp expectedAst = new UnOp(Kata.IMMEDIATE, 1);
        Kata kata = new Kata();
        assertEquals(expectedAst, kata.pass2(kata.pass1("[x] 1")));
    }

    @Test
    public void testUnaryOperatorWithOneArgumentReturnsSameArgumentSimplified() {
        UnOp expectedAst = new UnOp(Kata.ARGUMENT, 0);
        Kata kata = new Kata();
        assertEquals(expectedAst, kata.pass2(kata.pass1("[x] x")));
    }

    @Test
    public void testUnaryOperatorWithOneIllegalArgumentSimplified() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Kata kata = new Kata();
            kata.pass2(kata.pass1("[x] y"));
        });
    }

    @Test
    public void testBinaryOperatorReturnsConstantSimplified() {
        UnOp expectedAst = new UnOp(Kata.IMMEDIATE, 3);
        Kata kata = new Kata();
        assertEquals(expectedAst, kata.pass2(kata.pass1("[x y] 1 + 2")));
    }

    @Test
    public void testBinaryOperatorReturnsArgumentsSimplified() {
        UnOp expectedA = new UnOp(Kata.ARGUMENT, 0);
        UnOp expectedB = new UnOp(Kata.ARGUMENT, 1);
        BinOp expectedAst = new BinOp("+", expectedA, expectedB);
        Kata kata = new Kata();
        assertEquals(expectedAst, kata.pass2(kata.pass1("[x y] x + y")));
    }

    @Test
    public void testBinaryOperatorComplexFunctionBodySimplified() {
        BinOp expectedAst = new BinOp("/", new BinOp("+", new UnOp(Kata.ARGUMENT, 0), new UnOp(Kata.ARGUMENT, 1)), new UnOp(Kata.IMMEDIATE, 2));
        Kata kata = new Kata();
        assertEquals(expectedAst, kata.pass2(kata.pass1("[ x y ] ( x + y ) / 2")));
    }

    @Test
    public void testUnaryOperatorWithOneImmutableValueExecuted() {
        String function = "[] 1";
        Kata kata = new Kata();
        List<String> asm = kata.pass3(kata.pass2(kata.pass1(function)));
        assertEquals(1, Simulator.simulate(asm));
    }

    @Test
    public void testUnaryOperatorWithOneArgumentReturnsSameArgumentExecuted() {
        String function = "[x] x";
        Kata kata = new Kata();
        List<String> asm = kata.pass3(kata.pass2(kata.pass1(function)));
        assertEquals(2, Simulator.simulate(asm, 2));
    }

    @Test
    public void testBinaryOperatorReturnsConstantExecuted() {
        String function = "[] 1 + 2";
        Kata kata = new Kata();
        List<String> asm = kata.pass3(kata.pass2(kata.pass1(function)));
        assertEquals(3, Simulator.simulate(asm));
    }

    @Test
    public void testBinaryOperatorReturnsArgumentsExecuted() {
        String function = "[x y] x + y";
        Kata kata = new Kata();
        List<String> asm = kata.pass3(kata.pass2(kata.pass1(function)));
        assertEquals(7, Simulator.simulate(asm, 3, 4));
    }

    @Test
    public void testBinaryOperatorReturnsOneIntermediatePlusOneArgumentsExecuted() {
        String function = "[x] x + 2";
        Kata kata = new Kata();
        List<String> asm = kata.pass3(kata.pass2(kata.pass1(function)));
        assertEquals(5, Simulator.simulate(asm, 3));
    }

    @Test
    public void testBinaryOperatorReturnsOneArgumentMinusOneIntermediateExecuted() {
        String function = "[x] x - 2";
        Kata kata = new Kata();
        List<String> asm = kata.pass3(kata.pass2(kata.pass1(function)));
        assertEquals(1, Simulator.simulate(asm, 3));
    }

    @Test
    public void testBinaryOperatorReturnsOneIntermediateMinusOneArgumentsExecuted() {
        String function = "[x] 2 - x";
        Kata kata = new Kata();
        List<String> asm = kata.pass3(kata.pass2(kata.pass1(function)));
        assertEquals(-1, Simulator.simulate(asm, 3));
    }

    @Test
    public void testBinaryOperatorComplexFunctionBodyExecuted() {
        String function = "[ x y ] ( x + y ) / 2";
        Kata kata = new Kata();
        List<String> asm = kata.pass3(kata.pass2(kata.pass1(function)));
        assertEquals(5, Simulator.simulate(asm, 6, 4));
    }
}
