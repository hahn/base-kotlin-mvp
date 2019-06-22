package id.example.mvp.feature.main

import dagger.Module
import dagger.Provides
import id.example.mvp.core.di.PerFeature

/**
 * Created by hahn on 22.06.19.
 * Project: BaseKotlinMvp
 */

@Module
class MainModule {

    @PerFeature
    @Provides
    fun providesMainPresenter(): MainPresenter = MainPresenter()
}