package com.example.mvpexample.ui.fragments.main

import androidx.recyclerview.widget.DiffUtil
import com.example.mvpexample.data.model.RemoteImageData

class ImagesDiffUtill(
    private val oldData: List<RemoteImageData>,
    private val newData: List<RemoteImageData>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldData.size

    override fun getNewListSize(): Int = newData.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldData[oldItemPosition]
        val newItem = newData[newItemPosition]
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldData[oldItemPosition]
        val newItem = newData[newItemPosition]
        return oldItem.likes == newItem.likes
                && oldItem.views == newItem.views
                && oldItem.imageUrl == newItem.imageUrl
    }

}