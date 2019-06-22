package id.example.mvp.core.di.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import id.example.mvp.App
import id.example.mvp.core.di.module.ApplicationModule
import id.example.mvp.core.di.module.FeatureModule
import javax.inject.Singleton

/**
 * Created by hahn on 21.06.19.
 * Project: BaseKotlinMvp
 */
@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    FeatureModule::class,
    ApplicationModule::class])
interface ApplicationComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    fun inject(application: App)
}