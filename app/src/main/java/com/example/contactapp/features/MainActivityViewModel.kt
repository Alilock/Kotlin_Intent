package com.example.contactapp.features

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.contactapp.model.Contact

class MainActivityViewModel:ViewModel() {

  var onButtonClickOberver = MutableLiveData<Boolean>()


    fun navigateAdd(){
        onButtonClickOberver.postValue(true)
    }


}