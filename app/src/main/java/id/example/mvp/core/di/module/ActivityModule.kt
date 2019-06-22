package id.example.mvp.core.di.module

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import dagger.Module
import dagger.Provides
import id.example.mvp.core.di.ActivityContext

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
