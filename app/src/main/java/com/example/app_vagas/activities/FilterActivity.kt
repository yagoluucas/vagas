package com.example.app_vagas

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.appcompat.app.AppCompatActivity

class FilterActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter)

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

    override fun updateBottomNavigationSelection() {
        val fragment = supportFragmentManager.findFragmentByTag("BOTTOM_NAVIGATION_FRAGMENT") as? BottomNavigationFragment
        fragment?.updateSelectedItem(R.id.navigation_filter)
    }
}