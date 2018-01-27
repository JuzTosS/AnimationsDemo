package com.juztoss.animationsdemo.fragments

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
import android.view.animation.DecelerateInterpolator
import android.view.animation.ScaleAnimation
import com.juztoss.animationsdemo.R
import kotlinx.android.synthetic.main.view_animation.*


class AnimationFragment : Fragment {

    constructor() : super()

    private val DURATION = 250L;
    private var isOpen = true;

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.view_animation, container, false);
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        button.setOnClickListener {
            if (isOpen) {
                isOpen = false
                animateClose()
            } else {
                isOpen = true
                animateOpen()
            }

        }
    }

    private fun animateOpen() {
        val anim = ScaleAnimation(0F, 1F, 0F, 1F,
                0F, card.measuredHeight.toFloat())
        anim.duration = DURATION
        anim.interpolator = DecelerateInterpolator()
        anim.fillAfter = true
        card.startAnimation(anim)
    }

    private fun animateClose() {
        val anim = ScaleAnimation(1F, 0F, 1F, 0F,
                0F, card.measuredHeight.toFloat())
        anim.duration = DURATION
        anim.interpolator = AccelerateInterpolator()
        anim.fillAfter = true
        card.startAnimation(anim)
    }

    //Uncomment if you want to play this animation using XML
//    private fun animateOpen() {
//        val animation = AnimationUtils.loadAnimation(context, R.anim.open_animation)
//        card.startAnimation(animation)
//    }
//
//    private fun animateClose() {
//        val animation = AnimationUtils.loadAnimation(context, R.anim.close_animation)
//        card.startAnimation(animation)
//    }
}