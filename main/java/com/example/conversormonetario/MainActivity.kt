package com.example.conversormonetario

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val DOLLAR = 5.71

    private lateinit var entradaEditText: EditText
    private lateinit var saidaTextView: TextView
    private lateinit var converterParaDollar: Button
    private lateinit var converterParaReal: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findById()
        configClickListener()
    }

    override fun onClick(v: View) {
        if (v == converterParaDollar) {
            conversorDollar()
        }else if (v == converterParaReal){
            conversorReal()
        }
    }

    private fun findById() {
        entradaEditText = findViewById(R.id.edittext_entrada)
        converterParaDollar = findViewById(R.id.button_converter_para_dollar)
        converterParaReal = findViewById(R.id.button_converter_para_real)
        saidaTextView = findViewById(R.id.textview_saida)
    }

    private fun configClickListener() {
        converterParaReal.setOnClickListener(this)
        converterParaDollar.setOnClickListener(this)
    }

    private fun getValor(): Double{
        return try {
            entradaEditText.text.toString().toDouble()
        } catch (e: NumberFormatException) {
            0.0
        }
    }

    private fun conversorDollar() {
        var valor = getValor()
        valor = valor / DOLLAR
        saidaTextView.text = "U$ $valor"
    }

    private fun conversorReal(){
        var valor = getValor()
        valor = valor * DOLLAR
        saidaTextView.text = "R$ $valor"
    }

}