package com.juztoss.animationsdemo.fragments

import android.app.Fragment
import android.os.Bundle
import android.support.animation.DynamicAnimation
import android.support.animation.FlingAnimation
import android.support.animation.SpringAnimation
import android.support.animation.SpringForce
import android.support.animation.SpringForce.DAMPING_RATIO_HIGH_BOUNCY
import android.support.animation.SpringForce.STIFFNESS_VERY_LOW
import android.view.LayoutInflater
import android.view.MotionEvent.ACTION_DOWN
import android.view.View
import android.view.ViewGroup
import com.juztoss.animationsdemo.R
import kotlinx.android.synthetic.main.physic.*


class PhysicFragment : Fragment {

    constructor() : super()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.physic, container, false);
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        val shift = resources.getDimensionPixelSize(R.dimen.click_shift)
        view?.setOnTouchListener { _, event ->
            if (event.action == ACTION_DOWN) {
                val spring = SpringForce(0f)
                        .setDampingRatio(DAMPING_RATIO_HIGH_BOUNCY)
                        .setStiffness(STIFFNESS_VERY_LOW)

                image.rotation = 360F

                val rotation = SpringAnimation(image, DynamicAnimation.ROTATION)
                rotation.spring = spring
                rotation.start()

                FlingAnimation(image, DynamicAnimation.X)
                        .setStartVelocity((event.x - image.x + shift) * 3)
                        .start()

                FlingAnimation(image, DynamicAnimation.Y)
                        .setStartVelocity((event.y - image.y + shift) * 3)
                        .start()

                return@setOnTouchListener true
            }

            return@setOnTouchListener false
        }

    }
}