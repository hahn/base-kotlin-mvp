package id.example.mvp.feature.usefragment

import android.os.Bundle
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import id.example.mvp.R
import id.example.mvp.feature.base.BaseMvpActivity
import javax.inject.Inject

class SampleActivity : BaseMvpActivity(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>


    override fun attachView() {

    }

    override fun detachView() {

    }

    override fun layoutId(): Int = R.layout.activity_sample

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector
}
