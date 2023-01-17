package com.udacity.shoestore

import android.os.Bundle
import android.renderscript.ScriptGroup
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.udacity.shoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {


    lateinit var binding:FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

          binding=  DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
                            binding.loginBtn.setOnClickListener { view: View ->
                                if(binding.emailText.text.isEmpty()||binding.passwordText.text.isEmpty())
                                    Toast.makeText(context,"Email or password is empty",Toast.LENGTH_LONG).show()
                                else
                                    Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_welcomeFragment)
               }
        binding.RegisterBtn.setOnClickListener { view: View ->
            if(binding.emailText.text.isEmpty()||binding.passwordText.text.isEmpty())
                Toast.makeText(context,"Email or password is empty",Toast.LENGTH_LONG).show()
            else
                Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_welcomeFragment)
        }

              return binding.root
    }

}