package com.example.mvpexample.ui.fragments.main

import androidx.recyclerview.widget.DiffUtil
import com.example.mvpexample.data.model.RemoteImageData
import com.example.mvpexample.ui.mvp.MvpContract

interface MainScreenContract {

    interface IView : MvpContract.IView, IHolderController {
        val imagesAdapter: ImagesRecyclerAdapter
        fun showImages(list: List<RemoteImageData>)
    }

    interface IPresenter : MvpContract.IPresenter, IHolderController {
        fun requestLoadImages()
    }

    interface ImagesRecyclerAdapter {
        fun setDataCount(dataCount: Int)
        fun setDiffResult(diffResult: DiffUtil.DiffResult)
        fun notifyDataChanges()
    }

    interface ISimpleImageHolder {
        fun setImage(imageUrl: String)
        fun setLikesCount(likes: Int)
        fun setViewsCount(views: Int)
        fun getAdapterPosition(): Int
    }

    interface IHolderController {
        fun bindHolder(holder: ISimpleImageHolder)
        fun onHolderClick(holder: ISimpleImageHolder)
    }

}