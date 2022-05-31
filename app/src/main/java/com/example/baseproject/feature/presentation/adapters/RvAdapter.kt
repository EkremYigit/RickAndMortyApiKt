package com.example.baseproject.feature.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.baseproject.core.extensions.loadImage
import com.example.baseproject.databinding.SingleItemBinding
import com.example.baseproject.feature.data.local.entity.CharacterEntity
import com.example.baseproject.feature.presentation.helpers.MyDiffUtil

class RvAdapter(private val itemClicked: (ivView: View, character: CharacterEntity) -> Unit
): RecyclerView.Adapter<RvAdapter.CharacterViewHolder>() {

    private var characterList= emptyList<CharacterEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = SingleItemBinding.inflate(inflater, parent, false)
        return CharacterViewHolder(binding, itemClicked)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(characterList[position])
    }

    override fun getItemCount(): Int {
        return characterList.size
    }

    class CharacterViewHolder(
        private val binding: SingleItemBinding,
        private val itemClicked: (ivView: View, character: CharacterEntity) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(entity: CharacterEntity) {
            binding.character = entity
            binding.ivLanguage.loadImage(entity.image)
            binding.executePendingBindings()
            binding.contentLayout.setOnClickListener {
                itemClicked(binding.cardView,entity)
            }
        }
    }

    fun setData(newCharacterList : List<CharacterEntity>){
        val diffUtil = MyDiffUtil(characterList , newCharacterList)
        val diffResult = DiffUtil.calculateDiff(diffUtil)
        characterList = newCharacterList
        diffResult.dispatchUpdatesTo(this)
    }
}
