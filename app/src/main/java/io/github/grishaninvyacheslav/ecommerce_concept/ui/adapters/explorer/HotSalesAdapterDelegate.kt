package io.github.grishaninvyacheslav.ecommerce_concept.ui.adapters.explorer

import androidx.core.view.isVisible
import com.github.terrakok.cicerone.Router
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.squareup.picasso.Picasso
import io.github.grishaninvyacheslav.ecommerce_concept.databinding.ItemHotSaleBinding
import io.github.grishaninvyacheslav.ecommerce_concept.domain.entity.HotSaleEntity
import io.github.grishaninvyacheslav.ecommerce_concept.ui.adapters.DisplayableItem
import io.github.grishaninvyacheslav.ecommerce_concept.ui.screens.IScreens
import org.koin.java.KoinJavaComponent.inject

class HotSalesAdapterDelegate{
    val adapterDelegate =
        adapterDelegateViewBinding<HotSaleEntity, DisplayableItem, ItemHotSaleBinding>(
            { layoutInflater, root -> ItemHotSaleBinding.inflate(layoutInflater, root, false) }
        ) {
            binding.root.setOnClickListener {
                router.navigateTo(screens.productDetails())
            }
            bind {
                binding.newSale.isVisible = item.is_new
                binding.title.text = item.title
                binding.subtitle.text = item.subtitle
                binding.buy.isVisible = item.is_buy
                Picasso.get()
                    .load(item.picture).apply {
                        into(binding.backgroundImage)
                    }
            }
        }

    private val router: Router by inject(Router::class.java)
    private val screens: IScreens by inject(IScreens::class.java)
}



