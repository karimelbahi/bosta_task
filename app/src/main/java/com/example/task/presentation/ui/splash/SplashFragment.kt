package com.example.task.presentation.ui.splash

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.task.R
import com.example.task.databinding.FragmentSplashBinding

class SplashFragment : Fragment(R.layout.fragment_splash) {

    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSplashBinding.bind(view)

        setUpViews()
        setObservers()

    }


    private fun setUpViews() {

    }

    private fun setObservers() {

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}