package com.example.baseproject.feature.presentation.viewmodels

import androidx.lifecycle.viewModelScope
import com.example.baseproject.core.base.BaseViewModel
import com.example.baseproject.feature.data.local.entity.CharacterEntity
import com.example.baseproject.feature.data.repository.MainRepository
import com.example.baseproject.feature.presentation.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val mainRepository: MainRepository): BaseViewModel() {
    private val _posts: MutableStateFlow<State<List<CharacterEntity>>> = MutableStateFlow(State.Empty)
    val posts: StateFlow<State<List<CharacterEntity>>> = _posts

    @OptIn(InternalCoroutinesApi::class)
    fun getAllCharacters() {
        // to see loading dialog animation remove this comment blocks.
        // CommonUtils.getProgressDialog().show()
        viewModelScope.launch {
            mainRepository.getAllCharacters()
                .map { resource ->
                    State.fromResource(resource)
                }
                .collect { state ->
                    /*if(state !is State.Empty) {
                        Handler().postDelayed({
                            CommonUtils.getProgressDialog().dismiss()
                        }, 1300)
                    }*/
                    _posts.value = state
                }
        }
    }
}
