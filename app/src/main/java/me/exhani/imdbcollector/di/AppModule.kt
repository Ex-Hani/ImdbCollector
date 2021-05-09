package me.exhani.imdbcollector.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.exhani.imdbcollector.model.di.MovieRepository
import me.exhani.imdbcollector.model.di.MovieRepositoryImpl
import me.exhani.imdbcollector.model.server.ApiClient
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient =
        with(OkHttpClient.Builder()) {
            val cTimeout = 30L
            val rTimeout = 30L

            connectTimeout(cTimeout, TimeUnit.SECONDS)
            readTimeout(rTimeout, TimeUnit.SECONDS)


            addNetworkInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })

            build()
        }

    @Singleton
    @Provides
    fun provideApiService(httpClient: OkHttpClient): ApiClient {
        return Retrofit.Builder()
            .client(httpClient)
            .baseUrl("https://imdb-api.com/en/API/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiClient::class.java)
    }

    @Singleton
    @Provides
    fun provideMovieRepository(
        apiClient: ApiClient
    ): MovieRepository {
        return MovieRepositoryImpl(apiClient)
    }
}