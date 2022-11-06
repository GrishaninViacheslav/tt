package io.github.grishaninvyacheslav.ecommerce_concept.ui.screens

import com.github.terrakok.cicerone.Screen

interface IScreens {
    fun explorer(): Screen
    fun productDetails(): Screen
    fun cart(): Screen
}