package id.example.mvp.core.di.module

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import id.example.mvp.BuildConfig.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import java.util.concurrent.TimeUnit.SECONDS
import javax.inject.Singleton


/**
 * Created by hahn on 25.07.19.
 * Project: BaseKotlinMvp
 */

object HttpClientConfig {

    const val CONNECT_TIMEOUT: Long = 30
    const val READ_TIMEOUT: Long = 15
    const val WRITE_TIMEOUT: Long = 15
    const val RETRY_CONNECTION_FAILURE = true
}

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun providesHttpClient(): OkHttpClient =
        OkHttpClient.Builder().apply {
            connectTimeout(HttpClientConfig.CONNECT_TIMEOUT, SECONDS)
            readTimeout(HttpClientConfig.READ_TIMEOUT, SECONDS)
            writeTimeout(HttpClientConfig.WRITE_TIMEOUT, SECONDS)
            retryOnConnectionFailure(HttpClientConfig.RETRY_CONNECTION_FAILURE)
        }.build()

    @Provides
    @Singleton
    fun providesHttpAdapter(httpClient: OkHttpClient): Retrofit =
        Retrofit.Builder().apply {
            client(httpClient)
            baseUrl(BASE_URL)
            addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            addConverterFactory(GsonConverterFactory.create())
        }.build()

    @Provides
    @Singleton
    internal fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor { message ->
            Timber.d(message)
        }.setLevel(HttpLoggingInterceptor.Level.BODY)

//    error provide this
//    @Provides
//    @Singleton
//    internal fun provideChuckInterceptor(): ChuckInterceptor = ChuckInterceptor()

    @Provides
    @Singleton
    internal fun provideStetho(): StethoInterceptor = StethoInterceptor()

    @Provides
    @Singleton
    internal fun provideGson(): Gson = GsonBuilder()
        .serializeNulls()
        .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .create()

}