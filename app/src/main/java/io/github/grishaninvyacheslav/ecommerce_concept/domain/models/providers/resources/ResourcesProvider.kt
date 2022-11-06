package io.github.grishaninvyacheslav.ecommerce_concept.domain.models.providers.resources

import android.content.Context
import androidx.core.content.ContextCompat

class ResourcesProvider(private val context: Context): IResourcesProvider {
    override fun getString(id: Int) = context.getString(id)
    override fun getDrawable(id: Int) = ContextCompat.getDrawable(context, id)!!
    override fun getColor(id: Int) = ContextCompat.getColor(context, id)
}