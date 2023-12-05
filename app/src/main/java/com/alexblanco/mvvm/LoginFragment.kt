package com.alexblanco.mvvm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.alexblanco.mvvm.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater)

        binding.loginButton.setOnClickListener {
            val username = binding.usernameEditText.text.toString()
            val password = binding.passwordEditText.text.toString()

            if (authenticateUser(username, password)) {
                showToast("Login exitoso")
                findNavController().navigate(R.id.action_loginFragment_to_usersFragment, null)
            } else {
                showToast("Error en el login. Usuario o contraseña incorrectos.")
            }
        }

        return binding.root
    }

    private fun authenticateUser(username: String, password: String): Boolean {
        for (contraModel in ContraProvider.quotes) {
            if (contraModel.user == username && contraModel.contra == password) {
                return true
            }
        }
        return false
    }

    private fun showToast(message: String) {
        Toast.makeText(binding.root.context, message, Toast.LENGTH_SHORT).show()

    }
}