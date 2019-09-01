package id.example.mvp.feature.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.android.AndroidInjection
import id.example.mvp.R
import id.example.mvp.core.data.model.GithubUser
import id.example.mvp.feature.base.BaseMvpActivity
import id.example.mvp.feature.github.GithubRepoListAct
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseMvpActivity(), MainView {

    val adapter = MainAdapter()

    companion object {

        const val LOCK_ACTIVITY_KEY = "id.web.hn.features.main.MainActivity"

        fun start(context: Context) {
            context.startActivity(
                Intent(context, MainActivity::class.java)
                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))

        }
    }

    @Inject lateinit var presenter: MainPresenter

    override fun attachView() {
        presenter.attachView(this)
    }

    override fun detachView() {
        presenter.detachView()
    }

    override fun layoutId(): Int= R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        attachView()
        presenter.onLoadUser()
    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun showUserList(users: List<GithubUser>) {
        adapter.apply {
            items.addAll(users)
            listener = {
                GithubRepoListAct.startWithUsername(this@MainActivity, it.login.toString())
            }
        }

        rvUsers.layoutManager = LinearLayoutManager(this)
        rvUsers.adapter = adapter

        adapter.notifyDataSetChanged()
    }

    override fun showUserEmpty() {

    }
}
