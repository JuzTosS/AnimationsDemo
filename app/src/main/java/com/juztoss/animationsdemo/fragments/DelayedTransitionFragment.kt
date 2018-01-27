package com.juztoss.animationsdemo.fragments

import android.app.Fragment
import android.os.Bundle
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.juztoss.animationsdemo.R
import kotlinx.android.synthetic.main.delayed_transition.*

class DelayedTransitionFragment : Fragment {

    constructor() : super()

    private var isExpanded = false;

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.delayed_transition, container, false);
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        view?.setOnClickListener {
            TransitionManager.beginDelayedTransition(view as ViewGroup)
            if (isExpanded) {
                isExpanded = false
                expand();
            } else {
                isExpanded = true
                collapse();
            }
        }
    }

    private fun expand() {
        val lp = image.layoutParams
        lp.width = context.resources.getDimension(R.dimen.image_size_expanded).toInt()
        lp.height = context.resources.getDimension(R.dimen.image_size_expanded).toInt()
        image.layoutParams = lp

        title.visibility = View.VISIBLE
        description.visibility = View.VISIBLE
    }

    private fun collapse() {
        val lp = image.layoutParams
        lp.width = context.resources.getDimension(R.dimen.image_size_collapsed).toInt()
        lp.height = context.resources.getDimension(R.dimen.image_size_collapsed).toInt()
        image.layoutParams = lp

        title.visibility = View.GONE
        description.visibility = View.GONE
    }
}