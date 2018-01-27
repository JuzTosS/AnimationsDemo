package com.juztoss.animationsdemo.fragments

import android.app.Fragment
import android.content.Context
import android.graphics.Canvas
import android.os.Bundle
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.juztoss.animationsdemo.R


class CanvasFragment : Fragment {

    constructor() : super()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.canvas, container, false);
    }
}

class SnowAnimation : View {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes)

    private lateinit var snowflakes: Array<Snowflake>

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        snowflakes = Array(10, {
            Snowflake(right - left, bottom - top,
                    context.getDrawable(R.drawable.snowflake),
                    resources.getDimension(R.dimen.max_snowflake_size),
                    resources.getDimension(R.dimen.max_snowflake_speed))
        })
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        snowflakes.forEach {
            it.update()
            it.draw(canvas)
        }
        postInvalidateOnAnimation()
    }
}