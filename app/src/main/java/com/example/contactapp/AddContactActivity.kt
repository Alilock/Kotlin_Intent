package com.example.contactapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.contactapp.databinding.ActivityAddContactBinding
import com.example.contactapp.databinding.ActivityMainBinding
import com.example.contactapp.features.AddContactActivityVIewModel
import com.example.contactapp.features.MainActivityViewModel

class AddContactActivity : AppCompatActivity() {
    lateinit var binding : ActivityAddContactBinding
    lateinit var viewModel: AddContactActivityVIewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAddContactBinding.inflate(layoutInflater)
        viewModel= ViewModelProvider(this)[AddContactActivityVIewModel::class.java]

        binding.viewModel= viewModel
        binding.lifecycleOwner=this

        setContentView(binding.root)
    }

    fun onAddContact(){
        viewModel.addContactObserver.observe(this,{
            if(it){
               println(viewModel.name.value + " " + viewModel.phoneNumber.value)
                var intent= Intent(this,MainActivity::class.java)
                startActivity(intent)

            }
        })
    }

    override fun onResume() {
        super.onResume()
        onAddContact()
    }

}