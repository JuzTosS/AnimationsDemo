package com.juztoss.animationsdemo.fragments

import android.app.Fragment
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.juztoss.animationsdemo.R
import kotlinx.android.synthetic.main.frame_by_frame.*

class FrameByFrameFragment : Fragment {
    constructor() : super()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.frame_by_frame, container, false);
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        val animation = image.drawable as AnimationDrawable
        animation.start()

        view?.setOnClickListener {
            val anim = image.drawable as AnimationDrawable
            anim.stop()
            anim.start()
        }
    }
}