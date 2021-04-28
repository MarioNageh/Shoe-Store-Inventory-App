package com.udacity.shoestore.ui.instruction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.InstructionFragmentBinding

class InstructionFragment : Fragment() {
    private lateinit var binding: InstructionFragmentBinding
    private lateinit var viewModel: InstructionViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.instruction_fragment, container, false)
        viewModel = ViewModelProvider(this).get(InstructionViewModel::class.java)

        binding.desTxt.text = viewModel.instructionWord
        binding.backTxt.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.nextTxt.setOnClickListener {
            findNavController().navigate(R.id.action_instructionFragment_to_shoeFragment)
        }
        return binding.root

    }
}