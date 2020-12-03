package hu.crs.codewars.sixkyu.hundredthkata

fun mirror(text: String): String {
    val mirrorLength = mirrorLength(text)

    var mirroredText = "*".repeat(mirrorLength).plus("\n")

    text.split(" ")
            .forEach { mirroredText = mirroredText.plus("* ${it.reversed().plus(" ".repeat((longestWordLength(text)?:0) - it.length))} *\n") }


    mirroredText = mirroredText.plus("*".repeat(mirrorLength))
    return mirroredText
}

private fun mirrorLength(text: String) = (longestWordLength(text) ?: 0).plus(4)
private fun longestWordLength(text: String) = text.split(" ").map { it.length }.max()