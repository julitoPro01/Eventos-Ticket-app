package com.example.eventosticket.Service

import retrofit2.http.GET
import retrofit2.http.Query

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://app.ticketmaster.com/"

    val api: TicketmasterApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TicketmasterApi::class.java)
    }

    val api2: TicketAttractionsApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TicketAttractionsApi::class.java)
    }
}

interface TicketmasterApi {
    @GET("discovery/v2/events.json")
    suspend fun getEvents(
        @Query("apikey") apiKey: String,
       // @Query("countryCode") countryCode: String
    ): EventResponse
}

interface TicketAttractionsApi {
    @GET("discovery/v2/attractions.json")
    suspend fun getAttractions(
        @Query("apikey") apiKey: String,
        // @Query("countryCode") countryCode: String
    ): EventResponseAtt
}