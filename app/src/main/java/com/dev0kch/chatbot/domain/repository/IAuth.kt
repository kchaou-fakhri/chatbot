package com.dev0kch.chatbot.domain.repository

import com.dev0kch.chatbot.domain.entity.User
import com.dev0kch.chatbot.utils.Resource
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.Flow

interface IAuth {
    val currentUser : FirebaseUser?
     fun login(user : User) : Flow<Resource<FirebaseUser?>>

     fun signup(user : User) : Flow<Resource<FirebaseUser>>
}