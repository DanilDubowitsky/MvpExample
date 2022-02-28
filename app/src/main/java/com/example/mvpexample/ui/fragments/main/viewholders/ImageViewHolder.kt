package com.example.mvpexample.ui.fragments.main.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.mvpexample.databinding.ViewHolderSimpleImageBinding
import com.example.mvpexample.ui.fragments.main.ImageHolderActions
import com.example.mvpexample.ui.fragments.main.MainScreenContract

class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
    MainScreenContract.ISimpleImageHolder {

    private val binding by viewBinding(ViewHolderSimpleImageBinding::bind)

    override fun setImage(imageUrl: String) {
        Glide.with(binding.image)
            .load(imageUrl)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .centerCrop()
            .into(binding.image)
    }

    override fun setLikesCount(likes: Int) {
        binding.likesCount.text = likes.toString()
    }

    override fun setViewsCount(views: Int) {
        binding.viewCount.text = views.toString()
    }

    override fun setActionListener(onAction: (ImageHolderActions) -> Unit) {
        binding.image.setOnClickListener {
            onAction(ImageHolderActions.IMAGE_CLICK)
        }

        binding.icLike.setOnClickListener {
            onAction(ImageHolderActions.LIKE_CLICK)
        }
    }

}