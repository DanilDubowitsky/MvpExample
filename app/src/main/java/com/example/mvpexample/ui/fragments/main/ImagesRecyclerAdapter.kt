package com.example.mvpexample.ui.fragments.main

import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.mvpexample.R
import com.example.mvpexample.ui.fragments.main.viewholders.FooterImageLoadingHolder
import com.example.mvpexample.ui.fragments.main.viewholders.ImageViewHolder
import com.example.mvpexample.ui.utils.ViewUtils.inflate
import com.example.mvpexample.ui.utils.simple_recycler_adapter.SimpleRecyclerAdapter
import javax.inject.Inject

class ImagesRecyclerAdapter @Inject constructor(
    private val holderController: MainScreenContract.IHolderController
) : SimpleRecyclerAdapter<MainScreenContract.ISimpleImageHolder>(holderController),
    MainScreenContract.ImagesRecyclerAdapter {

    private var isHeaderVisible = true

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType) {
            IMAGE_VIEW_TYPE -> ImageViewHolder(parent.inflate(R.layout.view_holder_simple_image))
            FOOTER_VIEW_TYPE -> FooterImageLoadingHolder(parent.inflate(R.layout.view_holder_footer_loading))
            else -> throw IllegalArgumentException()
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is FooterImageLoadingHolder) {
            holder.itemView.isVisible = isHeaderVisible
        }
        if(holder is MainScreenContract.ISimpleImageHolder) {
            holder.setActionListener { action ->
                holderController.onHolderAction(action, position)
            }
        }
        super.onBindViewHolder(holder, position)
    }

    override fun getItemCount(): Int = dataCount + FOOTER_COUNTER

    override fun getItemViewType(position: Int): Int {
        return if(position == dataCount) FOOTER_VIEW_TYPE
         else IMAGE_VIEW_TYPE
    }

    override fun notifyItemRangeInsert(position: Int, itemCount: Int) {
        super.notifyItemRangeInsert(position + FOOTER_COUNTER, itemCount)
    }

    override fun getListPosition(holder: MainScreenContract.ISimpleImageHolder): Int =
        holder.getAdapterPosition()

    override fun setFooterVisibility(isVisible: Boolean) {
        isHeaderVisible = isVisible
    }

    companion object {
        const val IMAGE_VIEW_TYPE = 0
        const val FOOTER_VIEW_TYPE = 1
        const val FOOTER_COUNTER = 1
    }

}