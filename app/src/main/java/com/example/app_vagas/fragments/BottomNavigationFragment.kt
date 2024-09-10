package com.example.app_vagas.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.app_vagas.MainActivity
import com.example.app_vagas.R
import com.example.app_vagas.activity.FilterActivity
import com.example.app_vagas.activity.NotificationActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class BottomNavigationFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bottom_navigation_bar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bottomNavigationView = view.findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        bottomNavigationView.selectedItemId = when (activity?.javaClass) {
            FilterActivity::class.java -> R.id.navigation_filter
            NotificationActivity::class.java -> R.id.navigation_alert
            MainActivity::class.java -> R.id.navigation_bag
            else -> R.id.navigation_bag
        }
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_filter -> {
                    startActivity(Intent(activity, FilterActivity::class.java))
                    true
                }
                R.id.navigation_alert -> {
                    startActivity(Intent(activity, NotificationActivity::class.java))
                    true
                }

                R.id.navigation_bag -> {
                    startActivity(Intent(activity, MainActivity::class.java))
                    true
                }
                else -> false
            }
        }
    }
}