package com.example.app_vagas

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView
class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Configuração do navegação inferior do aplicativo
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.inflateMenu(R.menu.bottom_nav_menu)


        // Configuração do listener para o clique nos itens do menu
//        bottomNavigationView.setOnItemSelectedListener { item ->
//            when(item.itemId){
//                R.id.navigation_filter -> {
//                    setContentView(R.layout.activity_filter)
//                    val btnClosePage: ImageView = findViewById<ImageView>(R.id.ID_Filter_ClosePage)
//
//                    btnClosePage.setOnClickListener(){
//                        setContentView(R.layout.activity_main)
//                    }
//                    true
//                }
//                R.id.navigation_alert -> {
//                    setContentView(R.layout.activity_notification)
//                    true
//                }
//                R.id.navigation_profile -> {
//                    setContentView(R.layout.activity_profile)
//                    true
//                }
//                else -> false
//            }
//        }


    }
}