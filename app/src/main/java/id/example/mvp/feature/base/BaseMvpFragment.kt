package id.example.mvp.feature.base

import id.example.mvp.core.ext.toast

/**
 * Created by hahn on 21.06.19.
 * Project: BaseKotlinMvp
 */

abstract class BaseMvpFragment : BaseFragment(), MvpView {

    protected abstract fun attachView()

    protected abstract fun detachPresenter()

    override fun onDestroy() {
        super.onDestroy()
        detachPresenter()
    }

    override fun showProgress(show: Boolean) {
    }

    override fun showError(error: Throwable) {
    }

    override fun showNoData() {
    }

    override fun showToast(message: String) {
        context?.toast(message)
    }
}
