package br.unisanta.listasandroid.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView
import br.unisanta.listasandroid.R
import br.unisanta.listasandroid.model.Filme

class FilmeAdapter(private val filmes:List<Filme>):
    RecyclerView.Adapter<FilmeAdapter.ViewHolder>() {
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val txvNomeFilme:TextView = itemView.findViewById(R.id.txv_nome_filme)
        val txvDescricaoFilme:TextView = itemView.findViewById(R.id.txv_descricao_filme)
        val txvNota:TextView = itemView.findViewById(R.id.txv_nota_filme)
        val videoViewUrl:VideoView = itemView.findViewById(R.id.videoViewContainer)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_filme,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val filme = filmes[position]
        holder.txvNomeFilme.text = filme.titulo
        holder.txvDescricaoFilme.text = filme.descricao
        holder.txvNota.text = filme.nota
        val uri = Uri.parse(filme.url)
        holder.videoViewUrl.setVideoURI(uri)
        holder.videoViewUrl.start()
    }
    override fun getItemCount(): Int {
        return filmes.size
    }


}