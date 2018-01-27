package com.juztoss.animationsdemo.fragments

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
import android.view.animation.DecelerateInterpolator
import com.juztoss.animationsdemo.R
import kotlinx.android.synthetic.main.property_animator.*

class PropertyAnimatorFragment : Fragment {

    constructor() : super()

    private val DURATION = 250L;
    private var isOpen = false;

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.property_animator, container, false);
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
        val animationX = ObjectAnimator.ofFloat(card, "scaleX", 1F)
        val animationY = ObjectAnimator.ofFloat(card, "scaleY", 1F)

        val set = AnimatorSet()
        set.play(animationX)
                .with(animationY)

        set.duration = DURATION
        set.interpolator = DecelerateInterpolator()
        set.start()
    }

    private fun animateClose() {
        val animationX = ObjectAnimator.ofFloat(card, "scaleX", 0F)
        val animationY = ObjectAnimator.ofFloat(card, "scaleY", 0F)

        val set = AnimatorSet()
        set.play(animationX)
                .with(animationY)

        set.duration = DURATION
        set.interpolator = AccelerateInterpolator()
        set.start()
    }

    //Uncomment if you want to play this animation using XML
//    private fun animateOpen() {
//        val set = AnimatorInflater.loadAnimator(context, R.animator.open_animator) as AnimatorSet
//        set.setTarget(card)
//        set.start()
//    }
//
//    private fun animateClose() {
//        val set = AnimatorInflater.loadAnimator(context, R.animator.close_animator) as AnimatorSet
//        set.setTarget(card)
//        set.start()
//    }
}