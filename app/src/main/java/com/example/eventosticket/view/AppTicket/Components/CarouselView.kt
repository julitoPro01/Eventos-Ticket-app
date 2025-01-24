package com.example.appticket.View.AppTicket.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.eventosticket.viewModel.EventsViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.yield

//@Preview(showSystemUi = true)
@Composable
fun CarouselView(eventsViewModel: EventsViewModel) {

    var attraction = eventsViewModel.attractions;


    val pagerState = rememberPagerState(initialPage = 0, pageCount = {attraction.size});

    LaunchedEffect(pagerState) {
        while (true){
            yield()
            delay(3000)
            var nextPage = (pagerState.currentPage + 1) % pagerState.pageCount
            pagerState.animateScrollToPage(nextPage)
        }
    }

    HorizontalPager(
        beyondViewportPageCount = attraction.size,
        state =pagerState,
        modifier = Modifier.fillMaxWidth()
    ) { page ->
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(20.dp))
        ){

            Image(
                painter = rememberImagePainter(attraction[page].images.firstOrNull()?.url),
                contentDescription = "evento",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .border(2.dp, Color.Gray, RoundedCornerShape(20.dp)),
                contentScale = ContentScale.Crop
            )

            Box(
                modifier = Modifier


                    .clip(RoundedCornerShape(20.dp))
                    .border(2.dp, Color.Gray, RoundedCornerShape(20.dp))
                    .background(Color(0xFF4A628A))
                    .padding( 15.dp,5.dp)

            ){
            Text(attraction[page].name,
                color = Color.White,
                fontSize = 20.sp)
        }
        }
    }

}