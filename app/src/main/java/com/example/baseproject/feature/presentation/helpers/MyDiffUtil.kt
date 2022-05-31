package com.example.baseproject.feature.presentation.helpers

import androidx.recyclerview.widget.DiffUtil
import com.example.baseproject.feature.data.local.entity.CharacterEntity

class MyDiffUtil(
    private val oldList : List<CharacterEntity>,
    private val newList : List<CharacterEntity>
) :DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return when{
            oldList[oldItemPosition].id != newList[newItemPosition].id -> false
            oldList[oldItemPosition].image != newList[newItemPosition].image -> false
            oldList[oldItemPosition].name != newList[newItemPosition].name -> false
            oldList[oldItemPosition].species != newList[newItemPosition].species -> false
            else -> true
        }
    }
}
