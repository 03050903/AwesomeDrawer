package com.hx.material.ui

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.AppCompatActivity
import android.util.DisplayMetrics
import android.util.Log
import android.view.View
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_fold_menu.*
import ui.material.hx.com.hxmaterial.R
import android.support.v4.view.ViewCompat.setTranslationX
import android.opengl.ETC1.getWidth



/**
 * Created by Administrator on 2018/8/22.
 */
class FoldDrawerMenuActivity: AppCompatActivity() {


    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fold_menu)
        setSupportActionBar(toolbar)

        val metrics = DisplayMetrics()
        val wdm = getSystemService(Activity.WINDOW_SERVICE) as WindowManager
        wdm.defaultDisplay.getMetrics(metrics)


        drawer_layout.setScrimColor(Color.TRANSPARENT);
        drawer_layout.addDrawerListener(object : DrawerLayout.DrawerListener {
            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
                //fold_view.foldFactor = drawerView.measuredWidth.toFloat() / metrics.widthPixels.toFloat() * slideOffset
                Log.e("tag", "right: " + drawerView.right)
                //content.layout(drawerView.right, 0, 0, 0)
                content.setTranslationX(drawerView.width * slideOffset)
            }

            override fun onDrawerOpened(drawerView: View) {}
            override fun onDrawerClosed(drawerView: View) {
            }

            override fun onDrawerStateChanged(newState: Int) {}
        })
    }
}