package hu.crs.codewars.onekyu.tinythreepasscompiler;

final class BinOp implements Ast {

  private String op;
  private Ast a;
  private Ast b;

  public BinOp(String op, Ast a, Ast b) {
    this.op = op;
    this.a = a;
    this.b = b;
  }

  @Override public String op() {
    return op;
  }

  public Ast a() {
    return a;
  }

  public Ast b() {
    return b;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    BinOp binOp = (BinOp) o;

    if (op != null ? !op.equals(binOp.op) : binOp.op != null) return false;
    if (a != null ? !a.equals(binOp.a) : binOp.a != null) return false;
    return b != null ? b.equals(binOp.b) : binOp.b == null;
  }

  @Override
  public int hashCode() {
    int result = op != null ? op.hashCode() : 0;
    result = 31 * result + (a != null ? a.hashCode() : 0);
    result = 31 * result + (b != null ? b.hashCode() : 0);
    return result;
  }
}