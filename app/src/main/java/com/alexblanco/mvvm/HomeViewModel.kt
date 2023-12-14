package com.alexblanco.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class HomeViewModel : ViewModel() {

    fun randomQuote() {
        val currentQuote = UsersProvider.random()
        _user = currentQuote.user
        _edat = currentQuote.edat
        _correu = currentQuote.correu
    }

    companion object{
        private var _user = ""
        val user: String
            get() = _user

        private var _edat = 0
        val edat: Int
            get() = _edat

        private var _correu = ""
        val correu: String
            get() = _correu
    }

    fun authenticateUser(username: String, password: String): Boolean {
        for (contraModel in ContraProvider.quotes) {
            if (contraModel.name == username && contraModel.contra == password) {
                return true
            }
        }
        return false
    }

    fun getUserInfoByName(name: String): UserModel? {
        return UsersProvider.quotes.find { it.user == name }
    }
}
