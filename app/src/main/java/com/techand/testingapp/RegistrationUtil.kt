package com.techand.testingapp

object RegistrationUtil {


    private val existingUsers = listOf("Peter","Carl")

    /**
     * the input is not valid if....
     *
     * --- the username/password is empty
     * -- the username is already taken
     * -- the password and confirm password does not match
     * -- the password contains less than 2 digit
     *
     */

    fun validateRegistrationInput(
        username: String,
        password: String,
        confirmPassword: String
    ): Boolean{

        if (username.isEmpty() || password.isEmpty()){
            return false
        }
        if (username in existingUsers){
            return false
        }
        if (password != confirmPassword) return false
        if (password.count{ it.isDigit()} < 2) return false

        return true
    }
}