package br.unisanta.listasandroid.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.unisanta.listasandroid.R
import br.unisanta.listasandroid.adapter.FilmeAdapter
import br.unisanta.listasandroid.dao.FilmeDao

class ListaFilmesActivity : AppCompatActivity() {
    val dao = FilmeDao()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_usuarios)
        val rvFilmes = findViewById<RecyclerView>(R.id.rv_filmes)
        val filmes = dao.obterFilmes()
        rvFilmes.layoutManager = LinearLayoutManager(this)
        rvFilmes.adapter = FilmeAdapter(filmes)
    }
}