package io.github.grishaninvyacheslav.core_ui.data

import android.content.Context
import androidx.core.content.ContextCompat
import io.github.grishaninvyacheslav.core_ui.domain.repositories.IResourcesProvider

class ResourcesProvider(private val context: Context): IResourcesProvider {
    override fun getString(id: Int) = context.getString(id)
    override fun getDrawable(id: Int) = ContextCompat.getDrawable(context, id)!!
    override fun getColor(id: Int) = ContextCompat.getColor(context, id)
}