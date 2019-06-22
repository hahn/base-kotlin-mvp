package id.example.mvp.core.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import id.example.mvp.core.di.PerFeature
import id.example.mvp.feature.main.MainActivity
import id.example.mvp.feature.main.MainModule

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