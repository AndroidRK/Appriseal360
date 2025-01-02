package com.rutvik.appraisal360.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "manager_table")
data class Manager(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val firstName: String,
    val lastName: String,
    val department: String,   // IT, Sales, Management
    val phoneNumber: String,
    val dateOfBirth: String,
    val gender: String,
    val averageReview: Float
)