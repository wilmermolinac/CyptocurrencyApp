package com.wamcstudios.aifusion.navigation.utils

import androidx.navigation.NavController
import com.wamcstudios.calorytracker.navigation.utils.UiEvent

// Creamos esta función de extensión donde recibirá un evento UiEvent
fun NavController.navigate(event: UiEvent) {

    // Validamos según sea el caso del evento UiEvent
    when (event) {

        is UiEvent.Navigate -> {


            // this hace referencia al NavController

            // Si es para navegar a una ruta, realizamos la navegación a esa screen
            // pasándole la ruta a navigate
            this.navigate(event.route) {

                /*if (event.route == NavigationGraphRoute.TrackerGraph.route) {
                    popUpTo(graph.id) {
                        inclusive = true
                    }
                }*/


                /*if (event.route == NavigationRoute.Camera.route) {
                    popUpTo(NavigationRoute.Chat.route) {
                        inclusive = true
                    }
                }*/

                /*if (event.route == NavigationRoute.AiArt.route) {
                    popBackStack()
                }*/

                /*if (event.route == NavigationGraphRoute.OnboardingGraph.route) {
                    // asi eliminamos el historial del Graph OnboardingGraph
                    // pasando la ruta de ese Graph en popUpTo
                    popUpTo(NavigationGraphRoute.OnboardingGraph.route) {
                        inclusive = true
                    }
                }*/

                // Si la ruta es "Login", eliminamos el historial de navegación hasta la pantalla de inicio
                /*if (event.route == NavigationRoute.Login.route) {
                    popUpTo(graph.id) {
                        inclusive = true
                    }
                }

                // Si la ruta es "Home", también eliminamos el historial de navegación hasta la pantalla de inicio
                if (event.route == NavigationRoute.Home.route) {
                    popUpTo(graph.id) {
                        inclusive = true
                    }
                }*/
            }

        }

        UiEvent.NavigateUp -> {
            // Si este es el caso, navegamos a la pantalla anterior
            this.navigateUp()
        }

        is UiEvent.ShowSnackBar -> {
            // Si este es el caso y se requiere mostrar una barra de snacks, no hacemos nada
            Unit
        }

        is UiEvent.PreviousBackStackEntry -> {

            // Aqui validamos segun el typo de dato validamos los casos
            when (event.data) {

                is String -> {

                }

                is Boolean -> {

                }

                else -> {
                    // Manejar otros tipos si es necesario
                }
            }

            this.popBackStack()
        }
    }
}
