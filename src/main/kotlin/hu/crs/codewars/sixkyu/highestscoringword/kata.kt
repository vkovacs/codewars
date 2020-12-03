package hu.crs.codewars.sixkyu.highestscoringword

import java.util.stream.Collectors

/**
 * Highest Scoring Word
 *
 * https://www.codewars.com/kata/57eb8fcdf670e99d9b000272
 */
fun high(str: String): String {
    val scores = str.split(" ")
            .stream()
            .collect(Collectors.groupingBy { word -> score(word) })

    return scores[scores.keys.max()]!![0]
}

fun score(word: String): Int {
    return word.map { a -> a.toByte() - 97 + 1 }
            .sum()
}

