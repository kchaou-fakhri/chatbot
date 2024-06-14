package com.dev0kch.chatbot.utils

fun validateEmail(email : String) : Boolean {
    return  CONSTANTS.EmailRegex.containsMatchIn(email)
}