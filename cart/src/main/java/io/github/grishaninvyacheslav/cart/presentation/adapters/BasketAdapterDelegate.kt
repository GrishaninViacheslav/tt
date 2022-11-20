package io.github.grishaninvyacheslav.cart.presentation.adapters

import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.squareup.picasso.Picasso
import io.github.grishaninvyacheslav.cart.R
import io.github.grishaninvyacheslav.cart.databinding.ItemBasketBinding
import io.github.grishaninvyacheslav.core_ui.domain.repositories.IResourcesProvider
import io.github.grishaninvyacheslav.navigation.domain.use_cases.NavigateToProductDetailsUseCase
import io.github.grishaninvyacheslav.network.data.data_entity.DisplayableItem
import io.github.grishaninvyacheslav.network.data.data_entity.cart.BasketItemEntity
import java.text.NumberFormat
import java.util.*

class BasketAdapterDelegate(
    private val resourcesProvider: IResourcesProvider,
    private val navigateToProductDetailsUseCase: NavigateToProductDetailsUseCase
) {
    val adapterDelegate =
        adapterDelegateViewBinding<BasketItemEntity, DisplayableItem, ItemBasketBinding>(
            { layoutInflater, root -> ItemBasketBinding.inflate(layoutInflater, root, false) }
        ) {
            binding.root.setOnClickListener {
                navigateToProductDetailsUseCase()
            }
            bind {
                Picasso.get()
                    .load(item.images).into(binding.previewImage)
                binding.name.text = item.title
                binding.price.text = String.format(
                    resourcesProvider.getString(R.string.price_format_string),
                    NumberFormat.getNumberInstance(Locale.US).format(item.price)
                )
            }
        }
}