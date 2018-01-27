package com.juztoss.animationsdemo.fragments

import android.graphics.Canvas
import android.graphics.drawable.Drawable

internal class Snowflake(private val containerWidth: Int,
                         private val containerHeight: Int,
                         private val drawable: Drawable,
                         private val maxSize: Float,
                         private val maxSpeed: Float) {

    private var size: Double = 0.0
    private var speed: Double = 0.0
    private var x: Double = 0.0
    private var y: Double = 0.0

    init {
        reset()
    }

    private fun reset() {
        size = Math.random() * maxSize / 2 + maxSize / 2
        speed = Math.random() * maxSpeed / 2 + maxSpeed / 2
        y = -size;
        x = Math.random() * containerWidth
    }

    fun update() {
        y += speed
        if (y > containerHeight) {
            reset()
        }
    }

    fun draw(canvas: Canvas?) {
        if (canvas == null) {
            return
        }
        drawable.setBounds(x.toInt(), y.toInt(), (x + size).toInt(), (y + size).toInt())
        drawable.draw(canvas)
    }
}