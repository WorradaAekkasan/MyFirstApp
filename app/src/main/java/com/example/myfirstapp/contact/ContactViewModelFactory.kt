package com.example.myfirstapp.contact

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myfirstapp.data.ContactDao
import java.lang.IllegalArgumentException

class ContactViewModelFactory (
    private val dataSource: ContactDao,
    private val application: Application
) : ViewModelProvider.Factory{
    override  fun <T : ViewModel?> create(modelClass: Class<T>): T{
        if(modelClass.isAssignableFrom(ContactViewModel::class.java)){
            return ContactViewModel(dataSource,application) as T
        }
        throw IllegalArgumentException("Unknow view Class")
    }
}