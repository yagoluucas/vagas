package com.example.app_vagas

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class FilterActivity : BaseActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter)

        val linguagens = listOf("Java", "Kotlin", "Python", "JavaScript", "C#", "Swift", "Go", "Ruby", "PHP", "TypeScript")

        val autoCompleteTextViewLinguagens = findViewById<AutoCompleteTextView>(R.id.filter_autoComplete_linguagem)
        val btnAplicarFiltro = findViewById<Button>(R.id.filter_BtnAplicarFiltros_Button)

        val adapterLinguagens = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, linguagens)

        autoCompleteTextViewLinguagens.setAdapter(adapterLinguagens)

        btnAplicarFiltro.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("linguagem", autoCompleteTextViewLinguagens.text.toString())
            startActivity(intent)
        }
    }

    override fun updateBottomNavigationSelection() {
        val fragment = supportFragmentManager.findFragmentByTag("BOTTOM_NAVIGATION_FRAGMENT") as? BottomNavigationFragment
        fragment?.updateSelectedItem(R.id.navigation_filter)
    }
}