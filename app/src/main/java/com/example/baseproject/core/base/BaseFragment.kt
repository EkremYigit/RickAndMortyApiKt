package com.example.baseproject.core.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB: ViewBinding>(
    private val bindingInflater: (inflater: LayoutInflater) -> VB
): Fragment() {

    private var _binding: VB? = null
    val binding: VB
    get() = _binding as VB

    abstract val viewModel: BaseViewModel?


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = bindingInflater(inflater)
        _binding?.let {
            return it.root
        } ?:kotlin.run {throw IllegalArgumentException("Binding can be null !")}
    }

    fun navigateTo(destinationId: Int) {
        findNavController().navigate(destinationId)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}