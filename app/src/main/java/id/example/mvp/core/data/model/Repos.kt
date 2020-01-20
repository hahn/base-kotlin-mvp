package id.example.mvp.core.data.model

import com.google.gson.annotations.SerializedName

/**
 * Created by hahn on 25.07.19.
 * Project: BaseKotlinMvp
 */
data class Repos(
    @SerializedName("id")
    var id: Int? = null,

    @SerializedName("name")
    var name: String? = null,

    @SerializedName("description")
    var description: String? = null,

    @SerializedName("url")
    var url: String? = null,

    @SerializedName("message")
    var message: String? = null
)
