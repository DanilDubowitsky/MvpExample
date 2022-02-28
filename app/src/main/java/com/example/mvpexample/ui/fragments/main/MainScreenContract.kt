package com.example.mvpexample.ui.fragments.main

import com.example.mvpexample.data.model.RemoteImageData
import com.example.mvpexample.ui.mvp.MvpContract
import com.example.mvpexample.ui.utils.simple_recycler_adapter.ISimpleRecyclerContract

interface MainScreenContract {

    interface IView : MvpContract.IView, IHolderController {
        val imagesAdapter: ImagesRecyclerAdapter
        fun addPageListener()
    }

    interface IPresenter : MvpContract.IPresenter, IHolderController {
        fun requestLoadImages()
    }

    interface ImagesRecyclerAdapter :
        ISimpleRecyclerContract.ISimpleRecyclerAdapter<ISimpleImageHolder> {
            fun getListPosition(holder: ISimpleImageHolder): Int
            fun setFooterVisibility(isVisible: Boolean)
        }

    interface ISimpleImageHolder : ISimpleRecyclerContract.ISimpleHolder {
        fun setImage(imageUrl: String)
        fun setLikesCount(likes: Int)
        fun setViewsCount(views: Int)
        fun setActionListener(onAction: (ImageHolderActions) -> Unit)
    }

    interface IHolderController : ISimpleRecyclerContract.ISimpleHolderController<ISimpleImageHolder> {
        fun onHolderAction(action: ImageHolderActions, position: Int)
    }

}