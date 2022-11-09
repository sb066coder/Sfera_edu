package ru.sb066coder.sferaedu.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.sb066coder.sferaedu.model.Repository
import ru.sb066coder.sferaedu.model.RepositoryImpl

class PeopleViewModel : ViewModel() {

    private val repository: Repository = RepositoryImpl()
    val data01 = repository.getAll(0)
    val data02 = repository.getAll(1)
    val data03 = repository.getAll(2)
    var searchText = MutableLiveData("")
    fun searchData(position: Int, text: String) = repository.getSearchList(position, text)
    fun subscribeById(listNumber: Int, id: Long) = repository.subscribeById(listNumber, id)

}