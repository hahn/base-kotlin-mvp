package id.example.mvp.core.di.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import id.example.mvp.App
import id.example.mvp.core.data.DataManager
import id.example.mvp.core.data.PreferencesHelper
import id.example.mvp.core.data.remote.ServiceApi
import id.example.mvp.core.di.module.ApiModule
import id.example.mvp.core.di.module.ApplicationModule
import id.example.mvp.core.di.module.FeatureModule
import id.example.mvp.core.di.module.NetworkModule
import javax.inject.Singleton

/**
 * Created by hahn on 21.06.19.
 * Project: BaseKotlinMvp
 */
@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    FeatureModule::class,
    ApplicationModule::class,
    NetworkModule::class,
    ApiModule::class])
interface ApplicationComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    fun inject(application: App)


    fun dataManager(): DataManager

    fun serviceApi(): ServiceApi

    fun preferencesHelper(): PreferencesHelper
}