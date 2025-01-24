package com.example.eventosticket.Service


data class EventResponse(
    val _embedded: EmbeddedEvents
)

data class EmbeddedEvents(
    val events: List<Event>
)


data class Event(
    val name: String,
    val type: String,
    val id: String,
    val url: String,
    val images: List<Image>,
    val promoter: Promoter,
    val locale :String,
    val sales : Sales
)


data class Image(
    val ratio: String,
    val url: String,
    val width: Int,
    val height: Int
)

data class Promoter(
    val id:String,
    val name: String,
    val description:String
)

data class Sales(
    val public:Public
)

data class Public(
   val startDateTime:String
)

data class EventResponseAtt(
    val _embedded: EmbeddedAtt
)

data class EmbeddedAtt(
    val attractions: List<Attractions>
)
data class Attractions(
    val name: String,
    val type: String,
    val id: String,
    val url: String,
    val images: List<Image>,
)
