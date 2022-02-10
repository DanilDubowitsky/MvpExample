package com.example.mvpexample.ui.utils

import androidx.recyclerview.widget.DiffUtil
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class AsyncDiffUtillCalculator @Inject constructor() {

    private var disposable: Disposable? = null

    fun calculateDiff(
        diffCallBack: DiffUtil.Callback,
        onSuccess: (DiffUtil.DiffResult) -> Unit) {
        disposable = Single.create<DiffUtil.DiffResult> { emitter ->
            val result = DiffUtil.calculateDiff(diffCallBack)
            emitter.onSuccess(result)
        }
         .subscribeOn(Schedulers.computation())
         .observeOn(AndroidSchedulers.mainThread())
         .subscribe(onSuccess)
    }

    fun release() {
        disposable?.dispose()
    }

}