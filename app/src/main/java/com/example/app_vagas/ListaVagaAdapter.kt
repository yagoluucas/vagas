package com.example.app_vagas

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.app_vagas.model.Vaga

class ListaVagaAdapter(
    private val context: Context,
    private val listaVaga: List<Vaga>
): RecyclerView.Adapter<ListaVagaAdapter.VagaViewHolder>() {

    class VagaViewHolder(itemVaga: View): RecyclerView.ViewHolder(itemVaga) {

        fun vincula(vaga: Vaga) {
            itemView.findViewById<TextView>(R.id.tituloVaga).text = vaga.titulo
            itemView.findViewById<TextView>(R.id.modeloDaVaga).text = "Modelo de contratação: ${vaga.modeloDeContratacao}"
            itemView.findViewById<TextView>(R.id.tipoDaVaga).text = "Tipo da vaga: ${vaga.tipoVaga}"
            itemView.findViewById<TextView>(R.id.horarioTrabalho).text = "Horário de trabalho: ${vaga.horarioTrabalho}"
            itemView.findViewById<TextView>(R.id.senioridade).text = "Senioridade: ${vaga.senioridade}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VagaViewHolder {
        val inflated = LayoutInflater.from(context)
        val view: View = inflated.inflate(R.layout.vaga_item, parent, false)
        return VagaViewHolder(view)
    }

    override fun onBindViewHolder(holder: VagaViewHolder, position: Int) {
        holder.vincula(listaVaga[position])
    }

    override fun getItemCount(): Int = listaVaga.size
}
