package com.aranirahan.pldproject

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import kotlinx.android.synthetic.main.activity_main.*


@Suppress("UNUSED_EXPRESSION")
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initToolbar()

        val tabLayout: TabLayout = findViewById(R.id.tab_layout)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        val adapter = SampleAdapter(supportFragmentManager)

        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)

        /* tabLayout.addTab(tabLayout.newTab().setText("Songs"))
         tabLayout.addTab(tabLayout.newTab().setText("Albums"))
         tabLayout.addTab(tabLayout.newTab().setText("Artists"))*/

        tabLayout.getTabAt(0)?.setIcon(R.drawable.tab_1)
        tabLayout.getTabAt(1)?.setIcon(R.drawable.tab_2)
        tabLayout.getTabAt(2)?.setIcon(R.drawable.tab_3)

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            @SuppressLint("SetTextI18n")
            override fun onTabSelected(tab: TabLayout.Tab) {
                val position = tab.position
                when (position) {
                    0 -> toolbar_title.text = "Request"
                    1 -> toolbar_title.text = "My Book"
                    2 -> toolbar_title.text = "All Book"
                    else -> null
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
            }

            override fun onTabReselected(tab: TabLayout.Tab) {
            }
        })
    }

    private fun initToolbar() {
        val toolbar: Toolbar = findViewById(R.id.myToolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = ""
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }
}
