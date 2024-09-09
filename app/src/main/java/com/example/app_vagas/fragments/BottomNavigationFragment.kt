package com.example.app_vagas

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class BottomNavigationFragment : Fragment() {
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.bottom_navigation_bar, container, false)
        bottomNavigationView = view.findViewById(R.id.bottomNavigationView)

        if (::bottomNavigationView.isInitialized) {
            Log.d("BottomNavigation", "BottomNavigationView initialized successfully")
        } else {
            Log.e("BottomNavigation", "Failed to initialize BottomNavigationView")
        }

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_bag -> {
                    Log.d("BottomNavigation", "Bag item selected")
                    if (activity !is MainActivity) {
                        val intent = Intent(activity, MainActivity::class.java)
                        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                        startActivity(intent)
                    }
                    true
                }
                R.id.navigation_filter -> {
                    Log.d("BottomNavigation", "Filter item selected")
                    if (activity !is FilterActivity) {
                        val intent = Intent(activity, FilterActivity::class.java)
                        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                        startActivity(intent)
                    }
                    true
                }
                R.id.navigation_alert -> {
                    Log.d("BottomNavigation", "Alert item selected")
                    if (activity !is NotificationActivity) {
                        val intent = Intent(activity, NotificationActivity::class.java)
                        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                        startActivity(intent)
                    }
                    true
                }
                else -> false
            }
        }
        return view
    }

    fun updateSelectedItem(itemId: Int) {
        if (::bottomNavigationView.isInitialized) {
            bottomNavigationView.selectedItemId = itemId
        } else {
            Log.e("BottomNavigation", "BottomNavigationView is not initialized")
        }
    }
}