package com.example.app_vagas

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app_vagas.fragments.BottomNavigationFragment
import com.example.app_vagas.model.Vaga
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    val listaVagas = ArrayList<Vaga>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            // Adiciona o fragmento à activity
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_container, BottomNavigationFragment())
                .commit()
        }

        // usando a lista de vagas
        val recyclerView: RecyclerView = findViewById(R.id.ID_ListaVagas)
        recyclerView.layoutManager = LinearLayoutManager(this)


        listaVagas.add(Vaga(
            id = 1,
            titulo = "Analista de Projetos de CRM Pleno",
            descricao = "Descrição da vaga de analista de sistemas",
            tipoVaga = "Tipo de vaga: Presencial",
            horarioTrabalho = "Período de trabalho: Matutino",
            modeloDeContratacao = "Modelo de contratação: CLT",
            senioridade = "Senioridade: Pleno"
        ))

        recyclerView.adapter = ListaVagaAdapter(this, listaVagas)

    }

    fun addVaga(){

    }
}