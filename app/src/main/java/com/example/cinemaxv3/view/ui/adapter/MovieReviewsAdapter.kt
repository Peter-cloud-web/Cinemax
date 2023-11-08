package com.example.cinemaxv3.view.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import coil.request.ImageRequest
import com.example.cinemaxv3.databinding.ItemReviewsBinding
import com.example.cinemaxv3.util.Constants.IMAGE_BASE_URL
import com.example.cinemaxv3.util.DifferCallback
import javax.inject.Inject

class MovieReviewsAdapter @Inject constructor(private val imageLoader: ImageLoader) :
    RecyclerView.Adapter<MovieReviewsAdapter.ReviewsViewHolder>() {
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
        val AUTHOR_AVATAR = IMAGE_BASE_URL
        val review = comparator.currentList[position]
        with(holder) {
            with(review) {
                val request = ImageRequest.Builder(holder.itemView.context)
                    .data(AUTHOR_AVATAR + (this?.authorDetails?.avatarPath ?: null))
                    .target(binding.authorAvatar)
                    .build()
                imageLoader.enqueue(request)

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