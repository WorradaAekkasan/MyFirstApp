package com.example.myfirstapp.contact

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myfirstapp.data.ContactData

@Database(entities = [ContactData::class],version = 1)
abstract class ContactDatabase : RoomDatabase(){

    abstract val conDatabaseDao: ContactDao
    companion object{
        private var INSTANCE: ContactDatabase? = null

        fun  getInstance(context: Context): ContactDatabase{
            synchronized(this){
                var instance = INSTANCE

                if (instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ContactDatabase::class.java,
                        "contact_his_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}