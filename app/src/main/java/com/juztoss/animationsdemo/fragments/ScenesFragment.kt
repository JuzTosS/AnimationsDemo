package com.juztoss.animationsdemo.fragments

import android.app.Fragment
import android.os.Bundle
import android.transition.AutoTransition
import android.transition.Scene
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.juztoss.animationsdemo.R

class ScenesFragment : Fragment {

    constructor() : super()

    private var isExpanded = false;
    private lateinit var sceneA: Scene
    private lateinit var sceneB: Scene

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.scene_transition, container, false);
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        sceneA = Scene.getSceneForLayout(view as ViewGroup, R.layout.scene_a, context)
        sceneB = Scene.getSceneForLayout(view, R.layout.scene_b, context)

        view.setOnClickListener {
            if (isExpanded) {
                isExpanded = false
                collapse();
            } else {
                isExpanded = true
                expand();
            }
        }
    }

    private fun expand() {
        TransitionManager.go(sceneB, AutoTransition())
    }

    private fun collapse() {
        TransitionManager.go(sceneA, AutoTransition())
    }
}