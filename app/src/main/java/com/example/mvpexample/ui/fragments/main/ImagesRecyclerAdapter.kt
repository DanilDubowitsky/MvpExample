package com.example.mvpexample.ui.fragments.main

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.mvpexample.R
import com.example.mvpexample.ui.utils.simple_recycler_adapter.SimpleRecyclerAdapter
import javax.inject.Inject

class ImagesRecyclerAdapter @Inject constructor(
    holderController: MainScreenContract.IHolderController
) : SimpleRecyclerAdapter<MainScreenContract.ISimpleImageHolder>(holderController),
    MainScreenContract.ImagesRecyclerAdapter {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_simple_image, parent, false)
        return ImageViewHolder(view)
    }

    override fun getItemCount(): Int = dataCount

}