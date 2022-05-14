package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.todolist.datamodel.Keep
import java.util.*

class MainActivity : AppCompatActivity() {

    private val todoListView: ListView by lazy {  findViewById<ListView>(R.id.todo_list_view) }
    private val arrayAdapter: ArrayAdapter<*> by lazy { ArrayAdapter(this, android.R.layout.simple_list_item_checked,viewInitialize()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        todoListView.choiceMode = ListView.CHOICE_MODE_MULTIPLE
        todoListView.adapter = arrayAdapter
    }

    private fun viewInitialize(): Array<Keep> {
        val things = arrayOf(
            Keep("Eat", Calendar.getInstance().time, false),
            Keep("Code", Calendar.getInstance().time, false),
            Keep("Repeat", Calendar.getInstance().time, false)
        )
        for (i in 0..things.size-1){
            todoListView.setItemChecked(i, things[i].isDone)
        }
        return things
    }
}