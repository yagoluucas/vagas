package com.example.app_vagas.activity

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.app_vagas.R
import com.example.app_vagas.fragments.BottomNavigationFragment

class NotificationActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)

        if (savedInstanceState == null) {
            // Adiciona o fragmento à activity
            supportFragmentManager.beginTransaction()
                .replace(R.id.notification_container, BottomNavigationFragment())
                .commit()
        }
    }

}