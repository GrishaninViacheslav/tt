package io.github.grishaninvyacheslav.product_details.presentation.adapters

import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.squareup.picasso.Picasso
import io.github.grishaninvyacheslav.network.data.data_entity.ProductImageEntity
import io.github.grishaninvyacheslav.network.data.data_entity.DisplayableItem
import io.github.grishaninvyacheslav.product_details.databinding.ItemProductImageBinding

class ProductImagesListAdapter : ListDelegationAdapter<List<DisplayableItem>>(
    productImagesListAdapterDelegate()
)

fun productImagesListAdapterDelegate() =
    adapterDelegateViewBinding<ProductImageEntity, DisplayableItem, ItemProductImageBinding>(
        { layoutInflater, root -> ItemProductImageBinding.inflate(layoutInflater, root, false) }
    ) {
        bind {
            Picasso.get()
                .load(item.url)
                .into(binding.productImage)
        }
    }