package com.example.mvpexample.ui.mvp

interface MvpContract {

    interface IView {
        fun showError(message: String)
    }

    interface IPresenter {
        fun onResume()
        fun onPause()
        fun onDestroy()
    }

}