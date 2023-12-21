package com.example.contactapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.contactapp.databinding.ActivityMainBinding
import com.example.contactapp.features.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    lateinit var viewModel: MainActivityViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityMainBinding.inflate(layoutInflater)
        viewModel= ViewModelProvider(this)[MainActivityViewModel::class.java]

        binding.viewModel= viewModel
        binding.lifecycleOwner=this

        setContentView(binding.root)

    }

    fun navigateAddContact(){
        var intent=  Intent(this,AddContactActivity::class.java)
        startActivity(intent)
    }
    fun observeAll(){
        viewModel.onButtonClickOberver.observe(this,{
            if(it){
                navigateAddContact()
            }

        })



    }
    fun removeObserves(){
        viewModel.onButtonClickOberver.removeObservers(this)
        viewModel.onButtonClickOberver.postValue(false)
    }
    override fun onResume() {
        super.onResume()
        observeAll()
    }

    override fun onStop() {
        super.onStop()
        removeObserves()
    }

}
