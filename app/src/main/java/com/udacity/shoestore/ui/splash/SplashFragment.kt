package com.udacity.shoestore.ui.splash

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.MainActivity
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.SplashFragmentBinding


class SplashFragment : Fragment() {
    private lateinit var binding: SplashFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.splash_fragment, container, false)

//        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
//        (activity as MainActivity)!!.lockNavigationDrawer()

        binding.login.setOnClickListener {
            findNavController().navigate(R.id.action_splachFragment_to_loginFragment)
        }
        return binding.root
    }



}