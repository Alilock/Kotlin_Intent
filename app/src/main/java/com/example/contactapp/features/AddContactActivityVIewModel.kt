package com.example.contactapp.features

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AddContactActivityVIewModel :ViewModel(){
    var phoneNumber=MutableLiveData<String>()
    var name=MutableLiveData<String>()
    var addContactObserver=MutableLiveData<Boolean>()

    fun onAddNewContact(){

        addContactObserver.postValue(true)

    }


}