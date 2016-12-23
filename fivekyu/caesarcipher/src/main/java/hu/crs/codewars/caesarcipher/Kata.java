package hu.crs.codewars.caesarcipher;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Kata {
    private static final int PREFERRED_RUNNERS_COUNT = 4;

    static List<String> movingShift(String s, int shift) {
        StringBuilder stringBuilder = getShiftedStringBuilder(s, shift);

        return buildRunners(stringBuilder.toString());
    }

    static String demovingShift(List<String> s, int shift) {
        String shiftedString = s.stream()
                .collect(Collectors.joining());

        StringBuilder shiftedStringBuilder = getShiftedStringBuilder(shiftedString, -shift);

        return shiftedStringBuilder.toString();
    }

    private static StringBuilder getShiftedStringBuilder(String s, int shift) {
        StringBuilder stringBuilder = new StringBuilder();
        int actualShift = shift;
        for (int i = 0; i < s.length(); i++) {
            stringBuilder.append(multipleShift(s.charAt(i), actualShift));
            if (shift > 0) {
                actualShift++;
            } else {
                actualShift--;
            }
        }
        return stringBuilder;
    }

    private static char multipleShift(char character, int count) {
        if (count == 0) {
            return character;
        }

        char result = character;
        for (int i = 0; i < Math.abs(count); i++) {
            if (count > 0) {
                result = shiftUp(result);
            } else {
                result = shiftDown(result);
            }
        }
        return result;
    }

    private static char shiftUp(char character) {
        if (Character.isLetter(character)) {
            switch (character) {
                case 'Z':
                    return 'A';
                case 'z':
                    return 'a';
                default:
                    return ++character;
            }
        }
        return character;
    }

    private static char shiftDown(char character) {
        if (Character.isLetter(character)) {
            switch (character) {
                case 'A':
                    return 'Z';
                case 'a':
                    return 'z';
                default:
                    return --character;
            }
        }
        return character;
    }

    private static List<String> buildRunners(String s) {
        int length = s.length();
        int characterCountPerRunner = calculateCharacterCountPerRunner(length);

        List<String> resultStrings = new ArrayList<>();

        StringBuilder runnerBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (((i > 0) && (i % characterCountPerRunner) == 0)) {
                resultStrings.add(runnerBuilder.toString());
                runnerBuilder = new StringBuilder();
                runnerBuilder.append(s.charAt(i));
            } else {
                runnerBuilder.append(s.charAt(i));
            }
        }
        resultStrings.add(runnerBuilder.toString());

        if (resultStrings.size() < 5) {
            resultStrings.add("");
        }

        return resultStrings;
    }

    private static int calculateCharacterCountPerRunner(int length) {
        if ((length % PREFERRED_RUNNERS_COUNT == 0)) {
            return length / PREFERRED_RUNNERS_COUNT;
        } else {
            int mainRunnersLength = (int) Math.floor(length / (PREFERRED_RUNNERS_COUNT));
            int lastRunnerLength = length - (PREFERRED_RUNNERS_COUNT * mainRunnersLength);

            boolean isMaxLastRunnerLength = false;
            while (!isMaxLastRunnerLength) {
                if ((mainRunnersLength - 1) >= (lastRunnerLength + PREFERRED_RUNNERS_COUNT)) {
                    mainRunnersLength--;
                    lastRunnerLength += PREFERRED_RUNNERS_COUNT;
                } else {
                    isMaxLastRunnerLength = true;
                }
            }
            return mainRunnersLength;
        }
    }
}
