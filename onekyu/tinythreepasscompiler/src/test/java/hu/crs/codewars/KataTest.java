package hu.crs.codewars;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class KataTest {

    @Test
    @Ignore
    public void testSimpleProg() {
        String prog = "[ x y z ] ( 2*3*x + 5*y - 3*z ) / (1 + 3 + 2*2)";
        Kata compiler = new Kata();

        // {'op':'/','a':{'op':'-','a':{'op':'+','a':{'op':'*','a':{'op':'*','a':{'op':'imm','n':2},'b':{'op':'imm','n':3}},'b':{'op':'arg','n':0}},'b':{'op':'*','a':{'op':'imm','n':5},'b':{'op':'arg','n':1}}},'b':{'op':'*','a':{'op':'imm','n':3},'b':{'op':'arg','n':2}}},'b':{'op':'+','a':{'op':'+','a':{'op':'imm','n':1},'b':{'op':'imm','n':3}},'b':{'op':'*','a':{'op':'imm','n':2},'b':{'op':'imm','n':2}}}}
        Ast t1 = new BinOp("/", new BinOp("-", new BinOp("+", new BinOp("*", new BinOp("*", new UnOp("imm", 2), new UnOp("imm", 3)), new UnOp("arg", 0)), new BinOp("*", new UnOp("imm", 5), new UnOp("arg", 1))), new BinOp("*", new UnOp("imm", 3), new UnOp("arg", 2))), new BinOp("+", new BinOp("+", new UnOp("imm", 1), new UnOp("imm", 3)), new BinOp("*", new UnOp("imm", 2), new UnOp("imm", 2))));
        Ast p1 = compiler.pass1(prog);
        Assert.assertEquals("Pass 1", t1, p1);

        // {'op':'/','a':{'op':'-','a':{'op':'+','a':{'op':'*','a':{'op':'imm','n':6},'b':{'op':'arg','n':0}},'b':{'op':'*','a':{'op':'imm','n':5},'b':{'op':'arg','n':1}}},'b':{'op':'*','a':{'op':'imm','n':3},'b':{'op':'arg','n':2}}},'b':{'op':'imm','n':8}}
        Ast t2 = new BinOp("/", new BinOp("-", new BinOp("+", new BinOp("*", new UnOp("imm", 6), new UnOp("arg", 0)), new BinOp("*", new UnOp("imm", 5), new UnOp("arg", 1))), new BinOp("*", new UnOp("imm", 3), new UnOp("arg", 2))), new UnOp("imm", 8));
        Ast p2 = compiler.pass2(p1);
        Assert.assertEquals("Pass 2", t2, p2);

        List<String> p3 = compiler.pass3(p2);
        Assert.assertEquals("prog(4,0,0) == 3", 3, Simulator.simulate(p3, 4, 0, 0));
        Assert.assertEquals("prog(4,8,0) == 8", 8, Simulator.simulate(p3, 4, 8, 0));
        Assert.assertEquals("prog(4,8,16) == 2", 2, Simulator.simulate(p3, 4, 8, 16));
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

    public void testPass1EmptyInput() {
        Assert.assertEquals(null, new Kata().pass1(""));
    }

}
