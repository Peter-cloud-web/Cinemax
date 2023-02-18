package com.example.cinemaxv3.util

import androidx.room.TypeConverter
import com.example.cinemaxv3.models.Movie
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class Converters {
    @TypeConverter
    fun fromMovieList(value:String):List<Movie>{
        val type: Type = object: TypeToken<List<Movie>>(){}.type
        return  Gson().fromJson(value,type)
    }

    @TypeConverter
    fun fromMovieListToString(list:List<Movie>):String{
        val type:Type = object:TypeToken<List<Movie>>() {}.type
        return Gson().toJson(list,type)
    }
}
