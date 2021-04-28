package com.udacity.shoestore.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.Constants
import com.udacity.shoestore.models.User

class LoginViewModel : ViewModel() {
    private val _loggingState = MutableLiveData<LoginMessage>()
    val loggingState: LiveData<LoginMessage>
        get() = _loggingState



    data class LoginMessage(val isLogin:Boolean, val message:String)


    private fun MutableList<User>.login(em: String, pass: String): LoginMessage {
        forEach { user ->
            if (user.isUserExists(em, pass)) {
                return LoginMessage(true,"Login Success")
            }
        }
        return LoginMessage(false,"Login Fail")
    }

    init {
        // Not Logged in
        _loggingState.value = LoginMessage(false,"")

    }




     fun login(email: String, password: String) {
        _loggingState.value = Constants.usersList.login(email,password)
    }
}