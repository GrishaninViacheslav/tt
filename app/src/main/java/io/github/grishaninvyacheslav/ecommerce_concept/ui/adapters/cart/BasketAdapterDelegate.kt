package io.github.grishaninvyacheslav.ecommerce_concept.ui.adapters.cart

import com.github.terrakok.cicerone.Router
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.squareup.picasso.Picasso
import io.github.grishaninvyacheslav.ecommerce_concept.R
import io.github.grishaninvyacheslav.ecommerce_concept.databinding.ItemBasketBinding
import io.github.grishaninvyacheslav.ecommerce_concept.domain.entity.BasketItemEntity
import io.github.grishaninvyacheslav.ecommerce_concept.domain.models.providers.resources.IResourcesProvider
import io.github.grishaninvyacheslav.ecommerce_concept.ui.adapters.DisplayableItem
import io.github.grishaninvyacheslav.ecommerce_concept.ui.screens.IScreens
import org.koin.java.KoinJavaComponent
import java.text.NumberFormat
import java.util.*

class BasketAdapterDelegate {
    val adapterDelegate =
        adapterDelegateViewBinding<BasketItemEntity, DisplayableItem, ItemBasketBinding>(
            { layoutInflater, root -> ItemBasketBinding.inflate(layoutInflater, root, false) }
        ) {
            binding.root.setOnClickListener {
                router.navigateTo(screens.productDetails())
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

    private val resourcesProvider: IResourcesProvider by KoinJavaComponent.inject(IResourcesProvider::class.java)

    private val router: Router by KoinJavaComponent.inject(Router::class.java)
    private val screens: IScreens by KoinJavaComponent.inject(IScreens::class.java)
}