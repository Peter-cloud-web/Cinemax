package com.example.cinemaxv3.util

import androidx.room.TypeConverter

class ListConverter {
    @TypeConverter
    fun fromList(list: List<Int>?): String? {
        return if (list.isNullOrEmpty()) {
            null
        } else {
            list?.joinToString(",")
        }
    }

    @TypeConverter
    fun toList(str: String?): List<Int>? {
        return if (str.isNullOrEmpty()) {
            null
        } else {
            str?.split(",")?.map { it.toInt() }
        }
    }
}