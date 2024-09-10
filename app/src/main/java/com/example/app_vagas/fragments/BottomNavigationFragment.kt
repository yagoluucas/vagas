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
        // Inflar o layout do fragmento
        return inflater.inflate(R.layout.bottom_navigation_bar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bottomNavigationView = view.findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_filter -> {
                    val intent = Intent(activity, FilterActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.navigation_alert -> {
                    val intent = Intent(activity, NotificationActivity::class.java)
                    startActivity(intent)
                    true
                }

                R.id.navigation_bag -> {
                    val intent = Intent(activity, MainActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
    }
}