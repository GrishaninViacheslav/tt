package io.github.grishaninvyacheslav.ecommerce_concept.ui.adapters.explorer

import android.graphics.Paint
import androidx.core.view.isVisible
import com.github.terrakok.cicerone.Router
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.squareup.picasso.Picasso
import io.github.grishaninvyacheslav.ecommerce_concept.R
import io.github.grishaninvyacheslav.ecommerce_concept.databinding.ItemBestSellersPageBinding
import io.github.grishaninvyacheslav.ecommerce_concept.domain.entity.BestSellerEntity
import io.github.grishaninvyacheslav.ecommerce_concept.domain.entity.BestSellerPageEntity
import io.github.grishaninvyacheslav.ecommerce_concept.domain.models.providers.resources.IResourcesProvider
import io.github.grishaninvyacheslav.ecommerce_concept.ui.adapters.DisplayableItem
import io.github.grishaninvyacheslav.ecommerce_concept.ui.custom_views.BestSellerItem
import io.github.grishaninvyacheslav.ecommerce_concept.ui.screens.IScreens
import org.koin.java.KoinJavaComponent
import java.text.NumberFormat
import java.util.*

class BestSellersAdapterDelegate {
    val adapterDelegate =
        adapterDelegateViewBinding<BestSellerPageEntity, DisplayableItem, ItemBestSellersPageBinding>(
            { layoutInflater, root ->
                ItemBestSellersPageBinding.inflate(
                    layoutInflater,
                    root,
                    false
                )
            }
        ) {
            binding.root.setOnClickListener {
                router.navigateTo(screens.productDetails())
            }
            bind {
                setItemValues(binding.item0, item.items.getOrNull(0))
                setItemValues(binding.item1, item.items.getOrNull(1))
                setItemValues(binding.item2, item.items.getOrNull(2))
                setItemValues(binding.item3, item.items.getOrNull(3))
            }
        }

    private fun setItemValues(itemView: BestSellerItem, itemEntity: BestSellerEntity?) =
        with(itemView) {
            itemEntity?.let {
                isVisible = true
                Picasso.get()
                    .load(it.picture)
                    .into(itemView.backgroundImage)
                favorite.icon = resourcesProvider.getDrawable(
                    if (it.is_favorites) {
                        R.drawable.ic_favorite_enabled
                    } else {
                        R.drawable.ic_favorite_disabled
                    }
                )
                price.text = String.format(
                    resourcesProvider.getString(R.string.price_format_string),
                    NumberFormat.getNumberInstance(Locale.US).format(it.discount_price)
                )
                pricePrev.text = String.format(
                    resourcesProvider.getString(R.string.price_format_string),
                    NumberFormat.getNumberInstance(Locale.US).format(it.price_without_discount)
                )
                pricePrev.paintFlags = pricePrev.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
                name.text = it.title
            } ?: run {
                isVisible = false
            }
        }

    private val resourcesProvider: IResourcesProvider by KoinJavaComponent.inject(IResourcesProvider::class.java)

    private val router: Router by KoinJavaComponent.inject(Router::class.java)
    private val screens: IScreens by KoinJavaComponent.inject(IScreens::class.java)
}