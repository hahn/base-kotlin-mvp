package id.example.mvp.feature.github

import dagger.Module
import dagger.Provides
import id.example.mvp.core.data.DataManager
import id.example.mvp.core.data.PreferencesHelper
import id.example.mvp.core.di.PerFeature

/**
 * Created by hahn on 26.07.19.
 * Project: BaseKotlinMvp
 */

@Module
class GithubRepoListModule {

    @PerFeature
    @Provides
    fun provideGithubRepoListPresenter(dataManager: DataManager, preferencesHelper: PreferencesHelper):
            GithubRepoListPresenter = GithubRepoListPresenter(dataManager, preferencesHelper)
}