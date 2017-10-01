package hu.crs.codewars.poohbearinterpreter;

public class Kata {
    public static String interpret(String s) {
        int[] cells = new int[30_000];
        int cellPointer = 0;
        int clipboard = 0;

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
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
                case 'N':
                    result.append(cells[cellPointer]);
                    break;
            }
        }
        return result.toString();
    }
}
