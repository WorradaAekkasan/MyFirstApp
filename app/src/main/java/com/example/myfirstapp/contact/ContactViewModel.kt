package com.example.myfirstapp.contact

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.myfirstapp.data.ContactDao

class ContactViewModel(val database: ContactDao, application: Application) :
    AndroidViewModel(application){
}