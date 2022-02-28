package com.example.mvpexample.ui.fragments.main

import android.util.Log
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

    private var imagesData = ArrayList<RemoteImageData>(20)
    private var imagesPage = 1

    private val footerPosition
        get() = imagesData.size

    override fun requestLoadImages() {
        if (imagesPage >= MAX_PAGES_COUNT) return
        view?.imagesAdapter?.setFooterVisibility(true)
        view?.imagesAdapter?.notifyItemChange(footerPosition)
        getImagesUseCase(imagesPage).processOnIOSubscribe(onSuccess = ::handleImagesData)
    }

    private fun handleImagesData(imagesData: List<RemoteImageData>) {
        val requireView = view ?: return
        imagesPage += 1
        this.imagesData.addAll(imagesData)
        val itemCount = requireView.imagesAdapter.dataCount
        requireView.imagesAdapter.notifyItemRangeInsert(itemCount, this.imagesData.size)
        requireView.imagesAdapter.dataCount = this.imagesData.size
        view?.imagesAdapter?.setFooterVisibility(false)
        view?.imagesAdapter?.notifyItemChange(footerPosition)
        requireView.addPageListener()
    }

    override fun bindHolder(holder: MainScreenContract.ISimpleImageHolder) {
        val holderPosition = view?.imagesAdapter?.getListPosition(holder) ?: return
        val currentItem = imagesData[holderPosition]

        holder.setImage(currentItem.imageUrl)
        holder.setLikesCount(currentItem.likes)
        holder.setViewsCount(currentItem.views)
    }

    override fun onHolderClick(holder: MainScreenContract.ISimpleImageHolder) {
        Log.e("HODLER_ACTION", "${holder.getAdapterPosition()}")
    }

    override fun onDestroy() {
        asyncDiffCalculator.release()
        super.onDestroy()
    }

    override fun onHolderAction(action: ImageHolderActions, position: Int) {
        when(action) {
            ImageHolderActions.LIKE_CLICK -> Log.e("LIKE_CLICK", "$position")
            ImageHolderActions.IMAGE_CLICK -> Log.e("IMAGE_CLICK", "$position")
        }
    }

    companion object {
        const val MAX_PAGES_COUNT = 10
    }

}