package io.github.grishaninvyacheslav.ecommerce_concept.domain.models.providers.resources

import android.graphics.drawable.Drawable

interface IResourcesProvider {
    fun getString(id: Int): String
    fun getDrawable(id: Int): Drawable
    fun getColor(id: Int): Int
}