package com.example.app_vagas

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app_vagas.fragments.BagFragment
import com.example.app_vagas.test.NotificationActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_filter -> {
                    loadFragment(FilterFragment())
                    removeRecyclerView()
                    true
                }
                R.id.navigation_alert -> {
                    loadFragment(NotificationFragment())
                    removeRecyclerView()
                    true
                }
                R.id.navigation_profile -> {
                    loadFragment(ProfileFragment())
                    removeRecyclerView()
                    true
                }

                R.id.navigation_bag -> {
                    loadFragment(BagFragment())
                    addRecyclerView()
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
            ),
            Vaga(
                id = 3,
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
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    private fun removeRecyclerView(){
        val recyclerView = findViewById<RecyclerView>(R.id.ID_ListaVagas)
        recyclerView.visibility = View.GONE
    }

    private fun addRecyclerView(){
        val recyclerView = findViewById<RecyclerView>(R.id.ID_ListaVagas)
        recyclerView.visibility = View.VISIBLE
    }
}