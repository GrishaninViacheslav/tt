package io.github.grishaninvyacheslav.explorer.ui.fragments

import android.content.Context
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import com.google.android.material.bottomsheet.BottomSheetDialog
import io.github.grishaninvyacheslav.explorer.R
import io.github.grishaninvyacheslav.explorer.databinding.DialogFilterOptionsBinding

class FilterBottomSheetDialog(parentContext: Context) :
    BottomSheetDialog(parentContext) {
    init {
        DialogFilterOptionsBinding.inflate(LayoutInflater.from(context))
            .apply {
                close.setOnClickListener { this@FilterBottomSheetDialog.dismiss() }
                done.setOnClickListener { this@FilterBottomSheetDialog.dismiss() }

                initSpinnerWithResource(brandSpinner, R.array.brand_filter)
                initSpinnerWithResource(priceSpinner, R.array.price_filter)
                initSpinnerWithResource(sizeSpinner, R.array.size_filter)
            }.apply { setContentView(this.root) }
    }

    private fun initSpinnerWithResource(spinner: AutoCompleteTextView, stringArrayId: Int){
        val brands = context.resources.getStringArray(stringArrayId)
        val adapter: ArrayAdapter<String> = ArrayAdapter(
            context,
            R.layout.menu_dropdown_brand,
            brands
        )
        spinner.setText(brands[0])
        spinner.setAdapter(adapter)
    }
}