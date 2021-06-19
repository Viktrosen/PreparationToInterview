package com.example.preparationtointerview.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.example.preparationtointerview.R
import com.example.preparationtointerview.databinding.FragmentSettingsBinding
import com.example.preparationtointerview.presenter.SettingsPresenter


class SettingsFragment : BaseFragment<FragmentSettingsBinding>() {

    private val presenter:SettingsPresenter = SettingsPresenter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onAttachView(this)
        binding.recycleView.adapter = SettingsAdapter(presenter)


    }

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    )= FragmentSettingsBinding.inflate(inflater, container, false)


    override fun onPause() {
        super.onPause()
        presenter.onDetachView()
    }


}