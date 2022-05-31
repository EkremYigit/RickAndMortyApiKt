package com.example.baseproject.feature.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.baseproject.feature.data.local.entity.CharacterEntity
import com.example.baseproject.feature.data.util.JsonParser
import com.google.gson.reflect.TypeToken

@ProvidedTypeConverter
class Converters(
    private val jsonParser: JsonParser
) {
    @TypeConverter
    fun fromJson(json: String): List<CharacterEntity> {
        return jsonParser.fromJson<ArrayList<CharacterEntity>>(
            json,
            object : TypeToken<ArrayList<CharacterEntity>>(){}.type
        ) ?: emptyList()
    }

    @TypeConverter
    fun toJson(anyList: List<CharacterEntity>): String {
        return jsonParser.toJson(
            anyList,
            object : TypeToken<ArrayList<CharacterEntity>>(){}.type
        ) ?: "[]"
    }
}