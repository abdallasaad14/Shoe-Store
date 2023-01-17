package com.udacity.shoestore

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.udacity.shoestore.databinding.FragmentShoeDetailesBinding
import com.udacity.shoestore.models.Shoe

class ShoeDetailesFragment : Fragment() {

    private lateinit var viewModel:ShoeListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentShoeDetailesBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detailes, container, false)
        viewModel = ViewModelProvider(requireActivity())[ShoeListViewModel::class.java]
        binding.view=viewModel

        binding.cancelButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_shoeDetailesFragment_to_shoeListFragment))
        binding.addBtn.setOnClickListener { view:View ->

            val name=viewModel.name.value.toString()
            val size=viewModel.size.value.toString()
            val company=viewModel.company.value.toString()
            val description=viewModel.description.value.toString()

            viewModel.savedetailes(name, size, company, description)
            Navigation.findNavController(view).navigate(R.id.action_shoeDetailesFragment_to_shoeListFragment)

        }
      return  binding.root

    }
}