package id.example.mvp.core.data.model

import com.google.gson.annotations.SerializedName

/**
 * Created by hahn on 25.07.19.
 * Project: BaseKotlinMvp
 */
data class GithubUser(

    @SerializedName("login")
    var login: String? = null,

    @SerializedName("id")
    var id: Int? = null,

    @SerializedName("avatar_url")
    var avatarUrl: String? = null,

    @SerializedName("url")
    var url: String? = null,

    @SerializedName("html_url")
    var htmlUrl: String? = null,

    @SerializedName("type")
    var type: String? = null,

    @SerializedName("name")
    var name: String? = null,

    @SerializedName("location")
    var location: String? = null,

    @SerializedName("bio")
    var bio: String? = null

)