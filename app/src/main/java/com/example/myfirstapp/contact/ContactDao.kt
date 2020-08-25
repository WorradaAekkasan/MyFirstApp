package com.example.myfirstapp.contact

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.myfirstapp.data.ContactData

@Dao
interface ContactDao {
    @Insert
    fun insert(contact: ContactData)

    @Query("select * from table_contact order by contactId DESC")
    fun getName(): LiveData<List<ContactData>>
}