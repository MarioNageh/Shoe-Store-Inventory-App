package com.udacity.shoestore.ui.login

import android.content.Context
import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.LoginFragmentBinding


class LoginFragment : Fragment() {
    private lateinit var binding: LoginFragmentBinding
    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.login_fragment, container, false)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        binding.lifecycleOwner = this
//        binding.containerEmail.editText.setText("m")
//        binding.containerPassword.editText.setText("1")

        // Start Set Password
        binding.containerPassword.editText.inputType =
            InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD

        setUpObservers()
        setUpUiActions()
        return binding.root
    }

    private fun setUpUiActions() {
        binding.login.setOnClickListener {
            if (validateInputs()) {
                val imm: InputMethodManager =
                    requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm?.hideSoftInputFromWindow(
                    binding.containerEmail.editText.getWindowToken(),
                    InputMethodManager.RESULT_UNCHANGED_SHOWN
                )
                viewModel.login(
                    binding.containerEmail.editText.text.toString(),
                    binding.containerPassword.editText.text.toString()
                )

            }
        }
    }

    private fun validateInputs(): Boolean {
        if (binding.containerEmail.editText.text.toString() == ""){
            binding.containerEmail.editText.error = requireContext().getString(R.string.email_must_be_null)
            return false
        }
        if (binding.containerPassword.editText.text.toString() == ""){
            binding.containerPassword.editText.error = requireContext().getString(R.string.password_must_be_null)
            return false
        }
        return true
    }

    private fun setUpObservers() {
        viewModel.loggingState.observe(viewLifecycleOwner, {
            if (it.isLogin) {
                findNavController().navigate(R.id.action_loginPageFragment_to_welcomeFragment)
            } else {
                if (it.message != "")
                    Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()

            }
        })

    }

}