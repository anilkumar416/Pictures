package com.example.pictures.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.viewpager2.widget.ViewPager2
import com.example.pictures.R
import com.example.pictures.adapters.PictureDetailsAdapter
import com.example.pictures.databinding.FragmentPictureDetailsBinding
import com.example.pictures.viewmodels.PictureDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class PictureDetailsFragment : Fragment() {

    private lateinit var viewPager2: ViewPager2

    private val args: PictureDetailsFragmentArgs by navArgs()

    @Inject
    lateinit var plantDetailViewModelFactory: PictureDetailsViewModel.AssistedFactory

    private val pictureDetailViewModel: PictureDetailsViewModel by viewModels {
        PictureDetailsViewModel.provideFactory(
            plantDetailViewModelFactory,
            args.pictureId
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentPictureDetailsBinding.inflate(inflater, container, false)

        binding.viewModel = pictureDetailViewModel
        binding.lifecycleOwner = viewLifecycleOwner

        viewPager2 = binding.detailViewPager

        pictureDetailViewModel.pictureList.observe(viewLifecycleOwner, { picturesList ->
            val pictureDetailsAdapter = PictureDetailsAdapter()
            pictureDetailsAdapter.submitList(picturesList)
            viewPager2.adapter = pictureDetailsAdapter

            pictureDetailViewModel.pictureDetails.observe(viewLifecycleOwner, { pictureDetails ->
                val position = pictureDetails.id - 1
                viewPager2.setCurrentItem(position, false)
            })
        })
        return binding.root
    }
}