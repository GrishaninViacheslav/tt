package io.github.grishaninvyacheslav.ecommerce_concept

import android.app.Application
import io.github.grishaninvyacheslav.ecommerce_concept.domain.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class EcommerceConceptApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@EcommerceConceptApp)
            modules(navigationModule, viewModelsModule, modelModule, apiModule)
        }
    }
}