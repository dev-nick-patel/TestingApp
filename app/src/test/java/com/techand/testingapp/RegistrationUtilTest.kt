package com.techand.testingapp


import com.google.common.truth.Truth.assertThat
import org.junit.Test

class RegistrationUtilTest{

    @Test
    fun `empty username returns false`(){
        val result = RegistrationUtil.validateRegistrationInput(
            "",
            "123",
            "123"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `valid username and correctly repeated password returns true`(){
        val result = RegistrationUtil.validateRegistrationInput(
            "Philip",
            "123",
            "123"
        )
        assertThat(result).isTrue()
    }
    @Test
    fun `username already exists return false`(){
        val result = RegistrationUtil.validateRegistrationInput(
            "Carl",
            "123",
            "123"
        )
        assertThat(result).isFalse()
    }

    // empty password
    @Test
    fun `empty password return false`(){
        val result = RegistrationUtil.validateRegistrationInput(
            "nick",
            "",
            ""
        )
        assertThat(result).isFalse()
    }
    // password was repeated incorrectly
    @Test
    fun `password and confirm password does not match return false`(){
        val result = RegistrationUtil.validateRegistrationInput(
            "Nick",
            "123",
            "abc"
        )
        assertThat(result).isFalse()
    }
    // password contains less than 2 digits
    @Test
    fun `less than 2 digit password return false`(){
        val result = RegistrationUtil.validateRegistrationInput(
            "Carl",
            "abcdefghi",
            "abcdefghi"
        )
        assertThat(result).isFalse()
    }

}