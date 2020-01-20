package id.example.mvp.feature.usefragment

import android.content.Context
import androidx.fragment.app.Fragment
import dagger.android.support.AndroidSupportInjection
import id.example.mvp.R
import id.example.mvp.feature.base.BaseMvpFragment

/**
 * A simple [Fragment] subclass.
 *
 */
class SampleFragment : BaseMvpFragment() {

    override fun attachView() {
    }

    override fun detachPresenter() {
    }

    override fun layoutId(): Int = R.layout.fragment_sample

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }
}
