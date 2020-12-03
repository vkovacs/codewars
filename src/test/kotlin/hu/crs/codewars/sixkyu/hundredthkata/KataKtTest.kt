package hu.crs.codewars.sixkyu.hundredthkata

import org.junit.Assert.assertEquals
import org.junit.Test


class KataKtTest {
    @Test
    fun `Basic Tests`() {
        assertEquals("*********\n* olleH *\n* dlroW *\n*********", mirror("Hello World"))
        assertEquals("************\n* srawedoC *\n************", mirror("Codewars"))
        assertEquals("***********\n* A       *\n* racecar *\n***********", mirror("A racecar"))
    }
}