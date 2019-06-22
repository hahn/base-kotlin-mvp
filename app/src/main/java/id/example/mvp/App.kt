package id.example.mvp

import android.app.Activity
import android.content.Context
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import com.facebook.stetho.Stetho
import com.orhanobut.hawk.Hawk
import com.squareup.leakcanary.LeakCanary
import timber.log.Timber
import javax.inject.Inject
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import id.example.mvp.core.di.component.DaggerApplicationComponent

/**
 * Created by hahn on 21.06.19.
 * Project: BaseKotlinMvp
 */
class App : MultiDexApplication(), HasActivityInjector {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()

        DaggerApplicationComponent
            .builder()
            .application(this)
            .build()
            .inject(this)

        Hawk.init(this).build()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
            Stetho.initializeWithDefaults(this)
            LeakCanary.install(this)
        } else {
            //init fabric etc
        }


    }

    override fun activityInjector(): AndroidInjector<Activity> = activityInjector

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }


}