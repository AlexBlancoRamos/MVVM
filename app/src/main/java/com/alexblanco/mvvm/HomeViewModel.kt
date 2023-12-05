package com.alexblanco.mvvm

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
}
