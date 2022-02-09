package com.example.mvpexample.ui.mvp.base

import com.example.mvpexample.ui.mvp.MvpContract
import java.lang.ref.WeakReference

abstract class BaseMvpPresenter<V : MvpContract.IView>(
    view: V
) : MvpContract.IPresenter {

    private val actualView = WeakReference(view)

    private var isVisible = true

    protected val view: V?
        get() = actualView.takeIf { isVisible }?.get()

    override fun onResume() {
        isVisible = true
    }

    override fun onPause() {
        isVisible = false
    }

    override fun onDestroy() {
        actualView.clear()
    }

}