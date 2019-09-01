package id.example.mvp.feature.main

import id.example.mvp.core.data.DataManager
import id.example.mvp.core.ext.rx.SchedulerUtils
import id.example.mvp.feature.base.BasePresenter
import javax.inject.Inject

/**
 * Created by hahn on 22.06.19.
 * Project: BaseKotlinMvp
 */
class MainPresenter @Inject constructor(
    private val dataManager: DataManager) : BasePresenter<MainView>() {

    fun onLoadUser() {

        checkViewAttached()
        mvpView?.showLoading()
        addDisposable(
            dataManager.getUsersList()
                .compose(SchedulerUtils.ioToMain())
                .doFinally { mvpView?.hideLoading() }
                .subscribe({
                    mvpView?.showUserList(it)
                }, {
                    it.printStackTrace()
                    mvpView?.showUserEmpty()
                })
        )
    }
}