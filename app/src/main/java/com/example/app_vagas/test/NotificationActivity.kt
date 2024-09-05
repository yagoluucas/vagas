package com.example.app_vagas.test

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.app_vagas.FilterFragment
import com.example.app_vagas.NotificationFragment
import com.example.app_vagas.ProfileFragment
import com.example.app_vagas.R
import com.example.app_vagas.fragments.BagFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class NotificationActivity: AppCompatActivity() {

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)
    }
}