package com.udacity.shoestore.ui.addshoe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.MainActivity
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.AddShoeFragmentBinding
import com.udacity.shoestore.models.Shoe

class AddShoeFragment : Fragment() {
    private lateinit var binding: AddShoeFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.add_shoe_fragment, container, false)
        binding.cancel.setOnClickListener {
            findNavController().popBackStack()
        }
        var listOfEditText = mutableListOf(
            binding.textFieldName.editText,
            binding.textFieldCompany.editText,
            binding.textFieldSize.editText,
            binding.textFieldDes.editText,
        )
        binding.save.setOnClickListener {
            var isValid = true
            listOfEditText.forEach {
                if (it?.text.toString() == "") {
                    isValid = false
                    it?.error = "You Must Enter it"
                    return@setOnClickListener
                }
            }
            if (isValid) {
                val shoe: Shoe = Shoe(
                    binding.textFieldName.editText?.text.toString(),
                    binding.textFieldSize.editText?.text.toString().toDouble(),
                    binding.textFieldCompany.editText?.text.toString(),
                    binding.textFieldDes.editText?.text.toString(),
                    listOfNotNull()
                )
                (activity as MainActivity).getViewModel().addShoeToList(shoe)
                findNavController().popBackStack()

            }
        }
        return binding.root
    }
}