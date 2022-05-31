package com.example.baseproject.feature.presentation.ui

import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.doOnPreDraw
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.baseproject.R
import com.example.baseproject.core.base.BaseFragment
import com.example.baseproject.databinding.FragmentListBinding
import com.example.baseproject.feature.presentation.State
import com.example.baseproject.feature.presentation.adapters.RvAdapter
import com.example.baseproject.feature.presentation.helpers.PaginationOperation
import com.example.baseproject.feature.presentation.helpers.PaginationScrollListener
import com.example.baseproject.feature.presentation.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class ListFragment : BaseFragment<FragmentListBinding>(
    FragmentListBinding::inflate
) {
    override val viewModel: MainViewModel by viewModels()
    private lateinit var rvAdapter: RvAdapter
    private lateinit var paginationScrollListener: PaginationScrollListener

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        sharedElementReturnTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.move)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        postponeEnterTransition()
        setupRecyclerView()
        observeData()
        getApiCall()
        view.doOnPreDraw { startPostponedEnterTransition() }
    }

    private fun observeData() {
        lifecycleScope.launchWhenStarted {
            viewModel.posts.collect { state ->
                when (state) {
                    is State.Loaded -> {
                        if (state.data.isNotEmpty()) {
                            rvAdapter.setData(state.data)
                            updatePaginationStatus()
                        }
                    }
                    is State.Error -> {
                        Toast.makeText(requireActivity(),state.message, Toast.LENGTH_SHORT).show()
                    }
                    else -> {
                    }
                }
            }
        }
    }


    private fun setupRecyclerView() {
        val linearLayoutManager = LinearLayoutManager(requireActivity())
        rvAdapter = RvAdapter{ ivView, character ->
            val transitionName = getString(R.string.detailTransitionName)
            val extras = FragmentNavigatorExtras(ivView to transitionName)

            val directions = ListFragmentDirections.actionToFooDetailsFragment(character)
            val navController = findNavController()
            navController.navigate(directions, extras)
        }
        binding.mainRv.apply {
            layoutManager = linearLayoutManager
            adapter = rvAdapter
            paginationScrollListener = setupPaginationListener()
            addOnScrollListener(paginationScrollListener)
        }
    }


    private fun setupPaginationListener(): PaginationScrollListener {
        val pageOperation = object: PaginationOperation {
            override fun getNewData() { viewModel.getAllCharacters() }
        }
        return PaginationScrollListener(pageOperation)
    }

    private fun getApiCall() {
        viewModel.getAllCharacters()
    }

    private fun updatePaginationStatus() {
        PaginationScrollListener.CURRENT_PAGE++
        if(PaginationScrollListener.CURRENT_PAGE == PaginationScrollListener.TOTAL_PAGE) {
            paginationScrollListener.isLastPage = true
            binding.mainRv.setPadding(0,0,0,0)
        }
    }

}