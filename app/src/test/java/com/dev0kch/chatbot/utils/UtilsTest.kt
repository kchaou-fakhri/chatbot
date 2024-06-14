package com.dev0kch.chatbot.utils

import org.junit.Test

class UtilsTest {

    @Test
    fun `Should be true`() {
         val result = validateEmail("test@test.com")
            assert(result)

    }

    @Test
    fun `Should be false`() {
        val result = validateEmail("test-test.com")
        assert(!result)

    }
}