package com.example.todolist

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.TextView
import com.example.todolist.datamodel.Task

class TaskListAdapter (private val context: Activity, private val taskArray: Array<Task>):
    ArrayAdapter<Task>(context, R.layout.custom_list_item, taskArray){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val customListItem = inflater.inflate(R.layout.custom_list_item, null, true)
        val task = customListItem.findViewById<TextView>(R.id.task)
        val date = customListItem.findViewById<TextView>(R.id.date)
        val status = customListItem.findViewById<CheckBox>(R.id.status)
        task.text = taskArray[position].description
        date.text = taskArray[position].getDateString()
        status.isActivated = taskArray[position].status
        return customListItem
    }
}