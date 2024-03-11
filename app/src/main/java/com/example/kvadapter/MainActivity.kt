package com.example.kvadapter

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var RecyclerView: RecyclerView
    private lateinit var Adapter:CustomAdapter

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val itemList = listOf(
            viewmodel( text =  "Kitkat"),
            viewmodel( text = "Munch"),
            viewmodel( text = "diary Milk"),
            viewmodel( text = "Cadburys"),
            viewmodel( text = "Ferreros"),
            viewmodel( text = "Hershey’s"),
            viewmodel( text = "Nestle"),
            viewmodel( text = "Campco"),
            viewmodel( text = "Lotte"),
            viewmodel( text = "Fantasle")
        )

        RecyclerView = findViewById(R.id.recyclerView)
        Adapter = CustomAdapter(itemList)

        RecyclerView.layoutManager = LinearLayoutManager(this)
        RecyclerView.adapter = Adapter
    }
}