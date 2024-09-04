package com.example.app_vagas.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.app_vagas.R

data class Vaga(val titulo: String, val modelo: String, val tipo: String, val horario: String)

class VagaAdapter(private val vagas: List<Vaga>) : RecyclerView.Adapter<VagaAdapter.VagaViewHolder>() {

    class VagaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tituloVaga: TextView = itemView.findViewById(R.id.tituloVaga)
        private val modeloDaVaga: TextView = itemView.findViewById(R.id.modeloDaVaga)
        private val tipoDaVaga: TextView = itemView.findViewById(R.id.tipoDaVaga)
        private val textView4: TextView = itemView.findViewById(R.id.textView4)

        fun bind(vaga: Vaga) {
            tituloVaga.text = vaga.titulo
            modeloDaVaga.text = vaga.modelo
            tipoDaVaga.text = vaga.tipo
            textView4.text = vaga.horario
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VagaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.vaga_item, parent, false)
        return VagaViewHolder(view)
    }

    override fun onBindViewHolder(holder: VagaViewHolder, position: Int) {
        holder.bind(vagas[position])
    }

    override fun getItemCount(): Int = vagas.size
}