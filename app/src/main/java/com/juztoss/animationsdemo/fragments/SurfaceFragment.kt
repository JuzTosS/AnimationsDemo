package com.juztoss.animationsdemo.fragments

import android.app.Fragment
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.os.Bundle
import android.util.AttributeSet
import android.view.*
import com.juztoss.animationsdemo.R


class SurfaceFragment : Fragment {

    constructor() : super()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.surface, container, false)
    }
}


class MySurfaceView : SurfaceView, SurfaceHolder.Callback {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes)

    private lateinit var drawThread: DrawThread;

    init {
        holder.addCallback(this)
    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int,
                                height: Int) {
    }

    override fun surfaceCreated(holder: SurfaceHolder) {
        drawThread = DrawThread(getHolder(), context, measuredWidth, measuredHeight)
        drawThread.start()
    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {
        var retry = true
        drawThread.cancel();
        while (retry) {
            try {
                drawThread.join()
                retry = false
            } catch (e: InterruptedException) {

            }
        }
    }
}

internal class DrawThread(private val surfaceHolder: SurfaceHolder, context: Context, width: Int, height: Int) : Thread() {
    private var snowflakes: Array<Snowflake>
    private var cancelled: Boolean = false

    init {
        snowflakes = Array(10, {
            Snowflake(width, height,
                    context.getDrawable(R.drawable.snowflake),
                    context.resources.getDimension(R.dimen.max_snowflake_size),
                    context.resources.getDimension(R.dimen.max_snowflake_speed))
        })
    }

    override fun run() {
        while (!cancelled) {
            var canvas: Canvas? = surfaceHolder.lockCanvas()
            try {
                canvas?.drawColor(Color.WHITE)
                snowflakes.forEach {
                    it.update()
                    it.draw(canvas)
                }
            } finally {
                if (canvas != null) {
                    surfaceHolder.unlockCanvasAndPost(canvas)
                }
            }

            //Fix freezes on some devices
            //https://stackoverflow.com/questions/34305937/anr-in-surfaceview-on-specific-devices-only-the-only-fix-is-a-short-sleep-tim
            Thread.sleep(5);
        }
    }

    fun cancel() {
        cancelled = true
    }
}