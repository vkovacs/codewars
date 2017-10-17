package hu.crs.codewars;

final class UnOp implements Ast {

  private String operation;
  private int value;

  public UnOp(String operation, int value) {
    this.operation = operation;
    this.value = value;
  }

  @Override
  public String op() {
    return operation;
  }

  public int n() {
    return value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    UnOp unOp = (UnOp) o;

    if (value != unOp.value) return false;
    return operation != null ? operation.equals(unOp.operation) : unOp.operation == null;
  }

  @Override
  public int hashCode() {
    int result = operation != null ? operation.hashCode() : 0;
    result = 31 * result + value;
    return result;
  }
}