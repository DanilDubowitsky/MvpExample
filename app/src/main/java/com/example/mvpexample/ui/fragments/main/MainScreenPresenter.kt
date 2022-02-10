package com.example.mvpexample.ui.fragments.main

import com.example.mvpexample.data.model.RemoteImageData
import com.example.mvpexample.data.usecase.GetImagesUseCase
import com.example.mvpexample.ui.mvp.base.BaseRequestPresenter
import com.example.mvpexample.ui.utils.AsyncDiffUtillCalculator
import javax.inject.Inject

class MainScreenPresenter @Inject constructor(
    view: MainScreenContract.IView,
    private val getImagesUseCase: GetImagesUseCase,
    private val asyncDiffCalculator: AsyncDiffUtillCalculator
) : BaseRequestPresenter<MainScreenContract.IView>(view),
    MainScreenContract.IPresenter {

    private var imagesData = emptyList<RemoteImageData>()

    override fun requestLoadImages() {
        getImagesUseCase().processOnIOSubscribe(onSuccess = ::handleImagesData)
    }

    private fun handleImagesData(imagesData: List<RemoteImageData>) {
        val diffUtill = ImagesDiffUtill(this.imagesData, imagesData)
        asyncDiffCalculator.calculateDiff(diffUtill) { diffResult ->
            this.imagesData = imagesData
            view?.imagesAdapter?.setDiffResult(diffResult)
            view?.imagesAdapter?.dataCount = imagesData.size
        }
    }

    override fun bindHolder(holder: MainScreenContract.ISimpleImageHolder) {
        val currentItem = imagesData[holder.getAdapterPosition()]
        holder.setImage(currentItem.imageUrl)
        holder.setLikesCount(currentItem.likes)
        holder.setViewsCount(currentItem.views)
    }

    override fun onHolderClick(holder: MainScreenContract.ISimpleImageHolder) {}

    override fun onDestroy() {
        asyncDiffCalculator.release()
        super.onDestroy()
    }

}