package id.example.mvp.feature.base

/**
 * Created by hahn on 21.06.19.
 * Project: BaseKotlinMvp
 */

interface MvpView {
    fun showProgress(show: Boolean)

    fun showError(error: Throwable)

    fun showNoData()

    fun showToast(message: String)
}
