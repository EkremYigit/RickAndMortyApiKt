package com.example.baseproject.feature.presentation.ui

import android.os.Bundle
import android.transition.ChangeBounds
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.baseproject.core.base.BaseFragment
import com.example.baseproject.core.extensions.loadImage
import com.example.baseproject.databinding.FragmentDetailBinding
import com.example.baseproject.feature.presentation.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : BaseFragment<FragmentDetailBinding>(
    FragmentDetailBinding::inflate
) {
    private val args: DetailFragmentArgs by navArgs()
    override val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = ChangeBounds().apply {
            duration = 700
        }
        sharedElementReturnTransition= ChangeBounds().apply {
            duration = 700
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        postponeEnterTransition()
        binding.character = args.character
        binding.detailIv.loadImage(args.character?.image) {
            startPostponedEnterTransition()
        }
    }

}