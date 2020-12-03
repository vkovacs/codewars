package hu.crs.codewars.sevenkyu.vowelcount

/**
 * Vowel Count
 *
 * https://www.codewars.com/kata/54ff3102c1bad923760001f3
 */
fun getCount(str: String): Int {
    return str.chars()
            .mapToObj { n -> n.toChar() }
            .filter { n -> n == 'a' || n == 'e' || n == 'i' || n == 'o' || n == 'u' }
            .count()
            .toInt()
}
