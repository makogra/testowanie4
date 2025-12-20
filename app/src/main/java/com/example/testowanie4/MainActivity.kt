package com.example.testowanie4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.testowanie4.data.AppDatabase
import com.example.testowanie4.ui.AppNavigation
import com.example.testowanie4.ui.MainScreen
import com.example.testowanie4.ui.PersonViewModel
import com.example.testowanie4.ui.PersonViewModelFactory
import com.example.testowanie4.ui.theme.Testowanie4Theme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Inicjalizacja bazy danych
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


//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContent {
//            Testowanie4Theme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    MainScreen()
////                    Greeting(
////                        name = "Android",
////                        modifier = Modifier.padding(innerPadding)
////                    )
//                }
//            }
//        }
//    }
//}

