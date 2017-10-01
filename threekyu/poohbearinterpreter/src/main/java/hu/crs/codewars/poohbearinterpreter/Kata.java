package hu.crs.codewars.poohbearinterpreter;

public class Kata {
    public static String interpret(String expression) {
        int[] cells = new int[30_000];
        int cellPointer = 0;
        int clipboard = 0;

        return execute(cells, cellPointer, clipboard, expression);
    }

    private static String execute(int[] cells, int cellPointer, int clipboard, String expression) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < expression.length(); i++) {
            switch (expression.charAt(i)) {
                case '+':
                    cells[cellPointer] = normalize(cells[cellPointer] + 1);
                    break;
                case '-':
                    cells[cellPointer] = normalize(cells[cellPointer] - 1);
                    break;
                case '>':
                    cellPointer++;
                    break;
                case '<':
                    cellPointer--;
                    break;
                case 'c':
                    clipboard = cells[cellPointer];
                    break;
                case 'p':
                    cells[cellPointer] = clipboard;
                    break;
                case 'T':
                    cells[cellPointer] = normalize(cells[cellPointer] * 2);
                    break;
                case 'Q':
                    cells[cellPointer] = normalize((int) Math.pow(cells[cellPointer], 2));
                    break;
                case 'U':
                    cells[cellPointer] = normalize((int) Math.sqrt(cells[cellPointer]));
                    break;
                case 'L':
                    cells[cellPointer] = normalize(cells[cellPointer] + 2);
                    break;
                case 'I':
                    cells[cellPointer] = normalize(cells[cellPointer] - 2);
                    break;
                case 'V':
                    cells[cellPointer] = normalize(cells[cellPointer] / 2);
                    break;
                case 'A':
                    cells[cellPointer] = normalize(cells[cellPointer] + clipboard);
                    break;
                case 'B':
                    cells[cellPointer] = normalize(cells[cellPointer] - clipboard);
                    break;
                case 'Y':
                    cells[cellPointer] = normalize(cells[cellPointer] * clipboard);
                    break;
                case 'D':
                    cells[cellPointer] = normalize(cells[cellPointer] / clipboard);
                    break;
                case 'N':
                    result.append(cells[cellPointer]);
                    break;
                case 'P':
                    result.append((char) cells[cellPointer]);
                    break;
                case 'W':
                    int cycleStartCount = 1;
                    int cycleEndIndex = -1;
                    int j = i ;
                    while (cycleStartCount > 0) {
                        j++;
                        if (expression.charAt(j) == 'W') {
                            cycleStartCount++;
                        } else if (expression.charAt(j) == 'E') {
                            cycleStartCount--;
                        }
                    }
                    cycleEndIndex = j;
                    String subExpression = expression.substring(i + 1, cycleEndIndex);
                    while (cells[cellPointer] > 0) {
                        result.append(execute(cells, cellPointer, clipboard, subExpression));
                    }
                    i = cycleEndIndex;
            }
        }
        return result.toString();
    }

    private static int normalize(int value) {
        if (value < 0) {
            return 256 - Math.abs(value % 256);
        } else if (value > 255) {
            return value % 256;
        }
        return value;
    }
}
