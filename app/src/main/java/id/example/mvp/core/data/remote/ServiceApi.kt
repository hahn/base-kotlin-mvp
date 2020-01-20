package id.example.mvp.core.data.remote

import id.example.mvp.core.data.model.GithubUser
import id.example.mvp.core.data.model.Repos
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by hahn on 25.07.19.
 * Project: BaseKotlinMvp
 */
interface ServiceApi {

    @GET("users")
    fun getUsersList(): Single<List<GithubUser>>

    @GET("users/{user}")
    fun getDetailUser(
        @Path("user") user: String
    ): Single<GithubUser>

    @GET("users/{user}/repos")
    fun getReposList(
        @Path("user") user: String
    ): Single<List<Repos>>
}
