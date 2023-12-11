package com.example.domain.converter

import androidx.room.TypeConverter

class ListConverter {
    @TypeConverter
    fun fromStringList(list: List<String>?): String? {
        return list?.joinToString(",")
    }

    @TypeConverter
    fun toStringList(str: String?): List<String>? {
        return str?.split(",")?.map { it.trim() }
    }

    @TypeConverter
    fun fromIntList(list: List<Int>?): String? {
        return list?.joinToString(",")
    }

    @TypeConverter
    fun toIntList(str: String?): List<Int>? {
        if (str.isNullOrEmpty()) {
            return null
        }
        return str.split(",").mapNotNull { it.toIntOrNull() }

    }
}