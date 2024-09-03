package com.example.app_vagas

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListaVagaAdapter(
    private val context: Context,
    private val listaVaga: List<Vaga>
): RecyclerView.Adapter<ListaVagaAdapter.VagaViewHolder>() {

    class VagaViewHolder(itemVaga: View): RecyclerView.ViewHolder(itemVaga) {

        fun vincula(vaga: Vaga) {
            itemView.findViewById<TextView>(R.id.tituloVaga).text = vaga.titulo
            itemView.findViewById<TextView>(R.id.modeloDaVaga).text = vaga.modeloDeContratacao
            itemView.findViewById<TextView>(R.id.tipoDaVaga).text = vaga.tipoVaga
            itemView.findViewById<TextView>(R.id.textView4).text = vaga.horarioTrabalho
        }

    }

    /*
        Método responsável por criar uma instância do ViewHolder
        O ViewHolder é o objeto encarregado de manter uma referência para cada uma das views que são exibidas dentro do RecyclerView
    */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VagaViewHolder {
        val inflated = LayoutInflater.from(context)
        val view: View = inflated.inflate(R.layout.vaga_item, parent, false)
        return VagaViewHolder(view)
    }

    /*
        É chamado quando o adapter insere cada uma das views dentro do RecyclerView
        Este método indica qual item estamos tratando no momento e qual ViewHolder está associado à view específica.
    */
    override fun onBindViewHolder(holder: VagaViewHolder, position: Int) {
        holder.vincula(listaVaga[position])
    }

    /*
        Método responsável por indicar quantos itens o adapter deve exibir no RecyclerView
    */
    override fun getItemCount(): Int = listaVaga.size
}