package com.example.mvpexample.ui.mvp.base

import com.example.mvpexample.ui.fragments.main.MainScreenContract
import com.example.mvpexample.ui.mvp.MvpContract
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.DisposableContainer
import io.reactivex.rxjava3.schedulers.Schedulers

abstract class BaseRequestPresenter<V : MvpContract.IView>(
    view: V
) : BaseMvpPresenter<V>(view) {

    private val disposeBag: CompositeDisposable by lazy { CompositeDisposable() }

    protected fun handleThrowable(throwable: Throwable) {
        view?.showError(throwable.message!!)
    }

    protected fun <T> Single<T>.processOnIOSubscribe(
        onError: (Throwable) -> Unit = ::handleThrowable,
        onSuccess: (T) -> Unit
    ) {
        val disposable = this.observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(
                onSuccess,
                onError
            )
        disposeBag.add(disposable)
    }

    protected fun <T> Flowable<T>.processOnIOSubscribe(
        onError: (Throwable) -> Unit = ::handleThrowable,
        onSuccess: (T) -> Unit
    ) {
        val disposable = this.observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(
                onSuccess,
                onError
            )
        disposeBag.add(disposable)
    }

    override fun onDestroy() {
        disposeBag.clear()
        super.onDestroy()
    }

}