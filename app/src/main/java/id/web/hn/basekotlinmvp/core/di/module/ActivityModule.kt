package id.web.hn.basekotlinmvp.core.di.module

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import id.web.hn.basekotlinmvp.core.di.ActivityContext
import id.web.hn.basekotlinmvp.feature.main.MainActivity

/**
 * Created by hahn on 21.06.19.
 * Project: BaseKotlinMvp
 */
@Module
 class ActivityModule(private val mActivity: AppCompatActivity) {

    @Provides
    internal fun provideActivity(): AppCompatActivity {
        return mActivity
    }

    @Provides
    @ActivityContext
    internal fun providesContext(): Context {
        return mActivity
    }


}
