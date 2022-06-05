package com.example.task.presentation.ui.zoomimage

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.task.R
import com.example.task.databinding.FragmentZoomImageBinding
import com.example.task.presentation.utils.loadImage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ZoomImageFragment : Fragment(R.layout.fragment_zoom_image) {

    private val args: ZoomImageFragmentArgs by navArgs()
    private var _binding: FragmentZoomImageBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentZoomImageBinding.bind(view)

        setUpViews()
    }


    private fun setUpViews() {
        binding.imageTitle.text=args.albumTitle
        binding.imageView.loadImage(args.albumUrl,null,binding.progress)

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}