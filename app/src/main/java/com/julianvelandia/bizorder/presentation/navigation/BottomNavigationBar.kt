package com.julianvelandia.bizorder.presentation.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        Screen.Create,
        Screen.Home,
        Screen.PreOrders
    )

    NavigationBar {
        // current route to change the icon color,label color when navigated
        val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
        items.forEach { screen ->
            NavigationBarItem(
                icon = { Icon(screen.icon, contentDescription = screen.title) },
                label = { Text(screen.title) },
                selected = currentRoute == screen.route,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        // Si el destino al que navegas ya está en la cima del back stack,
                        // en lugar de crear una nueva instancia, reutiliza la existente.
                        // Evita duplicados si haces clic varias veces en el mismo botón o evento.
                        restoreState = true
                        // Si saveState fue true al hacer popUpTo (como en tu ejemplo),
                        //cuando regreses a esa pantalla (que quedó "guardada"),
                        // se restaura exactamente su estado anterior: scroll, inputs, etc.
                    }
                }
            )
        }
    }
}