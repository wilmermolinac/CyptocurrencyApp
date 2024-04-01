package com.wamcstudios.calorytracker.navigation.utils

import androidx.annotation.DrawableRes
import com.wamcstudios.cyptocurrencyapp.core.utils.UiText

// Clase encargada de los eventos de la ui
sealed class UiEvent {
    data class Navigate(val route: String) : UiEvent()
    object NavigateUp : UiEvent()

    data class PreviousBackStackEntry(val data: Any) : UiEvent()
    data class ShowSnackBar(
        val message: UiText,
        @DrawableRes val icon: Int? = null,
        val isSnackBarError: Boolean = false,
    ) : UiEvent()

}

/*Explicación:

sealed class UiEvent: Es una clase sellada que define un conjunto específico de subclases selladas
(en este caso, Navigate, NavigateUp, y ShowSnackBar). Una clase sellada es útil cuando tienes un
conjunto finito de subtipos y quieres que todos estos subtipos estén definidos en el mismo archivo.

data class Navigate(val route: String) : UiEvent(): Una clase de datos que representa un evento de
navegación. Contiene un parámetro route que indica la ruta a la que se desea navegar.

object NavigateUp : UiEvent(): Un objeto único que representa un evento de navegación hacia atrás.
Al utilizar object, se crea una única instancia de esta clase, ya que no tiene ningún parámetro.
Este objeto se utiliza para indicar que se debe realizar una acción de navegación hacia atrás.

data class ShowSnackBar(val message: UiText): UiEvent(): Una clase de datos que representa un
evento para mostrar una barra de snacks. Contiene un parámetro message de tipo UiText,
que probablemente sea un mensaje que se mostrará en la barra de snacks.

En resumen, UiEvent es una clase sellada que encapsula diferentes tipos de eventos relacionados con
la interfaz de usuario. Cada subclase dentro de UiEvent representa un tipo específico de evento,
como navegación a una ruta, navegación hacia atrás o mostrar una barra de snacks.*/

