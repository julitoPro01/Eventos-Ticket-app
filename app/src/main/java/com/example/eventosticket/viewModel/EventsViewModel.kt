package com.example.eventosticket.viewModel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.eventosticket.Service.Attractions
import com.example.eventosticket.Service.Event
import com.example.eventosticket.Service.RetrofitInstance
import kotlinx.coroutines.launch

class EventsViewModel : ViewModel() {
    var events by mutableStateOf(listOf<Event>())
     var attractions by mutableStateOf(listOf<Attractions>())
        private set

    init {
        fetchEvents("3qe2iF1tDxWq2hpXjeDVHbv0TH9FSLHI")
       Attractions("3qe2iF1tDxWq2hpXjeDVHbv0TH9FSLHI")
    }

    fun fetchEvents(apiKey: String) {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getEvents(apiKey)
                events = response._embedded.events
                Log.d("EventsViewModel", "Eventos cargados: ${events.size}")
            } catch (e: Exception) {
                Log.e("EventsViewModel", "Error al cargar eventos: ${e.message}")
            }
        }
    }

    fun Attractions(apiKey: String) {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api2.getAttractions(apiKey)
                attractions = response._embedded.attractions
                Log.d("EventsViewModel", "Eventos cargados: ${events.size}")
            } catch (e: Exception) {
                Log.e("EventsViewModel", "Error al cargar eventos: ${e.message}")
            }
        }
    }

}
