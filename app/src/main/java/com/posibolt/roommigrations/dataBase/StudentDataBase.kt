package com.posibolt.roommigrations.dataBase

import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Student::class],
    //version = 1
version = 2,
    autoMigrations = [AutoMigration(from = 1, to = 2)]
)
abstract class StudentDataBase : RoomDatabase() {

    abstract val subscriberDAO : StudentDAO

    companion object{
        @Volatile
        private var INSTANCE : StudentDataBase? = null
        fun getInstance(context : Context):StudentDataBase{
            synchronized(this){
                var instance = INSTANCE
                if(instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        StudentDataBase::class.java,
                        "subscribe_data_database"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}