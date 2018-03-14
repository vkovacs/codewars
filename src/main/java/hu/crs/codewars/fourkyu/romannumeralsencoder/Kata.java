package hu.crs.codewars.fourkyu.romannumeralsencoder;

/**
 * Roman Numerals Encoder
 */
public class Kata {

    public String solution(int n) {
        int tmpArabicNumber = n;
        StringBuilder romanNumeralStringBuilder = new StringBuilder();

        if (tmpArabicNumber >= 1000) {
            int count = tmpArabicNumber / 1000;
            romanNumeralStringBuilder.append(romanNumerals("M", count));
            tmpArabicNumber -= count * 1000;
        }

        tmpArabicNumber = buildRomanNumeralString(tmpArabicNumber, romanNumeralStringBuilder, 100, "CD", "CM", "D", "C");
        tmpArabicNumber = buildRomanNumeralString(tmpArabicNumber, romanNumeralStringBuilder, 10, "XL", "XC", "L", "X");
        buildRomanNumeralString(tmpArabicNumber, romanNumeralStringBuilder, 1, "IV", "IX", "V", "I");

        return romanNumeralStringBuilder.toString();
    }

    private int buildRomanNumeralString(int tmpArabicNumber, StringBuilder romanNumeralStringBuilder, int arabicDigit, String fourishRomanNumeral, String nineishRomanNumeral, String fiveishRomanNumeral, String oneishRomanNumeral) {
        if (tmpArabicNumber >= arabicDigit) {
            int count = tmpArabicNumber / arabicDigit;
            if (count == 4) {
                romanNumeralStringBuilder.append(fourishRomanNumeral);
                tmpArabicNumber -= count * arabicDigit;
            } else if (count == 9) {
                romanNumeralStringBuilder.append(nineishRomanNumeral);
                tmpArabicNumber -= count * arabicDigit;
            } else {
                if (count >= 5) {
                    romanNumeralStringBuilder.append(fiveishRomanNumeral);
                    tmpArabicNumber -= arabicDigit * 5;
                    count = tmpArabicNumber / arabicDigit;
                }
                romanNumeralStringBuilder.append(romanNumerals(oneishRomanNumeral, count));
                tmpArabicNumber -= arabicDigit * count;
            }
        }
        return tmpArabicNumber;
    }

    private String romanNumerals(String romanNumeral, int count) {
        StringBuilder tmpStringBuilder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            tmpStringBuilder.append(romanNumeral);
        }
        return tmpStringBuilder.toString();
    }
}
