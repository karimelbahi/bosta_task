package com.example.task.presentation.ui.profile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.task.R
import com.example.task.databinding.FragmentProfileBinding
import com.example.task.domain.entity.Album
import com.example.task.interfaces.OnItemClickListener
import com.example.task.presentation.ui.home.adapter.AlbumsListAdapter
import com.example.task.presentation.utils.Status
import com.example.task.presentation.utils.invisible
import com.example.task.presentation.utils.snack
import com.example.task.presentation.utils.visible
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ProfileFragment : Fragment(R.layout.fragment_profile), OnItemClickListener<Album> {

    private val viewModel: ProfileViewModel by viewModels()
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    private val albumsListAdapter by lazy {
        AlbumsListAdapter(this@ProfileFragment)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentProfileBinding.bind(view)

        setUpViews()
        setObservers()
    }


    private fun setUpViews() {
        viewModel.getUserDetails()
        binding.apply {
            progressCircular.visibility = View.VISIBLE
            albumsRecycler.apply {
                adapter = albumsListAdapter
                layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
                itemAnimator = null
                addItemDecoration(
                    DividerItemDecoration(activity, LinearLayoutManager.VERTICAL)
                )
            }
        }


    }

    private fun setObservers() {

        viewModel.users.observe(viewLifecycleOwner) { users ->
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
                    binding.progressCircular.invisible()
                    users.data?.let {
                        with(it) {
                            binding.name.text = name
                            binding.address.text = address
                        }
                    }
                }
            }
        }

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
                    binding.progressCircular.invisible()
                    users.data?.let {
                        if (it.isNullOrEmpty())
                            showSnackBar(getString(R.string.no_albums_for_user))
                        else {
                            binding.albumsLabel.visible()
                            albumsListAdapter.submitList(it)
                        }
                    }
                }
            }
        }
    }

    override fun onItemClicked(item: Album) {
        findNavController().navigate(
            ProfileFragmentDirections.actionProfileFragmentToAlbumDetailsFragment(
                item.title, item.id
            )
        )
    }

    private fun showSnackBar(message: String) {
        binding.main.snack(message) {}
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}

