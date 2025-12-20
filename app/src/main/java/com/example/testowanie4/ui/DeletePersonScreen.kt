package com.example.testowanie4.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.IconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun DeletePersonScreen(
    navController: NavController,
    viewModel: PersonViewModel
) {
    val persons by viewModel.persons.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {

//        IconButton(onClick = { navController.popBackStack() }) {
//            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
//        }

        LazyColumn {
            items(persons) { person ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("${person.firstName} ${person.lastName}")
                    Button(onClick = { viewModel.deletePerson(person) }) {
                        Text("Usuń")
                    }
                }
            }
        }
    }
}
