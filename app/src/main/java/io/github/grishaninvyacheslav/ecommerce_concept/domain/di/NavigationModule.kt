package io.github.grishaninvyacheslav.ecommerce_concept.domain.di

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import io.github.grishaninvyacheslav.ecommerce_concept.ui.screens.IScreens
import io.github.grishaninvyacheslav.ecommerce_concept.ui.screens.Screens
import org.koin.dsl.module

val navigationModule = module {
    single { provideCicerone() }
    single { provideRouter(get()) }
    single { provideNavigatorHolder(get()) }
    single { provideScreens() }
}

fun provideCicerone(): Cicerone<Router> = Cicerone.create()
fun provideRouter(cicerone: Cicerone<Router>): Router = cicerone.router
fun provideNavigatorHolder(cicerone: Cicerone<Router>) = cicerone.getNavigatorHolder()
fun provideScreens(): IScreens = Screens()