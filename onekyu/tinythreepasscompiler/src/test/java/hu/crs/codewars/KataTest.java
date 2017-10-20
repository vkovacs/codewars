package hu.crs.codewars;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class KataTest {

    @Test
    public void testSimpleProg() {
        String program = "[ x y z ] ( 2*3*x + 5*y - 3*z ) / (1 + 3 + 2*2)";
        Kata compiler = new Kata();

        // {'op':'/','a':{'op':'-','a':{'op':'+','a':{'op':'*','a':{'op':'*','a':{'op':'imm','n':2},'b':{'op':'imm','n':3}},'b':{'op':'arg','n':0}},'b':{'op':'*','a':{'op':'imm','n':5},'b':{'op':'arg','n':1}}},'b':{'op':'*','a':{'op':'imm','n':3},'b':{'op':'arg','n':2}}},'b':{'op':'+','a':{'op':'+','a':{'op':'imm','n':1},'b':{'op':'imm','n':3}},'b':{'op':'*','a':{'op':'imm','n':2},'b':{'op':'imm','n':2}}}}
        Ast t1 = new BinOp("/", new BinOp("-", new BinOp("+", new BinOp("*", new BinOp("*", new UnOp("imm", 2), new UnOp("imm", 3)), new UnOp("arg", 0)), new BinOp("*", new UnOp("imm", 5), new UnOp("arg", 1))), new BinOp("*", new UnOp("imm", 3), new UnOp("arg", 2))), new BinOp("+", new BinOp("+", new UnOp("imm", 1), new UnOp("imm", 3)), new BinOp("*", new UnOp("imm", 2), new UnOp("imm", 2))));
        Ast p1 = compiler.pass1(program);
        Assert.assertEquals("Pass 1", t1, p1);

        // {'op':'/','a':{'op':'-','a':{'op':'+','a':{'op':'*','a':{'op':'imm','n':6},'b':{'op':'arg','n':0}},'b':{'op':'*','a':{'op':'imm','n':5},'b':{'op':'arg','n':1}}},'b':{'op':'*','a':{'op':'imm','n':3},'b':{'op':'arg','n':2}}},'b':{'op':'imm','n':8}}
        Ast t2 = new BinOp("/", new BinOp("-", new BinOp("+", new BinOp("*", new UnOp("imm", 6), new UnOp("arg", 0)), new BinOp("*", new UnOp("imm", 5), new UnOp("arg", 1))), new BinOp("*", new UnOp("imm", 3), new UnOp("arg", 2))), new UnOp("imm", 8));
        Ast p2 = compiler.pass2(p1);
        Assert.assertEquals("Pass 2", t2, p2);

        /*List<String> p3 = compiler.pass3(p2);
        Assert.assertEquals("program(4,0,0) == 3", 3, Simulator.simulate(p3, 4, 0, 0));
        Assert.assertEquals("program(4,8,0) == 8", 8, Simulator.simulate(p3, 4, 8, 0));
        Assert.assertEquals("program(4,8,16) == 2", 2, Simulator.simulate(p3, 4, 8, 16));*/
    }

    @Test
    public void testInfixToPrefixJustEqualPrecedence() {
        Assert.assertEquals("- + A B C", new Kata().toPrefixNotation("A + B - C"));
    }

    @Test
    public void testInfixToPrefixHasHigherPrecedence() {
        Assert.assertEquals("+ A / B 2", new Kata().toPrefixNotation("A + B / 2"));

    }

    @Test
    public void testInfixToPrefixHasHigherPrecedenceAndMultipleLower() {
        Assert.assertEquals("- + A / B 2 3", new Kata().toPrefixNotation("A + B / 2 - 3"));
    }

    @Test
    public void testInfixToPrefixHasMultipleHigherPrecedence() {
        Assert.assertEquals("- / * A B 2 3", new Kata().toPrefixNotation("A * B / 2 - 3"));
    }

    @Test
    public void testInfixToPrefixHandleParenthesis() {
        Assert.assertEquals("+ A / B - 2 3", new Kata().toPrefixNotation("A + B / ( 2 - 3)"));
    }

    @Test
    public void testInfixToPrefixNestedParenthesises() {
        Assert.assertEquals("- * / 15 - 7 + 1 1 3 + 2 + 1 1", new Kata().toPrefixNotation("((15 / (7 - (1 + 1))) * 3) - (2 + (1 + 1))"));
    }

    @Test
    public void testPass1EmptyInput() {
        Assert.assertEquals(null, new Kata().pass1("[]"));
    }

    @Test
    public void testUnaryOperatorWithOneImmutableValue() throws Exception {
        UnOp expectedAst = new UnOp(Kata.IMMEDIATE, 1);
        Assert.assertEquals(expectedAst, new Kata().pass1("[] 1"));
    }

    @Test
    public void testUnaryOperatorWithOneArgumentReturnsConstant() throws Exception {
        UnOp expectedAst = new UnOp(Kata.IMMEDIATE, 1);
        Assert.assertEquals(expectedAst, new Kata().pass1("[x] 1"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUnaryOperatorWithIncorrectSyntax() throws Exception {
        UnOp expectedAst = new UnOp(Kata.IMMEDIATE, 0);
        new Kata().pass1("0");
    }

    @Test
    public void testUnaryOperatorWithOneArgumentReturnsSameArgument() throws Exception {
        UnOp expectedAst = new UnOp(Kata.ARGUMENT, 0);
        Assert.assertEquals(expectedAst, new Kata().pass1("[x] x"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUnaryOperatorWithOneIllegalArgument() throws Exception {
        new Kata().pass1("[x] y");
    }

    @Test
    public void testBinaryOperatorReturnsConstant() throws Exception {
        UnOp expectedA = new UnOp(Kata.IMMEDIATE, 1);
        UnOp expectedB = new UnOp(Kata.IMMEDIATE, 2);
        BinOp expectedAst = new BinOp("+", expectedA, expectedB);
        Assert.assertEquals(expectedAst, new Kata().pass1("[x y] 1 + 2"));
    }

    @Test
    public void testBinaryOperatorReturnsArguments() throws Exception {
        UnOp expectedA = new UnOp(Kata.ARGUMENT, 0);
        UnOp expectedB = new UnOp(Kata.ARGUMENT, 1);
        BinOp expectedAst = new BinOp("+", expectedA, expectedB);
        Assert.assertEquals(expectedAst, new Kata().pass1("[x y] x + y"));
    }

    @Test
    public void testBinaryOperatorComplexFunctionBody() throws Exception {
        BinOp expectedAst = new BinOp("/", new BinOp("+", new UnOp(Kata.ARGUMENT, 0), new UnOp(Kata.ARGUMENT, 1)), new UnOp(Kata.IMMEDIATE, 2));
        Assert.assertEquals(expectedAst, new Kata().pass1("[ x y ] ( x + y ) / 2"));
    }

    @Test
    public void testASTSimplification() throws Exception {
        BinOp expectedAst = new BinOp("+", new UnOp("arg", 0), new UnOp(Kata.IMMEDIATE, 10));
        Kata kata = new Kata();
        Assert.assertEquals(expectedAst, kata.pass2(kata.pass1("[ x ] x + 2 * 5")));
    }

    @Test
    public void testUnaryOperatorWithOneImmutableValueSimplified() throws Exception {
        UnOp expectedAst = new UnOp(Kata.IMMEDIATE, 1);
        Kata kata = new Kata();
        Assert.assertEquals(expectedAst, kata.pass2(kata.pass1("[] 1")));
    }

    @Test
    public void testUnaryOperatorWithOneArgumentReturnsConstantSimplified() throws Exception {
        UnOp expectedAst = new UnOp(Kata.IMMEDIATE, 1);
        Kata kata = new Kata();
        Assert.assertEquals(expectedAst, kata.pass2(kata.pass1("[x] 1")));
    }

    @Test
    public void testUnaryOperatorWithOneArgumentReturnsSameArgumentSimplified() throws Exception {
        UnOp expectedAst = new UnOp(Kata.ARGUMENT, 0);
        Kata kata = new Kata();
        Assert.assertEquals(expectedAst, kata.pass2(kata.pass1("[x] x")));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUnaryOperatorWithOneIllegalArgumentSimplified() throws Exception {
        Kata kata = new Kata();
        kata.pass2(kata.pass1("[x] y"));
    }

    @Test
    public void testBinaryOperatorReturnsConstantSimplified() throws Exception {
        UnOp expectedAst = new UnOp(Kata.IMMEDIATE, 3);
        Kata kata = new Kata();
        Assert.assertEquals(expectedAst, kata.pass2(kata.pass1("[x y] 1 + 2")));
    }

    @Test
    public void testBinaryOperatorReturnsArgumentsSimplified() throws Exception {
        UnOp expectedA = new UnOp(Kata.ARGUMENT, 0);
        UnOp expectedB = new UnOp(Kata.ARGUMENT, 1);
        BinOp expectedAst = new BinOp("+", expectedA, expectedB);
        Kata kata = new Kata();
        Assert.assertEquals(expectedAst, kata.pass2(kata.pass1("[x y] x + y")));
    }

    @Test
    public void testBinaryOperatorComplexFunctionBodySimplified() throws Exception {
        BinOp expectedAst = new BinOp("/", new BinOp("+", new UnOp(Kata.ARGUMENT, 0), new UnOp(Kata.ARGUMENT, 1)), new UnOp(Kata.IMMEDIATE, 2));
        Kata kata = new Kata();
        Assert.assertEquals(expectedAst, kata.pass2(kata.pass1("[ x y ] ( x + y ) / 2")));
    }

    @Test
    public void testUnaryOperatorWithOneImmutableValueExecuted() throws Exception {
        String function = "[] 1";
        Kata kata = new Kata();
        List<String> asm = kata.pass3(kata.pass2(kata.pass1(function)));
        Assert.assertEquals(1, Simulator.simulate(asm));
    }

    @Test
    public void testUnaryOperatorWithOneArgumentReturnsSameArgumentExecuted() throws Exception {
        String function = "[x] x";
        Kata kata = new Kata();
        List<String> asm = kata.pass3(kata.pass2(kata.pass1(function)));
        Assert.assertEquals(2, Simulator.simulate(asm, 2));
    }

    @Test
    public void testBinaryOperatorReturnsConstantExecuted() throws Exception {
        String function = "[] 1 + 2";
        Kata kata = new Kata();
        List<String> asm = kata.pass3(kata.pass2(kata.pass1(function)));
        Assert.assertEquals(3, Simulator.simulate(asm));
    }

    @Test
    public void testBinaryOperatorReturnsArgumentsExecuted() throws Exception {
        String function = "[x y] x + y";
        Kata kata = new Kata();
        List<String> asm = kata.pass3(kata.pass2(kata.pass1(function)));
        Assert.assertEquals(7, Simulator.simulate(asm, 3, 4));
    }

    @Test
    public void testBinaryOperatorReturnsOneIntermediatePlusOneArgumentsExecuted() throws Exception {
        String function = "[x] x + 2";
        Kata kata = new Kata();
        List<String> asm = kata.pass3(kata.pass2(kata.pass1(function)));
        Assert.assertEquals(5, Simulator.simulate(asm, 3));
    }

}
