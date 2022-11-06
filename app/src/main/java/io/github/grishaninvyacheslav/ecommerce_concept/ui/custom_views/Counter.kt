package io.github.grishaninvyacheslav.ecommerce_concept.ui.custom_views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import io.github.grishaninvyacheslav.ecommerce_concept.databinding.ViewCounterBinding

class Counter : FrameLayout {
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