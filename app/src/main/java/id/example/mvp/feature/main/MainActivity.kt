package id.example.mvp.feature.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import dagger.android.AndroidInjection
import id.example.mvp.R
import id.example.mvp.feature.base.BaseMvpActivity
import javax.inject.Inject

class MainActivity : BaseMvpActivity(), MainView {

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
//        setContentView(R.layout.activity_main)
        attachView()
    }
}
