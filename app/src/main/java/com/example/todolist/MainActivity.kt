package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.todolist.datamodel.Task
import java.util.*

class MainActivity : AppCompatActivity() {

    private val todoListView: ListView by lazy {  findViewById<ListView>(R.id.todo_list_view) }
    private val itemAdapter: TaskListAdapter by lazy { TaskListAdapter(this, viewInitialize()) }
    private val menuFab: View by lazy {findViewById(R.id.fab_menu)}
    private val deleteFab: View by lazy {findViewById(R.id.fab_delete)}
    private val createFab: View by lazy {findViewById(R.id.fab_create)}
    private var fabStatus = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        todoListView.choiceMode = ListView.CHOICE_MODE_MULTIPLE
        todoListView.adapter = itemAdapter
        menuFab.setOnClickListener {
            if (fabStatus) {
                deleteFab.animate().translationY(-150F)
                createFab.animate().translationY(-300F)
                fabStatus = false
            }
            else {
                deleteFab.animate().translationY(0F)
                createFab.animate().translationY(0F)
                fabStatus = true
            }
        }
    }

    private fun viewInitialize(): Array<Task> {
        val things = arrayOf(
            Task("Eat", Calendar.getInstance().time, false),
            Task("Code", Calendar.getInstance().time, false),
            Task("Repeat", Calendar.getInstance().time, false)
        )
        for (i in 0..things.size-1){
            todoListView.setItemChecked(i, things[i].status)
        }
        return things
    }
}