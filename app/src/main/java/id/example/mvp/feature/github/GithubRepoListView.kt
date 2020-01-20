package id.example.mvp.feature.github

import id.example.mvp.core.data.model.Repos
import id.example.mvp.feature.base.MvpView

/**
 * Created by hahn on 26.07.19.
 * Project: BaseKotlinMvp
 */
interface GithubRepoListView : MvpView {

    fun showRepoList(repos: List<Repos>)
    fun showLoading()
    fun hideLoading()
    fun showRepoEmptyList()
}
