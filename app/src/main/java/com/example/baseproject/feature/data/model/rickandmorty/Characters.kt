package com.example.baseproject.feature.data.model.rickandmorty

import com.example.baseproject.feature.data.local.entity.CharacterEntity

data class Characters(
    val info: Info?,
    val results: List<CharacterEntity>?= mutableListOf()
)