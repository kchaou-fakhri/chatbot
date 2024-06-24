package com.dev0kch.chatbot.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev0kch.chatbot.data.repository.remote.auth.AuthRepositoryImpl
import com.dev0kch.chatbot.domain.entity.User
import com.dev0kch.chatbot.utils.Resource
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthenticationViewModel @Inject constructor(
    private val authRepositoryImpl: AuthRepositoryImpl
) : ViewModel() {

    private val _loginFlow = MutableStateFlow<Resource<FirebaseUser?>?>(null)
    val loginFLow: StateFlow<Resource<FirebaseUser?>?> = _loginFlow


    val currentUser: FirebaseUser?
        get() = authRepositoryImpl.currentUser

    init {
        if (authRepositoryImpl.currentUser != null) {
            _loginFlow.value = Resource.Success(authRepositoryImpl.currentUser!!)
        }
    }

    fun login(email: String, password: String) {
        viewModelScope.launch {
            _loginFlow.value = Resource.Loading
            authRepositoryImpl.login(User(email, password, null)).collect { resource ->
                _loginFlow.value = resource
            }
        }
    }

    suspend fun signUp(email: String, password: String) :Flow<Resource<FirebaseUser?>> {
        return authRepositoryImpl.signup(User(email, password, null))

    }


}