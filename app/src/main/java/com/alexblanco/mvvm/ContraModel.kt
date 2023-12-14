package com.alexblanco.mvvm

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

data class ContraModel(val name:String, val contra:String) {

    private val _user = MutableLiveData<ContraProvider>()
    val user: LiveData<ContraProvider> = _user

    private val _pass = MutableLiveData<ContraProvider>()
    val pass: LiveData<ContraProvider> = _pass

}