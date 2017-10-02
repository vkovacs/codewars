package hu.crs.codewars;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Kata {
    public static String stripComments(String text, String[] commentSymbols) {
        String[] lines = text.split("\\n");
        List<String> resultLines = new ArrayList<>();

        for (int i = 0; i < lines.length; i++) {
            String commentSymbolInLine = detectCommentSymbolType(lines[i], commentSymbols);
            if (commentSymbolInLine != null) {
                String[] split = lines[i].split(Pattern.quote(commentSymbolInLine));
                if (split.length > 0) {
                    resultLines.add(split[0]);
                }
            } else {
                resultLines.add(lines[i]);
            }
        }

        return resultLines.stream()
                .map(s -> s.replaceAll("\\s+$", ""))
                .collect(Collectors.joining("\n"));
    }

    private static String detectCommentSymbolType(String text, String[] commentSymbols) {
        int i = 0;
        while (i < commentSymbols.length) {
            if (text.contains(commentSymbols[i])) {
                return commentSymbols[i];
            }
            i++;
        }
        return null;
    }
}
