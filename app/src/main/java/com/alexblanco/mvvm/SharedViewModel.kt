package com.alexblanco.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {

    val message = MutableLiveData<String>()

    fun sendMessage(text: String) {
        message.value = text
    }
}