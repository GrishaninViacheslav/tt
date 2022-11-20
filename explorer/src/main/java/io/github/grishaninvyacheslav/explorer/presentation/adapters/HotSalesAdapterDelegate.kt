package io.github.grishaninvyacheslav.explorer.presentation.adapters

import androidx.core.view.isVisible
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.squareup.picasso.Picasso
import io.github.grishaninvyacheslav.explorer.databinding.ItemHotSaleBinding
import io.github.grishaninvyacheslav.navigation.domain.use_cases.NavigateToProductDetailsUseCase
import io.github.grishaninvyacheslav.network.data.data_entity.DisplayableItem
import io.github.grishaninvyacheslav.network.data.data_entity.HotSaleEntity

class HotSalesAdapterDelegate(
    private val navigateToProductDetailsUseCase: NavigateToProductDetailsUseCase
) {
    val adapterDelegate =
        adapterDelegateViewBinding<HotSaleEntity, DisplayableItem, ItemHotSaleBinding>(
            { layoutInflater, root -> ItemHotSaleBinding.inflate(layoutInflater, root, false) }
        ) {
            binding.root.setOnClickListener {
                navigateToProductDetailsUseCase()
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
}



