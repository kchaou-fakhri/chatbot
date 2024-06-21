package com.dev0kch.chatbot.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev0kch.chatbot.data.repository.remote.auth.AuthRepositoryImpl
import com.dev0kch.chatbot.domain.entity.User
import com.dev0kch.chatbot.utils.Resource
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthenticationViewModel @Inject constructor(
    private val authRepositoryImpl: AuthRepositoryImpl
) : ViewModel() {

    private val _loginFlow = MutableStateFlow<Resource<FirebaseUser>?>(null)
    val loginFLow: StateFlow<Resource<FirebaseUser>?> = _loginFlow



    val currentUser: FirebaseUser?
        get() = authRepositoryImpl.currentUser

    init {
        if(authRepositoryImpl.currentUser?.email != null){
            _loginFlow.value = Resource.Success(authRepositoryImpl.currentUser!!)
        }
    }

    fun login(email: String, password: String) = viewModelScope.launch {
        _loginFlow.value = Resource.Loading
        val result = authRepositoryImpl.login(User(email, password, null))
        _loginFlow.value = result

    }

    fun signUp(email: String, password: String) = viewModelScope.launch {
        _loginFlow.value = Resource.Loading
        val result = authRepositoryImpl.signup(User(email, password, null))
        _loginFlow.value = result

    }


}