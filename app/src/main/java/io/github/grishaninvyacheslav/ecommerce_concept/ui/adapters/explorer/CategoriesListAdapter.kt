package io.github.grishaninvyacheslav.ecommerce_concept.ui.adapters.explorer

import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import io.github.grishaninvyacheslav.ecommerce_concept.R
import io.github.grishaninvyacheslav.ecommerce_concept.databinding.ItemCategoryBinding
import io.github.grishaninvyacheslav.ecommerce_concept.domain.entity.ProductCategoryEntity
import io.github.grishaninvyacheslav.ecommerce_concept.domain.models.providers.resources.IResourcesProvider
import io.github.grishaninvyacheslav.ecommerce_concept.ui.adapters.DisplayableItem
import org.koin.core.component.KoinComponent
import org.koin.java.KoinJavaComponent

class CategoriesAdapterDelegate(onClickEvent: (ProductCategoryEntity) -> Unit) : KoinComponent {
    val adapterDelegate =
        adapterDelegateViewBinding<ProductCategoryEntity, DisplayableItem, ItemCategoryBinding>(
            { layoutInflater, root -> ItemCategoryBinding.inflate(layoutInflater, root, false) }
        ) {
            binding.root.setOnClickListener {
                onClickEvent(item)
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

    private val resourcesProvider: IResourcesProvider by KoinJavaComponent.inject(IResourcesProvider::class.java)
}