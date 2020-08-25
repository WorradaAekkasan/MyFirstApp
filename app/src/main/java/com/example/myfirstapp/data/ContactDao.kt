package com.example.myfirstapp.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ContactDao {
    @Insert
    fun insert(contact: ContactData)

    @Query("select * from table_contact order by contactId DESC")
    fun getName(): LiveData<List<ContactData>>
}