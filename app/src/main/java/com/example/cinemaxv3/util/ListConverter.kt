package com.example.cinemaxv3.util

import androidx.room.TypeConverter

class ListConverter {
    @TypeConverter
    fun fromList(list: List<Int>?): String? {
        return list?.joinToString(",")
    }

    @TypeConverter
    fun toList(str: String?): List<Int>? {
        return str?.split(",")?.map { it.toInt() }
    }
}