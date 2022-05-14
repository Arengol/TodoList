package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val arrayAdapter: ArrayAdapter<*>
        val things = arrayOf("0","1","2","3","4")

        val todoListView = findViewById<ListView>(R.id.todo_list_view)
        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,things)
        todoListView.adapter = arrayAdapter
    }
}