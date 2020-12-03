package hu.crs.codewars.sixkyu.highestscoringword

import org.junit.Assert.assertEquals
import org.junit.Test


class KataKtTest {
    @Test
    fun find() {
        assertEquals("taxi", high("man i need a taxi up to ubud"))
        assertEquals("volcano", high("what time are we climbing up the volcano"))
        assertEquals("semynak", high("take me to semynak"))
    }
}