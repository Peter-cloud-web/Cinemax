package com.example.cinemaxv3.util

import androidx.recyclerview.widget.DiffUtil
import com.example.cinemaxv3.models.responses.Review

class DifferCallback {
    companion object {
        val differCallBack = object : DiffUtil.ItemCallback<Review>() {
            override fun areItemsTheSame(oldItem: Review, newItem: Review): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Review, newItem: Review): Boolean {
                return oldItem == newItem
            }

        }
    }
}
