package com.alexblanco.mvvm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.alexblanco.mvvm.databinding.FragmentUsersBinding

class UsersFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModels()
    private lateinit var binding: FragmentUsersBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentUsersBinding.inflate(inflater)

        binding.viewContainer.setOnClickListener {
            viewModel.randomQuote()
            binding.tvUser.text = HomeViewModel.user
            binding.tvEdat.text = HomeViewModel.edat.toString()
            binding.tvCorreu.text = HomeViewModel.correu
        }

        return binding.root
    }

}
