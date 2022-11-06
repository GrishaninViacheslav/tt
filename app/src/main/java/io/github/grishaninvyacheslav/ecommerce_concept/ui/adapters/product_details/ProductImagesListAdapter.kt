package io.github.grishaninvyacheslav.ecommerce_concept.ui.adapters.product_details

import android.util.Log
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.squareup.picasso.Picasso
import io.github.grishaninvyacheslav.ecommerce_concept.databinding.ItemProductImageBinding
import io.github.grishaninvyacheslav.ecommerce_concept.domain.entity.ProductImageEntity
import io.github.grishaninvyacheslav.ecommerce_concept.ui.adapters.DisplayableItem

class ProductImagesListAdapter : ListDelegationAdapter<List<DisplayableItem>>(
    productImagesListAdapterDelegate()
)

fun productImagesListAdapterDelegate() =
    adapterDelegateViewBinding<ProductImageEntity, DisplayableItem, ItemProductImageBinding>(
        { layoutInflater, root -> ItemProductImageBinding.inflate(layoutInflater, root, false) }
    ) {
        binding.root.setOnClickListener {
            Log.d("[MYLOG]", "setOnClickListener: $item")
        }
        bind {
            Picasso.get()
                .load(item.url)
                .into(binding.productImage)
        }
    }