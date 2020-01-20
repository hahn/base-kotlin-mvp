package id.example.mvp.feature.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import java.util.concurrent.atomic.AtomicLong

/**
 * Created by hahn on 21.06.19.
 * Project: BaseKotlinMvp
 */

abstract class BaseFragment : Fragment() {

    private var mFragmentId: Long = 0

    companion object {

        private val KEY_FRAGMENT_ID = "KEY_FRAGMENT_ID"
        //        private val sComponentsArray = LongSparseArray<ConfigPersistentComponent>()
        private val NEXT_ID = AtomicLong(0)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(layoutId(), container, false)
//        ButterKnife.bind(this, view)
        return view
    }

    @LayoutRes
    abstract fun layoutId(): Int

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putLong(KEY_FRAGMENT_ID, mFragmentId)
    }

    override fun onDestroy() {
//        if (!activity!!.isChangingConfigurations) {
//            Timber.i("Clearing ConfigPersistentComponent id=%d", mFragmentId)
//            sComponentsArray.remove(mFragmentId)
//        }
        super.onDestroy()
    }

//    fun fragmentComponent() = mFragmentComponent
}
