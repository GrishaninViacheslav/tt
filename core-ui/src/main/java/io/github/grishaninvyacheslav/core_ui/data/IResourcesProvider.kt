package io.github.grishaninvyacheslav.core_ui.data

import android.graphics.drawable.Drawable

interface IResourcesProvider {
    fun getString(id: Int): String
    fun getDrawable(id: Int): Drawable
    fun getColor(id: Int): Int
}