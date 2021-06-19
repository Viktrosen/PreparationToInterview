package com.example.preparationtointerview.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.preparationtointerview.MainActivity
import com.example.preparationtointerview.R

abstract class BaseFragment<B: ViewBinding> : Fragment() {

    // provides ViewBinding
    protected lateinit var binding: B

    // provides Cicerone.Router
    protected val router
        get() = (activity as MainActivity).router

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = getFragmentBinding(inflater, container)
        return binding.root


    }

    abstract fun getFragmentBinding(inflater: LayoutInflater, container: ViewGroup?): B
}