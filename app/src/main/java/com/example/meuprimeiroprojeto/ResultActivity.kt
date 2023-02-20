package com.example.meuprimeiroprojeto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvResult: TextView = findViewById(R.id.textview_result)
        val tvclassificacao: TextView = findViewById(R.id.tvClassificacao)

        val result = intent.getFloatExtra("EXTRA_RESULT", 0.1f)

        tvResult.text = result.toString()

        /*TABELA IMC
        MENOR QUE 18,5	    MAGREZA	0
        ENTRE 18,5 E 24,9	    NORMAL	0
        ENTRE 25,0 E 29,9	    SOBREPESO	I
        ENTRE 30,0 E 39,9	    OBESIDADE	II
        MAIOR QUE 40,0	        OBESIDADE GRAVE	III*/

        val classificacao = if (result < 18.5f){
            "ABAIXO DO PESO!"
        }else if (result in 18.5f..24.9f){
            "PESO NORMAL"
        }else if (result in 25.0f..29.9f){
            "SOBREPESO!"
        }else if (result in 30.0f..39.0f){
            "OBESIDADE!"
        }else{
            "OBESIDADE GRAVE!"
        }

        tvclassificacao.text = getString(R.string.message_classificacao, classificacao)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }

  }
