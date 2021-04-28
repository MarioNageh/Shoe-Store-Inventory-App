package com.udacity.shoestore.ui.shoelist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.Constants
import com.udacity.shoestore.MainActivity
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.SheoItemBinding
import com.udacity.shoestore.databinding.ShoeFragmentBinding

class ShoeFragment : Fragment() {
    private lateinit var binding: ShoeFragmentBinding
    private lateinit var binding_item: SheoItemBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.shoe_fragment, container, false)
        binding_item = DataBindingUtil.inflate(layoutInflater, R.layout.sheo_item, container, false)

        (activity as MainActivity).getViewModel().listOfShoes.observe(viewLifecycleOwner, {
            binding.list.removeAllViews()
            it.forEach {
                val v: SheoItemBinding =
                    DataBindingUtil.inflate(layoutInflater, R.layout.sheo_item, container, false)
                v.shoeName.text = it.name
                v.shoeDes.text = it.description
                v.txtCompany.text = it.company
                v.txtSize.text = it.size.toString()
                binding.list.addView(v.root)

            }
        })
        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.action_shoeFragment_to_addShoeFragment)
        }
//
        return binding.root
    }
}