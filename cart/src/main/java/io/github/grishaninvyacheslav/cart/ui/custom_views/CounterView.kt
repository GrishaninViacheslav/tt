package io.github.grishaninvyacheslav.cart.ui.custom_views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import io.github.grishaninvyacheslav.cart.databinding.ViewCounterBinding

class CounterView : FrameLayout {
    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        addView(binding.root)
    }

    private val binding =
        ViewCounterBinding.inflate(LayoutInflater.from(context))
}