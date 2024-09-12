package com.example.app_vagas

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.app_vagas.model.Vaga

class MainActivity : BaseActivity() {

    val listaVagas = ArrayList<Vaga>()
    private lateinit var adapter: ListaVagaAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Configura RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.ID_ListaVagas)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = ListaVagaAdapter(this, listaVagas)
        recyclerView.adapter = adapter

        // Adiciona uma vaga inicial
        listaVagas.add(
            Vaga(
                id = 1,
                titulo = "Analista de Projetos de CRM Pleno",
                descricao = "Descrição da vaga de analista de sistemas",
                tipoVaga = "Presencial",
                horarioTrabalho = "Matutino",
                modeloDeContratacao = "CLT",
                senioridade = "Pleno"
            )
        )
        adapter.notifyDataSetChanged()

        // Botão para adicionar nova vaga
        val btnAddVaga: Button = findViewById(R.id.btnAddVaga)
        btnAddVaga.setOnClickListener {
            showAddVagaDialog()
        }
    }

    private fun showAddVagaDialog() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.add_vaga, null)

        // Configura os Spinners
        val tiposVaga = arrayOf("Presencial", "Híbrido", "Remoto")
        val horariosTrabalho = arrayOf("Matutino", "Vespertino", "Noturno")
        val modelosContratacao = arrayOf("PJ", "CLT")
        val senioridades = arrayOf("Estágio", "Assistente", "Júnior", "Pleno", "Sênior")

        val tipoVagaAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, tiposVaga)
        val horarioTrabalhoAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, horariosTrabalho)
        val modeloContratacaoAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, modelosContratacao)
        val senioridadeAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, senioridades)

        tipoVagaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        horarioTrabalhoAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        modeloContratacaoAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        senioridadeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        val spinnerTipoVaga: Spinner = dialogView.findViewById(R.id.spinnerTipoVaga)
        val spinnerHorarioTrabalho: Spinner = dialogView.findViewById(R.id.spinnerHorarioTrabalho)
        val spinnerModeloContratacao: Spinner = dialogView.findViewById(R.id.spinnerModeloContratacao)
        val spinnerSenioridade: Spinner = dialogView.findViewById(R.id.spinnerSenioridade)

        spinnerTipoVaga.adapter = tipoVagaAdapter
        spinnerHorarioTrabalho.adapter = horarioTrabalhoAdapter
        spinnerModeloContratacao.adapter = modeloContratacaoAdapter
        spinnerSenioridade.adapter = senioridadeAdapter

        val dialogBuilder = AlertDialog.Builder(this)
            .setView(dialogView)
            .setTitle("Adicionar Vaga")
            .setPositiveButton("Adicionar") { _, _ ->
                val edtTitulo: EditText = dialogView.findViewById(R.id.edtTitulo)
                val edtDescricao: EditText = dialogView.findViewById(R.id.edtDescricao)

                val tituloVaga = edtTitulo.text.toString()
                val descricaoVaga = edtDescricao.text.toString()
                val tipoVaga = spinnerTipoVaga.selectedItem.toString()
                val horarioTrabalho = spinnerHorarioTrabalho.selectedItem.toString()
                val modeloContratacao = spinnerModeloContratacao.selectedItem.toString()
                val senioridade = spinnerSenioridade.selectedItem.toString()

                if (tituloVaga.isNotEmpty()) {
                    // Adiciona a nova vaga na lista
                    val novaVaga = Vaga(
                        id = (listaVagas.size + 1).toLong(),
                        titulo = tituloVaga,
                        descricao = descricaoVaga,
                        tipoVaga = tipoVaga,
                        horarioTrabalho = horarioTrabalho,
                        modeloDeContratacao = modeloContratacao,
                        senioridade = senioridade
                    )
                    listaVagas.add(novaVaga)
                    adapter.notifyDataSetChanged() // Atualiza a lista
                }
            }
            .setNegativeButton("Cancelar", null)

        val dialog = dialogBuilder.create()
        dialog.show()
    }

    override fun updateBottomNavigationSelection() {
        val fragment = supportFragmentManager.findFragmentByTag("BOTTOM_NAVIGATION_FRAGMENT") as? BottomNavigationFragment
        fragment?.updateSelectedItem(R.id.navigation_bag)
    }
}