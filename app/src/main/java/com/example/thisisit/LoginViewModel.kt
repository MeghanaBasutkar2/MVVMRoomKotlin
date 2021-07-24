package com.example.thisisit

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    var loginTableModel: LiveData<LoginTableModel>? = null

    fun insertData(context: Context, userName: String, password: String) {
        LoginRepository.insertData(context, userName, password)
    }

    fun getUserData(context: Context, userName: String): LiveData<LoginTableModel>? {
       return LoginRepository.getUserDetails(context, userName)
    }
}