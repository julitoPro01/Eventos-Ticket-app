package com.example.appticket.Model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.eventosticket.R

class ModelCarousel {

    data class CarouselItem(
        val id:Int,
        @DrawableRes val img: Int,
        @StringRes val description: Int
    )

    fun getItemCarousel():List<CarouselItem>{
        return  listOf(
            CarouselItem(id = 0, img = R.drawable.evento01, description = R.string.app_name) ,
            CarouselItem(id = 1, img = R.drawable.latino01, description = R.string.app_name),
            CarouselItem(id = 2, img = R.drawable.evento01, description = R.string.app_name)
        )
    }

}