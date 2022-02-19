package com.example.mvpexample.ui.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

object ViewUtils {

    fun ViewGroup.inflate(layoutRes: Int): View {
        return LayoutInflater.from(this.context).inflate(layoutRes, this, false)
    }

    inline fun RecyclerView.setPageChangeListener(
        threshold: Int,
        crossinline onNextDataLoad: () -> Unit) {
        val linearLayoutManager = this.layoutManager as? LinearLayoutManager ?: return
        addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val updatePosition = adapter!!.itemCount - threshold
                if(linearLayoutManager.findLastVisibleItemPosition() >= updatePosition) {
                    onNextDataLoad()
                    removeOnScrollListener(this)
                }
            }
        })
    }

}