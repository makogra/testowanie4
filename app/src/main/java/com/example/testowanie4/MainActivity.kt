package com.example.testowanie4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.testowanie4.data.AppDatabase
import com.example.testowanie4.ui.AppNavigation
import com.example.testowanie4.ui.PersonViewModel
import com.example.testowanie4.ui.PersonViewModelFactory
import com.example.testowanie4.ui.theme.Testowanie4Theme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "person_db"
        ).build()

        val dao = database.personDao()

        // ViewModel z Factory
        val viewModelFactory = PersonViewModelFactory(dao)
        val viewModel = ViewModelProvider(this, viewModelFactory)[PersonViewModel::class.java]

        setContent {
            Testowanie4Theme {
                AppNavigation(viewModel = viewModel)
            }
        }
    }
}

