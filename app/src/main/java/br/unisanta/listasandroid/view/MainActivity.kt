package br.unisanta.listasandroid.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.unisanta.listasandroid.R
import br.unisanta.listasandroid.dao.FilmeDao
import br.unisanta.listasandroid.model.Filme
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    val dao = FilmeDao()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val edtNome = findViewById<EditText>(R.id.edt_nome)
        val edtDescricao = findViewById<EditText>(R.id.edt_descricao)
        val edtNota = findViewById<EditText>(R.id.edt_nota)
        val edtUrl = findViewById<EditText>(R.id.edt_url)
        val btnCadastrar = findViewById<Button>(R.id.btn_cadastrar)
        val fabAvanca = findViewById<FloatingActionButton>(R.id.fab_avanca)

        btnCadastrar.setOnClickListener {
            val nome = edtNome.text.toString()
            val descricao = edtDescricao.text.toString()
            val nota = edtNota.text.toString()
            val url = edtUrl.text.toString()
            val filme = Filme(nome,descricao,nota,url)
            dao.adicionarFilme(filme)
            edtNome.text.clear()
            edtDescricao.text.clear()
            edtNota.text.clear()
            edtUrl.text.clear()
            Toast.makeText(this, "Filme Cadastrado Com Sucesso!", Toast.LENGTH_LONG).show()
        }
        fabAvanca.setOnClickListener {
            val intent = Intent(this,ListaFilmesActivity::class.java)
            startActivity(intent)
        }
    }
}