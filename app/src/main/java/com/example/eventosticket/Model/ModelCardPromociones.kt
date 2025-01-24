package com.example.appticket.Model

import com.example.appticket.Model.ModelCardInicio.ModelCard
import com.example.eventosticket.R

class ModelCardPromociones {
    data class ModelCardP(
        val title:String,
        val img:Int,
        val category:String,
        val date:String,
        val placeEvent:String,
        val price:Double,
        val discount:Int
    )

    fun getCardPromociones():List<ModelCardP>{

        return listOf(
            ModelCardP(title = "Latino Music", img = R.drawable.latino01, category = "Musica",
                date = "24 de febrero 2024", placeEvent = "Estadio Nacional, Lima", price =70.00,
                discount = 40
                ),
            ModelCardP(title = "Music Pop", img = R.drawable.evento01, category = "Musica",
                date = "25 de mayo 2025", placeEvent = "Estado Nacional, lima",
                price = 50.00, discount =50 ),
            ModelCardP(title = "Music Pop", img = R.drawable.evento01, category = "Musica",
                date = "25 de mayo 2025", placeEvent = "Estado Nacional, lima",
                price = 50.00, discount =50 ),
            ModelCardP(title = "Music Pop", img = R.drawable.evento01, category = "Musica",
                date = "25 de mayo 2025", placeEvent = "Estado Nacional, lima",
                price = 50.00, discount =50 ),
            ModelCardP(title = "Music Pop", img = R.drawable.evento01, category = "Musica",
                date = "25 de mayo 2025", placeEvent = "Estado Nacional, lima",
                price = 50.00, discount =50 ),

        )

    }
}