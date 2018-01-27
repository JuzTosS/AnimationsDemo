package com.juztoss.animationsdemo.fragments

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.juztoss.animationsdemo.R
import kotlinx.android.synthetic.main.vector_drawable.*

class VectorDrawableFragment : Fragment {

    constructor() : super()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.vector_drawable, container, false);
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        view?.setOnClickListener {
            image.isEnabled = !image.isEnabled
        }
    }
}