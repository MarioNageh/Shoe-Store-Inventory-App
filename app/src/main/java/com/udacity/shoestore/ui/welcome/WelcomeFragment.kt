package com.udacity.shoestore.ui.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.WelcomeFramgentBinding

class WelcomeFragment : Fragment() {
    private lateinit var binding: WelcomeFramgentBinding
    private lateinit var welcomeViewModel: WelcomeViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.welcome_framgent, container, false)
        welcomeViewModel = ViewModelProvider(this).get(WelcomeViewModel::class.java)
        binding.lifecycleOwner = this
        onClickListners()

        return binding.root
    }

    private fun onClickListners() {
        binding.nextTxt.setOnClickListener {
            findNavController().navigate(R.id.action_welcomeFragment_to_instructionFragment)
        }
    }

}