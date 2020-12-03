package hu.crs.codewars.sevenkyu.shortestword

/**
 * Shortest Word
 *
 * https://www.codewars.com/kata/57cebe1dc6fdc20c57000ac9
 */
fun findShort(s: String): Int {
    return s.split(" ")
            .map { word -> word.length }
            .min()!!
}