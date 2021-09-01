package com.mohamed.halim.essa.recipe.util

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class RoomConverter {
    @TypeConverter
    fun convertFromList(list: List<String>): String {

        return Gson().toJson(list)
    }

    @TypeConverter
    fun convertToList(s: String): List<String> {
        val listType = object : TypeToken<ArrayList<String?>?>() {}.type
        return Gson().fromJson(s, List::class.java) as List<String>
    }
}