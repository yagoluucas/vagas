package com.example.app_vagas.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.appcompat.app.AppCompatActivity
import com.example.app_vagas.R
import com.example.app_vagas.fragments.BottomNavigationFragment

class FilterActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter)

        if (savedInstanceState == null) {
            // Adiciona o fragmento à activity
            supportFragmentManager.beginTransaction()
                .replace(R.id.filter_container, BottomNavigationFragment())
                .commit()
        }

        val senioridades = listOf("Estágio", "Assistente", "Junior", "Pleno", "Sênior")
        val tiposvaga = listOf("Presencial", "Híbrido", "Remoto")
        val periodoTrabalho = listOf("Matutino", "Vespertino", "Noturno")
        val modeloContratacao = listOf("PJ", "CLT")

        val autoCompleteTextViewSenioridade = findViewById<AutoCompleteTextView>(R.id.filter_autoComplete_senioridade)
        val autoCompleteTextViewTipoVaga = findViewById<AutoCompleteTextView>(R.id.filter_autoComplete_tipoVaga)
        val autoCompleteTextViewHorarioTrabalho = findViewById<AutoCompleteTextView>(R.id.filter_autoComplete_horariotrabalho)
        val autoCompletoTextViewModeloContratacao = findViewById<AutoCompleteTextView>(R.id.filter_autoComplete_modeloContratacao)

        val adapterTipoVaga = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, tiposvaga)
        val adapterSenioridade = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, senioridades)
        val adapterHorariotrabalho = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, periodoTrabalho)
        val adapterModeloContratacao = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, modeloContratacao)

        autoCompleteTextViewTipoVaga.setAdapter(adapterTipoVaga)
        autoCompleteTextViewSenioridade.setAdapter(adapterSenioridade)
        autoCompleteTextViewHorarioTrabalho.setAdapter(adapterHorariotrabalho)
        autoCompletoTextViewModeloContratacao.setAdapter(adapterModeloContratacao)
    }
}