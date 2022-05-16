package com.example.todolist.datamodel

import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Date

data class Task(var description: String, var date: Date, var status: Boolean)
{
    fun getDateString(): String {
        return SimpleDateFormat("dd.MM.yyyy").format(date)
    }
}