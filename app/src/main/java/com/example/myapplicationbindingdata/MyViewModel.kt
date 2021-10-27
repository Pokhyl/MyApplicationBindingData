package com.example.myapplicationbindingdata

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MyViewModel: ViewModel() {

        var message = MutableLiveData<String>()
        fun sendMessage(text: String, context: Context){
            message.value = text
            viewModelScope.launch {
                CatRoomDataBase.getDatabase(context).f1().insert(Cat(0, text))
            }
    }
}