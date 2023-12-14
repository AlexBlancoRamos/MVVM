package com.alexblanco.mvvm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.alexblanco.mvvm.databinding.FragmentLoginBinding
import com.alexblanco.mvvm.HomeViewModel


class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater)

        val model = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        binding.loginButton.setOnClickListener {
            val username = binding.usernameEditText.text.toString()
            val password = binding.passwordEditText.text.toString()

            if (viewModel.authenticateUser(username, password)) {
                showToast("Login exitoso")
                model.sendMessage(username)
                findNavController().navigate(R.id.action_loginFragment_to_usersFragment, null)
            } else {
                showToast("Error en el login. Usuario o contraseña incorrectos.")
            }
        }

        return binding.root
    }

    fun showToast(message: String) {
        Toast.makeText(binding.root.context, message, Toast.LENGTH_SHORT).show()
    }
}