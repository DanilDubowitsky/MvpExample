package com.example.mvpexample.ui.fragments.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.mvpexample.R
import com.example.mvpexample.data.model.RemoteImageData
import javax.inject.Inject

class ImagesRecyclerAdapter @Inject constructor(
    private val holderController: MainScreenContract.IHolderController
) : RecyclerView.Adapter<ImageViewHolder>(), MainScreenContract.ImagesRecyclerAdapter {

    private var dataCount = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_simple_image, parent, false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holderController.bindHolder(holder)
        holder.itemView.setOnClickListener {
            holderController.onHolderClick(holder)
        }
    }

    override fun getItemCount(): Int = dataCount

    override fun setDataCount(dataCount: Int) {
        this.dataCount = dataCount
    }

    override fun setDiffResult(diffResult: DiffUtil.DiffResult) {
        diffResult.dispatchUpdatesTo(this)
    }

    override fun notifyDataChanges() {
        notifyDataSetChanged()
    }

}