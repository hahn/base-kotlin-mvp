package id.example.mvp.core.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import id.example.mvp.core.di.PerFeature
import id.example.mvp.feature.github.GithubRepoListAct
import id.example.mvp.feature.github.GithubRepoListModule
import id.example.mvp.feature.main.MainActivity
import id.example.mvp.feature.main.MainModule
import id.example.mvp.feature.usefragment.SampleActivity
import id.example.mvp.feature.usefragment.SampleFragment

/**
 * Created by hahn on 22.06.19.
 * Project: BaseKotlinMvp
 */

@Module
abstract class FeatureModule {

    @PerFeature
    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun bindMainActivity(): MainActivity

    @PerFeature
    @ContributesAndroidInjector(modules = [GithubRepoListModule::class])
    abstract fun bindGithubRepoListAct(): GithubRepoListAct

    @PerFeature
    @ContributesAndroidInjector
    abstract fun bindSampleActivity(): SampleActivity

    @PerFeature
    @ContributesAndroidInjector
    abstract fun bindSampleFragment(): SampleFragment
}