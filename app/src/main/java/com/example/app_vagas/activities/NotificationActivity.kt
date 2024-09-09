package com.example.app_vagas

import android.os.Bundle
import android.util.Log

class NotificationActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)
        Log.d("NotificationActivity", "NotificationActivity created")
    }

    override fun updateBottomNavigationSelection() {
        val fragment = supportFragmentManager.findFragmentByTag("BOTTOM_NAVIGATION_FRAGMENT") as? BottomNavigationFragment
        fragment?.updateSelectedItem(R.id.navigation_alert) // Corrigir o ID do item de navegação
    }
}