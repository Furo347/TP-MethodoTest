package com.projet1.TP1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CipherUtilTest {

    @Test
    fun testCipherReturnC() {
        val result = CipherUtil.cipher("A", 2)
        assertEquals('C', result)
    }
}
