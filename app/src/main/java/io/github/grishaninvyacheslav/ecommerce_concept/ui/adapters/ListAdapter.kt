package io.github.grishaninvyacheslav.ecommerce_concept.ui.adapters

import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class ListAdapter(adapterDelegate: AdapterDelegate<List<DisplayableItem>>) :
    ListDelegationAdapter<List<DisplayableItem>>(adapterDelegate)