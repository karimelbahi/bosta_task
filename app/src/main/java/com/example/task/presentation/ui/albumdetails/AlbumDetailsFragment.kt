package com.example.task.presentation.ui.albumdetails

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.task.R
import com.example.task.databinding.FragmentAlbumDetailsBinding
import com.example.task.domain.entity.AlbumPhoto
import com.example.task.interfaces.OnItemClickListener
import com.example.task.presentation.utils.Status
import com.example.task.presentation.utils.invisible
import com.example.task.presentation.utils.snack
import com.example.task.presentation.utils.visible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AlbumDetailsFragment : Fragment(R.layout.fragment_album_details),
    OnItemClickListener<AlbumPhoto> {


    private val args: AlbumDetailsFragmentArgs by navArgs()
    private val viewModel: AlbumPhotosViewModel by viewModels()
    private var _binding: FragmentAlbumDetailsBinding? = null
    private val binding get() = _binding!!
    private val albumPhotosListAdapter by lazy {
        AlbumPhotosListAdapter(this@AlbumDetailsFragment)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentAlbumDetailsBinding.bind(view)

        setUpViews()
        setObservers()

    }

    private fun setUpViews() {
        viewModel.getUserDetails(args.albumId)
        binding.apply {
            albumName.text = args.albumTitle
            progressCircular.visibility = View.VISIBLE
            albumsRecycler.apply {
                adapter = albumPhotosListAdapter
                layoutManager = GridLayoutManager(activity, 3)
                itemAnimator = null
                addItemDecoration(
                    DividerItemDecoration(activity, LinearLayoutManager.VERTICAL)
                )
            }
        }


    }

    private fun setObservers() {

        viewModel.usersAlbums.observe(viewLifecycleOwner) { users ->
            when (users.status.get()) {
                Status.LOADING -> {
                    binding.progressCircular.visible()
                }
                Status.ERROR -> {
                    binding.progressCircular.invisible()
                    users.msg?.let {
                        showSnackBar(it)
                    }
                }
                Status.SUCCESS -> {
                    binding.albumName.visible()
                    binding.progressCircular.invisible()
                    users.data?.let {
                        if (it.isNullOrEmpty())
                            showSnackBar(getString(R.string.no_album_photos_for_user))
                        else {
                            albumPhotosListAdapter.submitList(it)
                        }
                    }
                }
            }
        }
    }

    override fun onItemClicked(item: AlbumPhoto) {

    }

    private fun showSnackBar(message: String) {
        binding.main.snack(message) {}
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}