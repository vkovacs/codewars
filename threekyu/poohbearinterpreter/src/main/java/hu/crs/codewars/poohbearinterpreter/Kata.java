package hu.crs.codewars.poohbearinterpreter;

public class Kata {
    public static String interpret(String s) {
        if (s.equals("")) {
            return "";
        }
        int cell = 0;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '+':
                    cell++;
                    break;
                case 'N':
                    result.append(cell);
            }
        }
        return result.toString();
    }
}
