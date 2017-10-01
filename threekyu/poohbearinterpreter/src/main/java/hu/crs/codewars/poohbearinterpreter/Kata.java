package hu.crs.codewars.poohbearinterpreter;

public class Kata {
    public static String interpret(String s) {
        if (s.equals("")) {
            return "";
        }

        int[] cells = new int[30_000];
        int cellPointer = 0;

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '+':
                    cells[cellPointer]++;
                    break;
                case '>':
                    cellPointer++;
                    break;
                case '<':
                    cellPointer--;
                    break;
                case 'N':
                    result.append(cells[cellPointer]);
            }
        }
        return result.toString();
    }
}
