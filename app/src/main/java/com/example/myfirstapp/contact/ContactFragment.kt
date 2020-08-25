package com.example.myfirstapp.contact

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.myfirstapp.R
import com.example.myfirstapp.data.ContactDatabase
import com.example.myfirstapp.databinding.FragmentContactBinding


class ContactFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentContactBinding =
            DataBindingUtil.inflate(inflater,R.layout.fragment_contact,container,false)
        val  application = requireNotNull(this.activity).application

        val dataSource = ContactDatabase.getInstance(application).conDatabaseDao

        val viewModelFactory = ContactViewModelFactory(dataSource,application)

        val  contactViewModel = ViewModelProvider(this,viewModelFactory).get(ContactViewModel::class.java)

        binding.setLifecycleOwner(this)
        binding.contactViewModel = contactViewModel

        return binding.root
    }


}