package com.example.prayerbuddy.presentation.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.prayerbuddy.presentation.ui.theme.PrayerBuddyTheme
import com.example.prayerbuddy.presentation.viewmodel.HomeViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {

    val data = viewModel.data.collectAsState()
    val loading = viewModel.loading.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color(0xff2591a9))
    ) {

        //Date
        Column(
            modifier = modifier
                .align(alignment = Alignment.CenterHorizontally)
                .padding(16.dp)
        ) {
            Text(
                text = "Today:",
                color = Color(0xff1d1b20),
                style = TextStyle(fontSize = 14.sp)
            )

            Column(
                modifier = modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(8.dp))
                    .background(color = Color(0xffcaf5ff))
                    .align(alignment = Alignment.CenterHorizontally)
                    .padding(16.dp)
            ) {
                Text(
                    text = data.value.gregorianDate,
                    color = Color(0xff1d1b20),
                    style = TextStyle(fontSize = 14.sp)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = data.value.hijriDate,
                    color = Color(0xff1d1b20),
                    style = TextStyle(fontSize = 14.sp)
                )
            }
        }

        //Location
        Column(
            modifier = modifier
                .align(alignment = Alignment.CenterHorizontally)
                .padding(16.dp)
        ) {
            Text(
                text = "Location:",
                color = Color(0xff1d1b20),
                style = TextStyle(fontSize = 14.sp)
            )

            Column(
                modifier = modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(8.dp))
                    .background(color = Color(0xffcaf5ff))
                    .align(alignment = Alignment.CenterHorizontally)
                    .padding(16.dp)
            ) {
                Text(
                    text = "110 Lathom Road, E6 2DY, London,UK",
                    color = Color(0xff1d1b20),
                    style = TextStyle(fontSize = 14.sp)
                )
            }
        }

        //Prayer time
        Column(
            modifier = modifier
                .align(alignment = Alignment.CenterHorizontally)
                .padding(16.dp)
        ) {
            Text(
                text = "Prayer:",
                color = Color(0xff1d1b20),
                style = TextStyle(fontSize = 14.sp)
            )

            Row(
                modifier = modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(8.dp))
                    .background(color = Color(0xffcaf5ff))
                    .align(alignment = Alignment.CenterHorizontally)
                    .padding(16.dp)
            ) {
                Column(

                ) {
                    Text(
                        text = "Now Asr",
                        color = Color(0xff1d1b20),
                        style = TextStyle(fontSize = 20.sp)
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = data.value.asr,
                        color = Color(0xff1d1b20),
                        style = TextStyle(fontSize = 18.sp)
                    )
                }
                Spacer(Modifier.weight(1f))
                Column(
                    horizontalAlignment = Alignment.End
                ) {
                    Text(
                        text = "Next Magrib",
                        color = Color(0xff1d1b20),
                        textAlign = TextAlign.End,
                        style = TextStyle(fontSize = 20.sp)
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = data.value.maghrib,
                        color = Color(0xff1d1b20),
                        style = TextStyle(fontSize = 18.sp)
                    )
                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    PrayerBuddyTheme {
        HomeScreen()
    }
}