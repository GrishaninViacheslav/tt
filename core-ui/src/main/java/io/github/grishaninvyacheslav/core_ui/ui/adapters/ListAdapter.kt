package io.github.grishaninvyacheslav.core_ui.ui.adapters

import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import io.github.grishaninvyacheslav.network.data.data_entity.DisplayableItem

class ListAdapter(adapterDelegate: AdapterDelegate<List<DisplayableItem>>) :
    ListDelegationAdapter<List<DisplayableItem>>(adapterDelegate)