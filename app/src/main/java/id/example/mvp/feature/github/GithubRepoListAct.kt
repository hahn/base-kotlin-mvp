package id.example.mvp.feature.github

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.android.AndroidInjection
import id.example.mvp.R
import id.example.mvp.core.data.model.Repos
import id.example.mvp.feature.base.BaseMvpActivity
import javax.inject.Inject

class GithubRepoListAct : BaseMvpActivity(), GithubRepoListView {


    companion object {
        const val LOCK_ACTIVITY_KEY = "id.web.hn.features.main.GithubRepoListAct"

        fun start(context: Context) {
            context.startActivity(
                Intent(context, GithubRepoListAct::class.java))

        }

        fun startWithUsername(context: Context, user: String) {
            context.startActivity(
                Intent(context, GithubRepoListAct::class.java)
                    .putExtra("user", user)

            )
        }
    }

    @Inject lateinit var presenter: GithubRepoListPresenter
    private var user: String? = null

    override fun attachView() {
        presenter.attachView(this)
    }

    override fun detachView() {
        presenter.detachView()
    }

    override fun layoutId(): Int = R.layout.activity_github_repo_list

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        attachView()

        user = intent.getStringExtra("user")

        if (!user.isNullOrBlank()) {
            presenter.onGetRepoList(user as String)
        }
    }

    override fun showRepoList(repos: List<Repos>) {

    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun showRepoEmptyList() {

    }
}
