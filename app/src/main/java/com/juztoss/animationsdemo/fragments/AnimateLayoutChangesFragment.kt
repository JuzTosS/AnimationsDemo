package com.juztoss.animationsdemo.fragments

import android.animation.LayoutTransition
import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.juztoss.animationsdemo.R
import kotlinx.android.synthetic.main.animate_layout_changes.*


class AnimateLayoutChangesFragment : Fragment {

    constructor() : super()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.animate_layout_changes, container, false);
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        val layoutTransition = (view as LinearLayout).layoutTransition
        layoutTransition.enableTransitionType(LayoutTransition.CHANGING)

        card_restore.setOnClickListener {
            card1.visibility = View.VISIBLE;
            card2.visibility = View.VISIBLE;
            card3.visibility = View.VISIBLE;
        }
        card1.setOnClickListener {
            card1.visibility = View.GONE;
        }
        card2.setOnClickListener {
            card2.visibility = View.GONE;
        }
        card3.setOnClickListener {
            card3.visibility = View.GONE;
        }
        card_line.setOnClickListener {
            additional_line.visibility = if (additional_line.visibility == View.GONE) View.VISIBLE else View.GONE
        }
    }
}