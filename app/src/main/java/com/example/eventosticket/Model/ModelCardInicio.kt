package com.example.appticket.Model

import com.example.eventosticket.R

class ModelCardInicio {

    data class ModelCard(
        val title:String,
        val img:Int,
        val category:String,
        val date:String,
        val placeEvent:String,
        val price:Double
    )

    fun getCardInicio():List<ModelCard>{

        return listOf(
                ModelCard(title = "Latino Music", img = R.drawable.latino01, category = "Musica",
                    date = "24 de febrero 2024", placeEvent = "Estadio Nacional, Lima", price =70.00 )
                )
                ModelCard(title = "Music Pop", img = R.drawable.evento01, category = "Musica",
                    date = "25 de mayo 2025", placeEvent = "Estado Nacional, lima", price = 50.00)

    }
}