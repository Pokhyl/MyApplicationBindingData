package com.example.myapplicationbindingdata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel: ViewModel() {

        var message = MutableLiveData<String>()
        fun sendMessage(text: String){
            message.value = text
    }
}