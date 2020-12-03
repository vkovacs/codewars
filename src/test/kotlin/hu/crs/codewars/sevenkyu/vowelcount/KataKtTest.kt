package hu.crs.codewars.sevenkyu.vowelcount

import org.junit.Assert.assertEquals
import org.junit.Test

class KataKtTest {

    @Test
    fun `should count vowels`() {
        assertEquals(5, getCount("abracadabra"))
        assertEquals(1, getCount("test"))
        assertEquals(3, getCount("example"))
    }
}

