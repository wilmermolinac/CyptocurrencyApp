package com.wamcstudios.cyptocurrencyapp.core.utils

import android.content.Context

// Creamos esta Clase Auxiliar para que nos ayude con los Strings
sealed class UiText {

    // Esta clase recibe un string dinámico
    data class DynamicString(val text: String) : UiText()

    // Esta clase recibe un recurso de cadena (String resource)
    data class StringResource(val resId: Int) : UiText()

    // Esta función nos ayuda a convertir el UiText a un String
    fun asString(context: Context): String {
        // Retornamos dependiendo de lo que se esté procesando, ya sea una DynamicString o StringResource
        return when (this) {
            // Si es un DynamicString, simplemente devolvemos el texto
            is DynamicString -> {
                text
            }

            // Si es un StringResource, obtenemos el texto string del recurso utilizando el contexto proporcionado
            is StringResource -> {
                context.getString(resId)

            }
        }
    }
}

/*Explicación:

sealed class UiText: Es una clase sellada que define un conjunto específico de subclases selladas
(en este caso, DynamicString y StringResource),
una clase sellada es útil cuando tienes un conjunto finito de subtipos y quieres que todos estos
subtipos estén definidos en el mismo archivo.

data class DynamicString(val text: String) : UiText(): Una clase de datos que representa un string dinámico.
 Contiene un parámetro text que es el texto dinámico que se desea mostrar.

data class StringResource(val resId: Int) : UiText(): Una clase de datos que representa un recurso de cadena.
Contiene un parámetro resId que es el identificador del recurso de cadena en los recursos de la aplicación.

fun asString(context: Context): String: Una función que convierte una instancia de UiText a un String.
Esta función utiliza el contexto proporcionado para obtener el string correspondiente,
ya sea directamente desde el text en caso de DynamicString, o mediante el resId en caso de StringResource.

En resumen, UiText es una clase sellada que proporciona una abstracción para trabajar con textos en
la interfaz de usuario. Puede representar tanto strings dinámicos como recursos de cadena, y la
función asString facilita la obtención del texto correspondiente.*/
