package id.example.mvp.feature.base

import android.content.Context
import android.os.Bundle
import android.view.MenuItem
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import id.example.mvp.R
import id.example.mvp.core.ext.Tools
import java.util.concurrent.atomic.AtomicLong

/**
 * Created by hahn on 21.06.19.
 * Project: BaseKotlinMvp
 */

abstract class BaseActivity : AppCompatActivity() {

    private var mActivityId: Long = 0
    protected lateinit var context: Context

    companion object {

        private val KEY_ACTIVITY_ID = "KEY_ACTIVITY_ID"
        private val NEXT_ID = AtomicLong(0)
//        private val sComponentsArray = LongSparseArray<ConfigPersistentComponent>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId())
    }

    @LayoutRes
    abstract fun layoutId(): Int

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putLong(KEY_ACTIVITY_ID, mActivityId)
    }

    override fun onDestroy() {
//        if (!isChangingConfigurations) {
//            Timber.i("Clearing ConfigPersistentComponent id=%d", mActivityId)
//            sComponentsArray.remove(mActivityId)
//        }
        super.onDestroy()
    }

    fun initToolbar(toolbar: Toolbar, transparent: Boolean = true) {
        setSupportActionBar(toolbar)
        when (transparent) {
            true -> Tools().setSystemBarColor(this, android.R.color.transparent)
            else -> Tools().setSystemBarColor(this, R.color.grey_20)
        }
    }

    fun initToolbar(toolbar: Toolbar, title: String) {
        initToolbar(toolbar)
        setTitle(title)
    }

    fun initToolbar(toolbar: Toolbar, title: String, showHome: Boolean, transparent: Boolean = false) {
        initToolbar(toolbar, transparent)
        setTitle(title)
        showHome(showHome)
    }

    fun setTitle(title: String) {
        supportActionBar?.title = title
    }

    fun showHome(show: Boolean) {
        supportActionBar?.setDisplayHomeAsUpEnabled(show)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}
