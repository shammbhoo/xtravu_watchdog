package com.mob.xtravuwatchdog.utils

import android.content.Context
import android.util.AttributeSet
import android.widget.VideoView

class FullScreenVideoView(context: Context, attrs: AttributeSet) : VideoView(context, attrs) {

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val width = MeasureSpec.getSize(widthMeasureSpec)
        val height = MeasureSpec.getSize(heightMeasureSpec)
        setMeasuredDimension(width, height) // Set full screen dimensions
    }
}
