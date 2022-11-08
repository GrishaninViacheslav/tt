package io.github.grishaninvyacheslav.network.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import io.github.grishaninvyacheslav.network.BuildConfig
import io.github.grishaninvyacheslav.network.data.data_sources.IMockDataSource
import okhttp3.OkHttpClient
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val apiModule = module {
    single(named("baseUrl")) { provideBaseUrl() }
    single { provideMockApi(get(named("baseUrl")), get()) }
    single { provideGson() }
}

fun provideBaseUrl(): String = BuildConfig.API_URL

fun provideMockApi(
    baseUrl: String,
    gson: Gson
): IMockDataSource {
    val client = OkHttpClient.Builder()
        .build()

    return Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(client)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
        .create(IMockDataSource::class.java)
}

fun provideGson(): Gson = GsonBuilder().create()