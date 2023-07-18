package com.posibolt.roommigrations.dataBase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student_info")
data class Student (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id : Int,

    @ColumnInfo(name = "name")
    val name : String,

    //new field
    @ColumnInfo(name = "place", defaultValue = "No place")
    val place : String
    );