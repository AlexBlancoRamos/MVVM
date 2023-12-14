package com.alexblanco.mvvm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
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

        val model = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        model.message.observe(viewLifecycleOwner, Observer { name ->
            val userInfo = viewModel.getUserInfoByName(name)

            userInfo?.let {
                binding.tvUser.text = it.user
                binding.tvEdat.text = it.edat.toString()
                binding.tvCorreu.text = it.correu
            }
        })


        binding.viewContainer.setOnClickListener {
            viewModel.randomQuote()
            binding.tvUser.text = HomeViewModel.user
            binding.tvEdat.text = HomeViewModel.edat.toString()
            binding.tvCorreu.text = HomeViewModel.correu
        }

        return binding.root
    }

}
