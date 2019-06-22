package id.web.hn.basekotlinmvp.core.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import id.web.hn.basekotlinmvp.core.di.PerFeature
import id.web.hn.basekotlinmvp.feature.main.MainActivity
import id.web.hn.basekotlinmvp.feature.main.MainModule

/**
 * Created by hahn on 22.06.19.
 * Project: BaseKotlinMvp
 */

@Module
abstract class FeatureModule {

    @PerFeature
    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun bindMainActivity(): MainActivity
}