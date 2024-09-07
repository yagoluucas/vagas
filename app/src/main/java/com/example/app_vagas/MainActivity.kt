package com.example.app_vagas

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app_vagas.fragments.BagFragment
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
                titulo = "Analista de Projetos de CRM Pleno",
                descricao = "Descrição da vaga de analista de sistemas",
                tipoVaga = "Tipo de vaga: Presencial",
                horarioTrabalho = "Período de trabalho: Matutino",
                modeloDeContratacao = "Modelo de contratação: CLT",
                senioridade = "Senioridade: Pleno"
            ),
            Vaga(
                id = 2,
                titulo = "Analista de Sistemas",
                descricao = "Descrição da vaga de analista de sistemas",
                tipoVaga = "Tipo de vaga: Presencial",
                horarioTrabalho = "Período de trabalho: Matutino",
                modeloDeContratacao = "Modelo de contratação: CLT",
                senioridade = "Senioridade: Assistente"
            ),
            Vaga(
                id = 3,
                titulo = "DBA Pleno",
                descricao = "Descrição da vaga de analista de sistemas",
                tipoVaga = "Tipo de vaga: Presencial",
                horarioTrabalho = "Período de trabalho: Matutino",
                modeloDeContratacao = "Modelo de contratação: CLT",
                senioridade = "Senioridade: Júnior"
            ),
            Vaga(
                id = 3,
                titulo = "Analista Salesforce",
                descricao = "Descrição da vaga de analista de sistemas",
                tipoVaga = "Tipo de vaga: Presencial",
                horarioTrabalho = "Período de trabalho: Matutino",
                modeloDeContratacao = "Modelo de contratação: CLT",
                senioridade = "Senioridade: Estágio"
            ),
            Vaga(
                id = 3,
                titulo = "Marketing Digital",
                descricao = "Descrição da vaga de analista de sistemas",
                tipoVaga = "Tipo de vaga: Presencial",
                horarioTrabalho = "Período de trabalho: Matutino",
                modeloDeContratacao = "Modelo de contratação: CLT",
                senioridade = "Senioridade: Estágio"
            ),
            Vaga(
                id = 3,
                titulo = "Desenvolvedor Backend Java",
                descricao = "Descrição da vaga de analista de sistemas",
                tipoVaga = "Tipo de vaga: Presencial",
                horarioTrabalho = "Período de trabalho: Matutino",
                modeloDeContratacao = "Modelo de contratação: CLT",
                senioridade = "Senioridade: Estágio"
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