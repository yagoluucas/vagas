package com.example.app_vagas.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.app_vagas.R
import com.example.app_vagas.adapters.Vaga
import com.example.app_vagas.adapters.VagaAdapter

class ListaVagaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_lista_vaga, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewVagas)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = VagaAdapter(getVagas())
        return view
    }

    private fun getVagas(): List<Vaga> {
        return listOf(
            Vaga("Título da vaga 1", "Modelo de contratação: PJ", "Tipo da vaga: Remoto", "Horário de trabalho: Comercial"),
            Vaga("Título da vaga 2", "Modelo de contratação: CLT", "Tipo da vaga: Presencial", "Horário de trabalho: Noturno")
            // Add more Vaga objects as needed
        )
    }
}