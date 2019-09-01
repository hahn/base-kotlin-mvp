package id.example.mvp.feature.main

import id.example.mvp.core.data.model.GithubUser
import id.example.mvp.feature.base.MvpView

/**
 * Created by hahn on 21.06.19.
 * Project: BaseKotlinMvp
 */
interface MainView: MvpView {

    fun showLoading()
    fun hideLoading()
    fun showUserList(users: List<GithubUser>)
    fun showUserEmpty()
}