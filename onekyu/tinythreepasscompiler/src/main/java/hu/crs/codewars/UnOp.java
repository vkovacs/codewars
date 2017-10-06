package hu.crs.codewars;

final class UnOp implements Ast {
  public UnOp(String op, int n) {}

  @Override
  public String op() {
    return null;
  }

  public int n() {
    return Integer.MIN_VALUE;
  }
}