package com.example.prayerbuddy.presentation.ui.home

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.prayerbuddy.common.utils.Constants
import com.example.prayerbuddy.common.utils.GenericError
import com.example.prayerbuddy.common.utils.ProgressBar
import com.example.prayerbuddy.presentation.ui.theme.PrayerBuddyTheme
import com.example.prayerbuddy.presentation.viewmodel.HomeViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {

    val data = viewModel.data.collectAsState()
    val loading = viewModel.loading.collectAsState()
    val error = viewModel.error.collectAsState()
    val currentPrayer = viewModel.currentPrayer.collectAsState()
    val nextPrayer = viewModel.nextPrayer.collectAsState()

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
                .testTag("date_column_test_tag")
        ) {
            Text(
                text = "Today:",
                color = Color(0xff1d1b20),
                style = TextStyle(fontSize = 14.sp),
                modifier = Modifier.testTag("date_label_test_tag")
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
                    text = data.value.gregorianDate + " Gregorian",
                    color = Color(0xff1d1b20),
                    style = TextStyle(fontSize = 14.sp)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text =  data.value.hijriDate + " Hijri" ,
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
                .testTag("location_column_test_tag")
        ) {
            Text(
                text = "Location:",
                color = Color(0xff1d1b20),
                style = TextStyle(fontSize = 14.sp),
                modifier = Modifier.testTag("location_label_test_tag")
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
                .testTag("prayer_time_column_test_tag")
        ) {
            Text(
                text = "Prayer:",
                color = Color(0xff1d1b20),
                style = TextStyle(fontSize = 14.sp),
                modifier = Modifier.testTag("prayer_time_label_test_tag")
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
                        text = Constants.NOW + " " + currentPrayer.value.name,
                        color = Color(0xff1d1b20),
                        style = TextStyle(fontSize = 20.sp)
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = currentPrayer.value.time,
                        color = Color(0xff1d1b20),
                        style = TextStyle(fontSize = 18.sp)
                    )
                }
                Spacer(Modifier.weight(1f))
                Column(
                    horizontalAlignment = Alignment.End
                ) {
                    Text(
                        text = Constants.NEXT + " " + nextPrayer.value.name,
                        color = Color(0xff1d1b20),
                        textAlign = TextAlign.End,
                        style = TextStyle(fontSize = 20.sp)
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = nextPrayer.value.time,
                        color = Color(0xff1d1b20),
                        style = TextStyle(fontSize = 18.sp)
                    )
                }
            }
        }

    }

    ProgressBar(
        isLoading = loading.value,
        modifier = Modifier
    )

    GenericError(
        errorText = error.value,
        modifier = Modifier
    )

}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    PrayerBuddyTheme {
        HomeScreen()
    }
}