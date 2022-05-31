package com.example.baseproject.feature.data.local.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class CharacterEntity(
    val image: String? = null,
    val name: String? = null,
    val species: String? = null,
    @PrimaryKey val id: Int? = null
) : Parcelable