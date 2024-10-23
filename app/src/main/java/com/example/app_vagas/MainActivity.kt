package com.example.app_vagas

import android.app.Activity
import android.os.Bundle
import android.util.JsonReader
import android.util.Log
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.app_vagas.model.Vaga
import org.json.JSONObject
import java.io.InputStreamReader
import java.net.URL
import java.util.concurrent.Executors
import javax.net.ssl.HttpsURLConnection

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
        val linguagem = intent.getStringExtra("linguagem")?: "Java"
        buscarVaga(recyclerView, linguagem)
    }

    fun buscarVaga(listaVaga: RecyclerView, linguagem: String) {
        val url = URL("https://api.adzuna.com/v1/api/jobs/br/search/1?app_id=d4214fb8&app_key=22071f274f8ca734efe476ffb52cb390&" +
                "what=${linguagem}" +
                "&where=brasil" +
                "&results_per_page=30" +
                "&sort_by=date")
        val executorEmSegundoPlano = Executors.newSingleThreadExecutor()

        executorEmSegundoPlano.execute {

            try {
                // Abre conexão com a API
                val conexao = url.openConnection() as HttpsURLConnection
                conexao.requestMethod = "GET"
                conexao.setRequestProperty("Accept", "application/json")

                val responseCode = conexao.responseCode
                if (responseCode == 200) {
                    // Lê o corpo da resposta
                    val responseBody = conexao.inputStream.bufferedReader().use { it.readText() }

                    // Parseia o JSON
                    val jsonObject = JSONObject(responseBody)
                    val resultsArray = jsonObject.getJSONArray("results")

                    val listaVagas = mutableListOf<Vaga>()

                    for (i in 0 until resultsArray.length()) {
                        val jobObject = resultsArray.getJSONObject(i)
                        val id = jobObject.getString("id").toLong()  // Pega o ID e converte para Int
                        val titulo = jobObject.getString("title")
                        val descricao = jobObject.getString("description")
                        val locationObject = jobObject.getJSONObject("location")
                        val location = locationObject.getString("display_name")
                        val linkVaga = jobObject.getString("redirect_url")

                        // Adiciona a vaga na lista
                        listaVagas.add(
                            Vaga(
                                id = id,
                                titulo = titulo,
                                descricao = descricao,
                                localVaga = location,
                                linkvaga = linkVaga ?: "Sem link"
                            )
                        )
                    }

                    // Atualiza o RecyclerView na thread principal
                    (listaVaga.context as Activity).runOnUiThread {
                        val adapter = ListaVagaAdapter(this, listaVagas)
                        listaVaga.adapter = adapter
                    }
                } else {
                    Log.e("Erro", "Falha na conexão: $responseCode")
                }
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                executorEmSegundoPlano.shutdown()
            }
        }
    }

    override fun updateBottomNavigationSelection() {
        val fragment = supportFragmentManager.findFragmentByTag("BOTTOM_NAVIGATION_FRAGMENT") as? BottomNavigationFragment
        fragment?.updateSelectedItem(R.id.navigation_bag)
    }


}