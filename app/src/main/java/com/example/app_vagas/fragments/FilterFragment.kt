package com.example.app_vagas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.fragment.app.Fragment

class FilterFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_filter, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val senioridades = listOf("Estágio", "Assistente", "Junior", "Pleno", "Sênior")
        val tiposvaga = listOf("Presencial", "Híbrido", "Remoto")
        val periodoTrabalho = listOf("Matutino", "Vespertino", "Noturno")
        val modeloContratacao = listOf("PJ", "CLT")

        val autoCompleteTextViewSenioridade = view.findViewById<AutoCompleteTextView>(R.id.filter_autoComplete_senioridade)
        val autoCompleteTextViewTipoVaga = view.findViewById<AutoCompleteTextView>(R.id.filter_autoComplete_tipoVaga)
        val autoCompleteTextViewHorarioTrabalho = view.findViewById<AutoCompleteTextView>(R.id.filter_autoComplete_horariotrabalho)
        val autoCompletoTextViewModeloContratacao = view.findViewById<AutoCompleteTextView>(R.id.filter_autoComplete_modeloContratacao)

        val adapterTipoVaga = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, tiposvaga)
        val adapterSenioridade = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, senioridades)
        val adapterHorariotrabalho = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, periodoTrabalho)
        val adapterModeloContratacao = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, modeloContratacao)

        autoCompleteTextViewTipoVaga.setAdapter(adapterTipoVaga)
        autoCompleteTextViewSenioridade.setAdapter(adapterSenioridade)
        autoCompleteTextViewHorarioTrabalho.setAdapter(adapterHorariotrabalho)
        autoCompletoTextViewModeloContratacao.setAdapter(adapterModeloContratacao)
    }
}