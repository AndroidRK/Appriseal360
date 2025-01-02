package com.rutvik.appraisal360.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ManagerDao {

    @Insert
    suspend fun Insert(manager: Manager){

    }

    @Query("select * from manager_table")
     fun getAllUsers():LiveData<List<Manager>>
}