package com.juztoss.animationsdemo

import android.app.Fragment
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.juztoss.animationsdemo.fragments.FrameByFrameFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.frame_by_frame -> goTo(FrameByFrameFragment())
            R.id.property_animator -> goTo(FrameByFrameFragment())
            R.id.state_animator -> goTo(FrameByFrameFragment())
            R.id.vector -> goTo(FrameByFrameFragment())
            R.id.animate_layout_changes -> goTo(FrameByFrameFragment())
            R.id.begin_delayed_transition -> goTo(FrameByFrameFragment())
            R.id.scenes -> goTo(FrameByFrameFragment())
            R.id.physic -> goTo(FrameByFrameFragment())
            R.id.canvas -> goTo(FrameByFrameFragment())
            R.id.activity_basic -> goTo(FrameByFrameFragment())
            R.id.activity_shared -> goTo(FrameByFrameFragment())
            R.id.activity_custom -> goTo(FrameByFrameFragment())
            R.id.fragment_basic -> goTo(FrameByFrameFragment())
            R.id.fragment_shared -> goTo(FrameByFrameFragment())
            R.id.fragment_custom -> goTo(FrameByFrameFragment())
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun goTo(fragment: Fragment) {
        fragmentManager.beginTransaction().replace(R.id.container, fragment);
    }
}
