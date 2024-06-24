package com.dev0kch.chatbot.di

import com.dev0kch.chatbot.data.repository.remote.auth.AuthRepositoryImpl
import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Provides
    fun provideFirebaseAuth() : FirebaseAuth {
      return  FirebaseAuth.getInstance()
    }

    @Provides
    fun provideAuthRepository(firebaseAuth : FirebaseAuth) : AuthRepositoryImpl {
        return AuthRepositoryImpl(firebaseAuth)
    }
}