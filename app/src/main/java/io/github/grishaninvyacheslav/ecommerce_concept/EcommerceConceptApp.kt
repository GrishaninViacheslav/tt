package io.github.grishaninvyacheslav.ecommerce_concept

import android.app.Application
import io.github.grishaninvyacheslav.cart.di.cartUseCasesModule
import io.github.grishaninvyacheslav.cart.di.cartViewModelsModule
import io.github.grishaninvyacheslav.cart.di.cartModelsModule
import io.github.grishaninvyacheslav.core_ui.di.coreModelsModule
import io.github.grishaninvyacheslav.explorer.di.explorerUseCasesModule
import io.github.grishaninvyacheslav.explorer.di.explorerViewModelsModule
import io.github.grishaninvyacheslav.explorer.di.explorerModelsModule
import io.github.grishaninvyacheslav.ecommerce_concept.di.mainViewModelsModule
import io.github.grishaninvyacheslav.network.di.apiModule
import io.github.grishaninvyacheslav.navigation.di.navigationModule
import io.github.grishaninvyacheslav.product_details.di.productDetailsUseCasesModule
import io.github.grishaninvyacheslav.product_details.di.productDetailsViewModelsModule
import io.github.grishaninvyacheslav.product_details.di.productModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class EcommerceConceptApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@EcommerceConceptApp)
            modules(
                mainViewModelsModule,

                explorerViewModelsModule,
                explorerUseCasesModule,
                explorerModelsModule,

                productDetailsViewModelsModule,
                productDetailsUseCasesModule,
                productModelsModule,

                cartViewModelsModule,
                cartUseCasesModule,
                cartModelsModule,

                coreModelsModule,
                navigationModule,
                apiModule,
            )
        }
    }
}