package com.example.thisisit

import android.content.Context
import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginRepository {
    companion object {
        var loginDB: LoginDatabase? = null

        fun initialiseDB(context: Context): LoginDatabase {
            return LoginDatabase.getLoginDBInstance(context)!!
        }

        fun insertData(context: Context, userName: String, password: String) {
            loginDB = initialiseDB(context)
            CoroutineScope(Dispatchers.IO).launch {
                val loginTableModel: LoginTableModel = LoginTableModel(userName, password)
                loginDB!!.loginDao().insertdata(loginTableModel)
            }
        }

        fun getUserDetails(context: Context, userName: String): LiveData<LoginTableModel>? {
            loginDB = initialiseDB(context)
            val loginTableModel: LiveData<LoginTableModel> = loginDB!!.loginDao().getLoginDetails(userName)
            return loginTableModel
        }
    }
}