package com.alexblanco.mvvm

class UsersProvider {
    companion object {
        fun random(): UserModel {
            val position = (0..3).random()
            return quotes[position]
        }

        private val quotes = listOf(
            UserModel(
                user = "Alex",
                edat = 19,
                correu = "alex@gmail.com"
            ),
            UserModel(
                user = "Marc",
                edat = 19,
                correu = "marc@gmail.com"
            ),
            UserModel(
                user = "Aram",
                edat = 19,
                correu = "aram@gmail.com"
            ),
            UserModel(
                user = "Dani",
                edat = 19,
                correu = "dani@gmail.com"
            )
        )
    }
}