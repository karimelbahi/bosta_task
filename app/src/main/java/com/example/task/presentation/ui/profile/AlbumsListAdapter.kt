package com.example.task.presentation.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.task.databinding.AlbumItemBinding
import com.example.task.domain.entity.Album
import javax.inject.Inject

class AlbumsListAdapter @Inject constructor() :
    ListAdapter<Album, AlbumsListAdapter.ViewHolder>(CountryListDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            AlbumItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: AlbumItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(album: Album) {
            binding.apply {
                with(album) {
                    albumName.text = title
                }
            }
        }
    }


    class CountryListDiffCallback : DiffUtil.ItemCallback<Album>() {

        override fun areItemsTheSame(
            oldUser: Album,
            newUser: Album
        ): Boolean {
            return oldUser.id == newUser.id
        }

        override fun areContentsTheSame(
            oldUser: Album,
            newUser: Album
        ): Boolean {
            return oldUser == newUser
        }

    }

}