package com.mob.xtravuwatchdog.utils

import android.text.TextWatcher
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mob.xtravuwatchdog.R

object BindingAdapters {
    @JvmStatic
    @BindingAdapter("textChangedListener")
    fun setTextChangedListener(editText: EditText, listener: TextWatcher?) {
        listener?.let {
            editText.addTextChangedListener(it)
        }
    }
    @JvmStatic
    @BindingAdapter("app:resizeMode","app:selectedResizeMode")
    fun setBackgroundTint(textView: TextView, resizeMode: ResizeMode, selectedResizeMode: ResizeMode?) {

        if (resizeMode == selectedResizeMode) {
            // Set the selected color (blue)
            textView.setBackgroundTintList(ContextCompat.getColorStateList(textView.context,R.color.blue))
        } else {
            // Set the deselected color (transparent)
            textView.setBackgroundTintList(ContextCompat.getColorStateList(textView.context,R.color.transparent));
        }
    }
    @JvmStatic
    @BindingAdapter("app:orientation","app:selectedOrientation")
    fun setBackgroundTint(textView: ImageView, orientation: Orientation, selectedOrientation: Orientation?) {
        if (orientation == selectedOrientation) {
            // Set the selected color (blue)
            textView.setBackgroundTintList(ContextCompat.getColorStateList(textView.context,R.color.blue))
        } else {
            // Set the deselected color (transparent)
            textView.setBackgroundTintList(ContextCompat.getColorStateList(textView.context,R.color.transparent));
        }
    }
    @JvmStatic
    @BindingAdapter("app:setAdapter")
    fun bindRecyclerViewAdapter(recyclerView: RecyclerView, setAdapter: RecyclerView.Adapter<*>?) {
        setAdapter?.let {
            recyclerView.adapter = it
        }
    }


}