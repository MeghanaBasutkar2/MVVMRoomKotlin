package com.example.thisisit

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DaoAccess {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertdata(loginModel: LoginTableModel)

    @Query("SELECT * FROM Login WHERE username =:username")
    fun getLoginDetails(username: String?): LiveData<LoginTableModel>

    //delete and update are other methods
}