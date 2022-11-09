package ru.sb066coder.sferaedu.model

import androidx.lifecycle.LiveData
import ru.sb066coder.sferaedu.adapter.Person


interface Repository {
    fun getAll(listNumber: Int): LiveData<List<Person>>
    fun subscribeById(listNumber: Int, id: Long)
    fun getSearchList(listNumber: Int, text: String): List<Person>
}