package id.example.mvp.core.data

import id.example.mvp.core.data.model.GithubUser
import id.example.mvp.core.data.model.Repos
import id.example.mvp.core.data.remote.ServiceApi
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by hahn on 25.07.19.
 * Project: BaseKotlinMvp
 */

@Singleton
class DataManager @Inject
constructor(private val api: ServiceApi,
            private val preferencesHelper: PreferencesHelper){

    fun getUsersList(): Single<List<GithubUser>> {
        return api.getUsersList()
    }

    fun getDetailUser(user: String): Single<GithubUser> {
        return api.getDetailUser(user)
    }

    fun getReposList(user: String): Single<List<Repos>> {
        return api.getReposList(user)
    }
}