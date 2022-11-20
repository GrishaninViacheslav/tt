package io.github.grishaninvyacheslav.explorer.presentation.adapters.categories

import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import io.github.grishaninvyacheslav.core_ui.domain.repositories.IResourcesProvider
import io.github.grishaninvyacheslav.explorer.R
import io.github.grishaninvyacheslav.explorer.databinding.ItemCategoryBinding
import io.github.grishaninvyacheslav.network.data.data_entity.DisplayableItem
import io.github.grishaninvyacheslav.network.data.data_entity.ProductCategoryEntity

class CategoriesAdapterDelegate(
    private val resourcesProvider: IResourcesProvider
) {
    val adapterDelegate =
        adapterDelegateViewBinding<ProductCategoryEntity, DisplayableItem, ItemCategoryBinding>(
            { layoutInflater, root -> ItemCategoryBinding.inflate(layoutInflater, root, false) }
        ) {
            binding.root.setOnClickListener {
                onClickEvent?.invoke(item)
            }
            bind {
                if (item.isSelected) {
                    binding.backgroundImage.setColorFilter(
                        resourcesProvider.getColor(R.color.orange),
                        android.graphics.PorterDuff.Mode.MULTIPLY
                    )
                    binding.icon.setColorFilter(
                        resourcesProvider.getColor(R.color.white),
                        android.graphics.PorterDuff.Mode.MULTIPLY
                    )
                } else {
                    binding.backgroundImage.setColorFilter(
                        resourcesProvider.getColor(R.color.white),
                        android.graphics.PorterDuff.Mode.MULTIPLY
                    )
                    binding.icon.setColorFilter(
                        resourcesProvider.getColor(R.color.dark_grey),
                        android.graphics.PorterDuff.Mode.MULTIPLY
                    )
                }
                binding.title.text = item.title
                binding.icon.setImageResource(item.icon)
            }
        }

    var onClickEvent: ((ProductCategoryEntity) -> Unit)? = null
}