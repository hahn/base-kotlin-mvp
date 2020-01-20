package id.example.mvp.core.data

import com.orhanobut.hawk.Hawk
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by hahn on 25.07.19.
 * Project: BaseKotlinMvp
 */

@Singleton
class PreferencesHelper @Inject constructor() {
    companion object {
        const val KEY_USERNAME = "username"
        const val KEY_PASSWORD = "password"
    }

    fun saveUsername(username: String) {
        Hawk.put(KEY_USERNAME, username)
    }

    fun savePassword(password: String) {
        Hawk.put(KEY_PASSWORD, password)
    }

    fun getUsername(): String? = Hawk.get(KEY_USERNAME)

    fun getPassword(): String? = Hawk.get(KEY_PASSWORD)
}
