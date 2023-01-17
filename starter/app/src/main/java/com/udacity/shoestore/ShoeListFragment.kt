package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.TheDetailsBinding
import com.udacity.shoestore.models.Shoe

class ShoeListFragment : Fragment() {
        private  lateinit var viewModel:ShoeListViewModel
    private lateinit var binding:FragmentShoeListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_shoe_list, container, false)
        binding.add.setOnClickListener{view:View ->
            Navigation.findNavController(view).navigate(R.id.action_shoeListFragment_to_shoeDetailesFragment)
        }
        viewModel = ViewModelProvider(requireActivity())[ShoeListViewModel::class.java]
        viewModel.shoesList.observe(viewLifecycleOwner){viewItems(it)}
        binding.lifecycleOwner=viewLifecycleOwner

        return binding.root
    }

    //View the shoe items by Method to create new layout

    private fun viewItems(viewData:List<Shoe>) {
     viewData.forEach {

         val viewBinding = TheDetailsBinding.inflate(
             LayoutInflater.from(requireContext()),
             binding.viewData,
             false
         )
         with(viewBinding) {
             company.text = it.company
             description.text = it.description
             name.text = it.name
             size.text = it.size
         }
         binding.viewData.addView(viewBinding.root)
     }
 }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val menuHost: MenuHost = requireActivity()

        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                //  menu items
                menuInflater.inflate(R.menu.log_out, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                Navigation.findNavController(view).navigate(R.id.action_shoeListFragment_to_loginFragment)
                return true
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }


}


