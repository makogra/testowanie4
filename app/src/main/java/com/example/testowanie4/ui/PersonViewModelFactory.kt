package com.example.testowanie4.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.testowanie4.data.PersonDao

class PersonViewModelFactory(
    private val dao: PersonDao
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PersonViewModel(dao) as T
    }
}
