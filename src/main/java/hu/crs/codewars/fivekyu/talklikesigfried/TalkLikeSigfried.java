package hu.crs.codewars.fivekyu.talklikesigfried;

/**
 * Would you believe... Talk like Siegfried
 *
 * https://www.codewars.com/kata/would-you-believe-dot-dot-dot-talk-like-siegfried
 */
public class TalkLikeSigfried {
    public static String siegfried(final int week, final String str) {

        String translatedSentence = "";
        if (week >= 1) {
            translatedSentence = week1(str);
        }

        if (week >= 2) {
            translatedSentence = week2(translatedSentence);
        }

        if (week >= 3) {
            translatedSentence = week3(translatedSentence);
        }

        if (week >= 4) {
            translatedSentence = week4(translatedSentence);
        }

        if (week >= 5) {
            translatedSentence = week5(translatedSentence);
        }

        return translatedSentence;
    }

    private static String week1(String sentence) {
        return week1Rule3(week1Rule2(week1Rule1(sentence)));
    }

    private static String week2(String sentence) {
        return sentence.replaceAll("p(?i)h", "f")
                .replaceAll("P(?i)h", "F");
    }

    private static String week3(String sentence) {
        return week3Rule2(week3Rule1(sentence));
    }

    private static String week4(String sentence) {
        return week4Rule4(week4Rule3(week4Rule2(week4Rule1(sentence))));
    }

    private static String week5(String sentence) {
        return week5Rule4(week5Rule3(week5Rule2(week5Rule1(sentence))));
    }

    private static String week1Rule1(String sentence) {
        return sentence.replaceAll("CI", "SI")
                .replaceAll("Ci", "Si")
                .replaceAll("cI", "sI")
                .replaceAll("ci", "si");
    }

    private static String week1Rule2(String sentence) {
        return sentence.replaceAll("CE", "SE")
                .replaceAll("Ce", "Se")
                .replaceAll("cE", "sE")
                .replaceAll("ce", "se");
    }

    private static String week1Rule3(String sentence) {
        return sentence.replaceAll("c(?!h)", "k")
                .replaceAll("C(?!h)", "K");
    }

    private static String week3Rule1(String sentence) {
        return sentence.replaceAll("(\\w{3,})(e)(?!\\w)", "$1");
    }

    private static String week3Rule2(String sentence) {
        return sentence.replaceAll("(?i)([a-zA-Z])\\1", "$1");
    }

    private static String week4Rule1(String sentence) {
        return sentence.replaceAll("t(?i)h", "z")
                .replaceAll("T(?i)h", "Z");
    }

    private static String week4Rule2(String sentence) {
        return sentence.replaceAll("w(?i)r", "r")
                .replaceAll("W(?i)r", "R");
    }

    private static String week4Rule3(String sentence) {
        return sentence.replaceAll("w(?i)h", "w")
                .replaceAll("W(?i)h", "W");
    }

    private static String week4Rule4(String sentence) {
        return sentence.replaceAll("w", "v")
                .replaceAll("W", "V");
    }

    private static String week5Rule1(String sentence) {
        return sentence.replaceAll("o(?i)u", "u")
                .replaceAll("O(?i)u", "U");
    }

    private static String week5Rule2(String sentence) {
        return sentence.replaceAll("AN", "UN")
                .replaceAll("An", "Un")
                .replaceAll("aN", "uN")
                .replaceAll("an", "un");
    }

    private static String week5Rule3(String sentence) {
        return sentence.replaceAll("(\\w)ing\\b", "$1ink");
    }

    private static String week5Rule4(String sentence) {
        return sentence.replaceAll("\\b(Sm)", "Schm")
                .replaceAll("\\b(sm)", "schm");
    }
}
