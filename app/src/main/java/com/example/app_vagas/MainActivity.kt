package com.example.app_vagas

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.fragment.app.Fragment
import com.example.app_vagas.fragments.ListaVagaFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_bag -> {
                    loadFragment(ListaVagaFragment())
                    true
                }
                R.id.navigation_filter -> {
                    loadFragment(FilterFragment())
                    true
                }
                R.id.navigation_alert -> {
                    loadFragment(NotificationFragment())
                    true
                }
                R.id.navigation_profile -> {
                    loadFragment(ProfileFragment())
                    true
                }
                else -> false
            }
        }


        // usando a lista de vagas
        val recyclerView: RecyclerView = findViewById(R.id.ID_ListaVagas)
        recyclerView.adapter = ListaVagaAdapter(this, listOf(
            Vaga(
                id = 1,
                titulo = "Vaga de Analista de Sistemas",
                descricao = "Descrição da vaga de analista de sistemas",
                tipoVaga = "Presencial",
                horarioTrabalho = "Integral",
                modeloDeContratacao = "CLT"
            ),
            Vaga(
                id = 2,
                titulo = "Vaga de Analista de Sistemas",
                descricao = "Descrição da vaga de analista de sistemas",
                tipoVaga = "Presencial",
                horarioTrabalho = "Integral",
                modeloDeContratacao = "CLT"
            ),
            Vaga(
                id = 3,
                titulo = "Vaga de Analista de Sistemas",
                descricao = "Descrição da vaga de analista de sistemas",
                tipoVaga = "Presencial",
                horarioTrabalho = "Integral",
                modeloDeContratacao = "CLT"
            )
        ))


        // Load the default fragment
        if (savedInstanceState == null) {
            bottomNavigationView.selectedItemId = R.id.navigation_filter
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}