package com.dev0kch.chatbot.data.repository.remote.auth

import com.dev0kch.chatbot.data.utils.await
import com.dev0kch.chatbot.domain.entity.User
import com.dev0kch.chatbot.domain.repository.IAuth
import com.dev0kch.chatbot.utils.Resource
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth
) : IAuth {

    override val currentUser: FirebaseUser?
        get() = firebaseAuth.currentUser

    override suspend fun login(user: User): Flow<Resource<FirebaseUser?>> {

        return flow {

            try {
                emit(Resource.Loading)
                val result =
                    firebaseAuth.signInWithEmailAndPassword(user.email, user.password!!).await()
                emit(Resource.Success(result.user!!))

            } catch (e: Exception) {
                e.printStackTrace()
                Resource.Failure(e)
            }
        }
    }

    override suspend fun signup(user: User): Flow<Resource<FirebaseUser>> {

        return flow {
            try {
                val result =
                    firebaseAuth.createUserWithEmailAndPassword(user.email, user.password!!).await()
                result.user?.updateProfile(
                    UserProfileChangeRequest.Builder().setDisplayName(user.name).build()
                )?.await()
                Resource.Success(result.user!!)
            } catch (e: Exception) {
                e.printStackTrace()
                Resource.Failure(e)
            }

        }
    }
}