package hu.crs.codewars.jadencasestrings;

public class Kata {
    public String toJadenCase(String phrase) {
        if (phrase == null || phrase.isEmpty()) {
            return null;
        }

        String[] phraseArray = phrase.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < phraseArray.length; i++) {
            sb.append(capitalize(phraseArray[i]));
            sb.append(" ");
        }

        return sb.subSequence(0, sb.length() - 1).toString();
    }

    private static String capitalize(String s) {
        return Character.toUpperCase(s.charAt(0)) + s.substring(1);
    }
}
