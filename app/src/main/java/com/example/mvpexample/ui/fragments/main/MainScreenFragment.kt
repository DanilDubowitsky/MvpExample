package com.example.mvpexample.ui.fragments.main

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.ethanhua.skeleton.RecyclerViewSkeletonScreen
import com.ethanhua.skeleton.Skeleton
import com.example.mvpexample.R
import com.example.mvpexample.databinding.FragmentMainScreenBinding
import com.example.mvpexample.ui.mvp.base.BaseMvpFragment
import javax.inject.Inject

class MainScreenFragment : BaseMvpFragment<MainScreenContract.IPresenter>(), MainScreenContract.IView {

    override val resourceId: Int = R.layout.fragment_main_screen

    private val binding by viewBinding(FragmentMainScreenBinding::bind)

    @Inject
    override lateinit var imagesAdapter: MainScreenContract.ImagesRecyclerAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.setupRecycler()
        presenter.requestLoadImages()
    }

    private fun setupRecycler() {
        binding.imagesRecycler.adapter = imagesAdapter as RecyclerView.Adapter<*>
    }

    override fun bindHolder(holder: MainScreenContract.ISimpleImageHolder) {
        presenter.bindHolder(holder)
    }

    override fun onHolderClick(holder: MainScreenContract.ISimpleImageHolder) {
        presenter.onHolderClick(holder)
    }

}