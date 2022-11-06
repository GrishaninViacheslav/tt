package io.github.grishaninvyacheslav.ecommerce_concept.domain.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import io.github.grishaninvyacheslav.ecommerce_concept.BuildConfig
import io.github.grishaninvyacheslav.ecommerce_concept.domain.models.data_sources.IMockDataSource
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