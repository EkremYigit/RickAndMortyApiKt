package com.example.baseproject.feature.data.util

import com.google.gson.Gson
import java.lang.reflect.Type
import javax.inject.Inject

class GsonParser @Inject constructor(
    private val gson: Gson
): JsonParser {

    override fun <T> fromJson(json: String, type: Type): T? {
        return gson.fromJson(json, type)
    }

    override fun <T> toJson(obj: T, type: Type): String? {
        return gson.toJson(obj, type)
    }
}