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
                    cells[cellPointer]++;
                    if (cells[cellPointer] == 256) {
                        cells[cellPointer] = 0;
                    }
                    break;
                case '-':
                    cells[cellPointer]--;
                    if (cells[cellPointer] == -1) {
                        cells[cellPointer] = 255;
                    }
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
                    cells[cellPointer] *= 2;
                    break;
                case 'Q':
                    cells[cellPointer] = (int) Math.pow(cells[cellPointer], 2);
                    break;
                case 'U':
                    cells[cellPointer] = (int) Math.sqrt(cells[cellPointer]);
                    break;
                case 'L':
                    cells[cellPointer] += 2;
                    break;
                case 'I':
                    cells[cellPointer] -= 2;
                    break;
                case 'V':
                    cells[cellPointer] /= 2;
                    break;
                case 'A':
                    cells[cellPointer] += clipboard;
                    break;
                case 'B':
                    cells[cellPointer] -= clipboard;
                    break;
                case 'Y':
                    cells[cellPointer] *= clipboard;
                    break;
                case 'D':
                    cells[cellPointer] /= clipboard;
                    break;
                case 'N':
                    result.append(cells[cellPointer]);
                    break;
                case 'P':
                    result.append((char) cells[cellPointer]);
                    break;
                case 'W':
                    int cycleEndIndex = expression.indexOf('E', i);
                    String subExpression = expression.substring(i + 1, cycleEndIndex);
                    while (cells[cellPointer] > 0) {
                        result.append(execute(cells, cellPointer, clipboard, subExpression));
                    }
                    i = cycleEndIndex;
            }
        }
        return result.toString();
    }
}
