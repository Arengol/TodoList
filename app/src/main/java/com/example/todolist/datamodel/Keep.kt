package com.example.todolist.datamodel

import java.util.Date

data class Keep(var description: String, var date: Date, var isDone: Boolean)
{
    override fun toString(): String {
        return super.toString()
    }
}