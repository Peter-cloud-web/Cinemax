package com.example.cinemaxv3.presentation.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cinemaxv3.databinding.ItemReviewsBinding
import com.example.cinemaxv3.util.DifferCallback

class MovieReviewsAdapter : RecyclerView.Adapter<MovieReviewsAdapter.ReviewsViewHolder>() {
    inner class ReviewsViewHolder(val binding: ItemReviewsBinding) :
        RecyclerView.ViewHolder(binding.root)

    val comparator = AsyncListDiffer(this, DifferCallback.differCallBack)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieReviewsAdapter.ReviewsViewHolder {
        val binding = ItemReviewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ReviewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ReviewsViewHolder, position: Int) {
        val AUTHOR_AVATAR = "https://image.tmdb.org/t/p/w500"
        val review = comparator.currentList[position]
        with(holder) {
            with(review) {
                Glide.with(holder.itemView)
                    .load(AUTHOR_AVATAR + this.authorDetails.avatarPath)
                    .into(holder.binding.authorAvatar)
                binding.review.text = this.content.toString()
                binding.authorName.text = this.authorDetails.name.toString()
                binding.authorUserName.text = this.authorDetails.userName.toString()
                Log.i("REVIEW_ADAPTER", "List : ${this.content}")
            }
        }

    }

    override fun getItemCount(): Int {
        return comparator.currentList.size
        Log.i("REVIEW_ADAPTER", "List : ${comparator.currentList.size}")
    }
}