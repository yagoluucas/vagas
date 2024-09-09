package com.example.app_vagas

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                addBottomNavigationFragment()
        }

        private fun addBottomNavigationFragment() {
                val fragmentManager = supportFragmentManager
                val existingFragment = fragmentManager.findFragmentByTag("BOTTOM_NAVIGATION_FRAGMENT")

                if (existingFragment == null) {
                        val bottomNavigationFragment = BottomNavigationFragment()
                        fragmentManager.beginTransaction()
                                .add(R.id.fragment_container, bottomNavigationFragment, "BOTTOM_NAVIGATION_FRAGMENT")
                                .commit()
                }
        }

        override fun onResume() {
                super.onResume()
                updateBottomNavigationSelection()
        }

        open fun updateBottomNavigationSelection() {
                // Override this method in subclasses to update the selected item
        }
}