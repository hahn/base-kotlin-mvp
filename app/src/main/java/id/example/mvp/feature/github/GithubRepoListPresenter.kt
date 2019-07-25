package id.example.mvp.feature.github

import id.example.mvp.core.data.DataManager
import id.example.mvp.core.data.PreferencesHelper
import id.example.mvp.core.ext.rx.SchedulerUtils
import id.example.mvp.feature.base.BasePresenter
import javax.inject.Inject

/**
 * Created by hahn on 26.07.19.
 * Project: BaseKotlinMvp
 */
class GithubRepoListPresenter @Inject constructor(private val dataManager: DataManager,
                                                  private val preferencesHelper: PreferencesHelper): BasePresenter<GithubRepoListView>() {

    fun onGetRepoList(user: String) {

        checkViewAttached()
        mvpView?.showLoading()
        addDisposable(
            dataManager.getReposList(user)
                .compose(SchedulerUtils.ioToMain())
                .doFinally { mvpView?.hideLoading() }
                .subscribe({
                    mvpView?.showRepoList(it)
                }, {
                    it.printStackTrace()
                    mvpView?.showRepoEmptyList()
                })
        )
    }

}