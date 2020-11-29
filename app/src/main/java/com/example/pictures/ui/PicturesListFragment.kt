package com.example.pictures.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.pictures.R
import com.example.pictures.adapters.PicturesListAdapter
import com.example.pictures.databinding.FragmentPicturesListBinding
import com.example.pictures.viewmodels.PicturesListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PicturesListFragment : Fragment() {

    private val viewModel: PicturesListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentPicturesListBinding.inflate(inflater, container, false)
        context ?: return binding.root
        val adapter = PicturesListAdapter()
        binding.plantList.adapter = adapter
        subscribeUi(adapter)
        return binding.root
    }

    private fun subscribeUi(adapter: PicturesListAdapter) {
        viewModel.pictureList.observe(viewLifecycleOwner) { picturesList ->
            adapter.submitList(picturesList)
        }
    }

}