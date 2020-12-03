package hu.crs.codewars.sevenkyu.shortestword

import org.junit.Assert.assertEquals
import org.junit.Test

class KataKtTest {
    @Test
    fun testFixed() {
        assertEquals(3, findShort("bitcoin take over the world maybe who knows perhaps"))
        assertEquals(3, findShort("turns out random test cases are easier than writing out basic ones"))
    }
}