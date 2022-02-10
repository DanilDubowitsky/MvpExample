package com.example.mvpexample.ui.fragments.main

import androidx.recyclerview.widget.DiffUtil
import com.example.mvpexample.data.model.RemoteImageData
import com.example.mvpexample.data.usecase.GetImagesUseCase
import com.example.mvpexample.ui.mvp.base.BaseRequestPresenter
import javax.inject.Inject

class MainScreenPresenter @Inject constructor(
    view: MainScreenContract.IView,
    private val getImagesUseCase: GetImagesUseCase
) : BaseRequestPresenter<MainScreenContract.IView>(view),
    MainScreenContract.IPresenter {

    private var imagesData = emptyList<RemoteImageData>()

    override fun requestLoadImages() {
        getImagesUseCase.invoke().processOnIOSubscribe(onSuccess = ::handleImagesData)
    }

    private fun handleImagesData(imagesData: List<RemoteImageData>) {
        val diffUtill = ImagesDiffUtill(this.imagesData, imagesData)
        val diffResult = DiffUtil.calculateDiff(diffUtill)
        this.imagesData = imagesData
        view?.imagesAdapter?.setDiffResult(diffResult)
        view?.imagesAdapter?.dataCount = imagesData.size
    }

    override fun bindHolder(holder: MainScreenContract.ISimpleImageHolder) {
        val currentItem = imagesData[holder.getAdapterPosition()]
        holder.setImage(currentItem.imageUrl)
        holder.setLikesCount(currentItem.likes)
        holder.setViewsCount(currentItem.views)
    }

    override fun onHolderClick(holder: MainScreenContract.ISimpleImageHolder) {

    }

}