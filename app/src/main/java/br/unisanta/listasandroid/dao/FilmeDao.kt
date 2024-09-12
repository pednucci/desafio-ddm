package br.unisanta.listasandroid.dao

import br.unisanta.listasandroid.model.Filme

class FilmeDao {
    companion object{
        private val filmes = mutableListOf<Filme>()
    }
    fun adicionarFilme(filme:Filme){
        Companion.filmes.add(filme)
    }
    fun obterFilmes():List<Filme>{
        return Companion.filmes
    }
}