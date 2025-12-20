package com.example.testowanie4.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


@Composable
fun AppNavigation(viewModel: PersonViewModel) {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = false,
                    onClick = { navController.navigate("add") },
                    icon = { Icon(Icons.Default.Add, null) },
                    label = { Text("Dodaj") }
                )
                NavigationBarItem(
                    selected = false,
                    onClick = { navController.navigate("list") },
                    icon = { Icon(Icons.AutoMirrored.Filled.List, null) },
                    label = { Text("Lista") }
                )
                NavigationBarItem(
                    selected = false,
                    onClick = { navController.navigate("delete") },
                    icon = { Icon(Icons.Default.Delete, null) },
                    label = { Text("Usuń") }
                )
            }
        }
    ) { padding ->
        NavHost(
            navController,
            startDestination = "add",
            modifier = Modifier.padding(padding)
        ) {
//            composable("main") { MainScreen(navController) }
            composable("add") { AddPersonScreen(navController, viewModel) }
            composable("list") { ListPersonScreen(navController, viewModel) }
            composable("delete") { DeletePersonScreen(navController, viewModel) }
        }
    }
}
