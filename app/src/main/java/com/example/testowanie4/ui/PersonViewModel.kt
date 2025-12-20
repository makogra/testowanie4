package com.example.testowanie4.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testowanie4.data.Person
import com.example.testowanie4.data.PersonDao
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class PersonViewModel(
    private val dao: PersonDao
) : ViewModel() {

    val persons: StateFlow<List<Person>> =
        dao.getAll()
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    fun addPerson(person: Person) {
        viewModelScope.launch {
            dao.insert(person)
        }
    }

    fun deletePerson(person: Person) {
        viewModelScope.launch {
            dao.delete(person)
        }
    }
}