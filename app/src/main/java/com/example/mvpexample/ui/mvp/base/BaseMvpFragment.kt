package com.example.mvpexample.ui.mvp.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.mvpexample.R
import com.example.mvpexample.ui.mvp.MvpContract
import com.google.android.material.snackbar.Snackbar
import dagger.Lazy
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

abstract class BaseMvpFragment<P : MvpContract.IPresenter> : Fragment(), MvpContract.IView, HasAndroidInjector {

    protected abstract val resourceId: Int

    @Inject
    protected lateinit var lazyPresenter: Lazy<P>
    protected val presenter: P
        get() = lazyPresenter.get()

    @Inject
    protected lateinit var androidInjector: DispatchingAndroidInjector<Any?>

    override fun androidInjector(): AndroidInjector<Any?> {
        return androidInjector
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(resourceId, container, false)
    }

    override fun onResume() {
        presenter.onResume()
        super.onResume()
    }

    override fun onPause() {
        presenter.onPause()
        super.onPause()
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    override fun showError(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
    }

}