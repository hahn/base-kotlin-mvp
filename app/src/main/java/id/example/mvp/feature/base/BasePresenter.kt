package id.example.mvp.feature.base

import id.example.mvp.core.ext.DisposableManager
import io.reactivex.disposables.Disposable

/**
 * Created by hahn on 21.06.19.
 * Project: BaseKotlinMvp
 */

open class BasePresenter<T : MvpView> : Presenter<T> {

    var mvpView: T? = null

    override fun attachView(mvpView: T) {
        this.mvpView = mvpView
    }

    override fun detachView() {
        mvpView = null
        DisposableManager.dispose()
    }

    private val isViewAttached: Boolean
        get() = mvpView != null

    fun checkViewAttached() {
        if (!isViewAttached) throw MvpViewNotAttachedException()
    }

    fun addDisposable(disposable: Disposable) {
        DisposableManager.add(disposable)
    }

    private class MvpViewNotAttachedException internal constructor() : RuntimeException("Please call Presenter.attachView(MvpView) before requesting baseData to the Presenter")
}
