


package com.redline.android.myapplication

import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.redline.android.myapplication.main.MainAdapter
import com.redline.android.myapplication.main.MainViewModel
import com.redline.android.myapplication.network.JsonProperty
import com.redline.android.myapplication.overview.ApiStatus

import com.redline.android.myapplication.overview.DataAdapter

/**
 * When there is no Mars property data (data is null), hide the [RecyclerView], otherwise show it.
 */
@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<String>?) {
    val adapter = recyclerView.adapter as DataAdapter
       adapter.submitList(data)
}
@BindingAdapter("listData2")
fun bindRecyclerView2(recyclerView: RecyclerView, data: List<String>?) {
    val adapter = recyclerView.adapter as MainAdapter
    adapter.submitList(data)
}
/**
 * Uses the Glide library to load an image by URL into an [ImageView]
 */
@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        Glide.with(imgView.context)
                .load(imgUri)
                .apply(RequestOptions()
                        .placeholder(R.drawable.loading_animation)
                        .error(R.drawable.ic_broken_image))
                .into(imgView)
    }
}


@BindingAdapter("ApiStatus")
fun bindStatus(statusImageView: ImageView, status: ApiStatus?) {
    when (status) {
        ApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        ApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
             ApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
    }
}
