package com.collathon.librarycnu.android.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.collathon.librarycnu.android.R
import com.collathon.librarycnu.android.ui.components.BlockTitleText
import com.collathon.librarycnu.android.ui.components.SubTitleText
import com.collathon.librarycnu.shared.domain.entity.Seat
import kotlinx.datetime.LocalDateTime

/*
* 열람 좌석 예약하는 ui
* */


@Preview
@Composable
fun ReserveSeatScreen(
    modifier: Modifier = Modifier.fillMaxSize(),
    verticalArrangement: Arrangement.HorizontalOrVertical = Arrangement.Center,
    horizontalAlignment: Alignment.Horizontal = Alignment.CenterHorizontally

) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE7EAF0))
    ) {
        ReservemenuBlock1()
        ReserveSeatImage()
        SearchBlock()
        ColList()
    }
}

@Composable
fun ReserveSeatImage() {
    Box(
        modifier = Modifier
            .padding(10.dp)
    ) {
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .width(380.dp)
                .height(300.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
            shape = RoundedCornerShape(5.dp),
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image (
                    modifier = Modifier.width(360.dp).height(300.dp),
                    painter = painterResource(id = R.drawable.cellimage),
                    contentDescription = ""

                )
            }
        }
    }
}

@Composable
fun ReservemenuBlock1(
) {
    Box(
        modifier = Modifier
            .padding(10.dp),
    ) {
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .width(380.dp)
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFC1C8DA)),
            shape =  RoundedCornerShape(5.dp),
        ) {
            Row(modifier = Modifier
                .padding(0.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    modifier = Modifier
                        .width(55.dp)
                        .height(45.dp)
                        .fillMaxHeight(),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                    onClick = { /*TODO*/ }
                ) {
                    BlockTitleText(contents = "B2")
                    //PaddingValues(5.dp)
                }
                Spacer(
                    modifier = Modifier
                        .width(20.dp))
                Column(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    BlockTitleText(contents = "Learning Commons")
                }
                Spacer(
                    modifier = Modifier
                        .width(110.dp))
            }
        }
    }
}

@Composable
fun SearchBlock(
) {
    Box (
        modifier = Modifier
            .padding(10.dp)
            .width(380.dp)
            .height(45.dp)
    ) {
        Row (modifier = Modifier) {
            Spacer(modifier = Modifier.width(5.dp))
            Icon (
                modifier = Modifier
                    .width(25.dp)
                    .height(40.dp),
                painter = painterResource(id = R.drawable.icon_search),
                contentDescription = null,
            )
            Spacer(modifier = Modifier.width(5.dp))
            Button(
                modifier = Modifier
                    .width(200.dp)
                    .height(40.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFE7EAF0)),
                elevation = null,
                onClick = { /*TODO*/ }
            ) {
                SubTitleText("원하는 정보를 검색하세요.")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(
                modifier = Modifier
                    .width(75.dp)
                    .height(35.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFC1C8DA)),
                shape =  RoundedCornerShape(15.dp),
                onClick = { /*TODO*/ }
            ) {
                SubTitleText(contents = "좌석순")
            }
            Spacer(modifier = Modifier.width(10.dp))
            Icon (
                modifier = Modifier
                    .width(30.dp)
                    .height(40.dp),
                painter = painterResource(id = R.drawable.ic_module),
                contentDescription = null,
            )
            Spacer(modifier = Modifier.width(10.dp))
        }
    }
}

@Composable
fun ColList() {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        itemsIndexed(
            listOf(
                Seat(1, "Creator Room", true, LocalDateTime.parse("2022-01-01T21:00:00"), LocalDateTime.parse("2022-01-01T21:00:00"), true, true),
                Seat(2, "Creator Room", false, LocalDateTime.parse("2022-01-01T21:00:00"), LocalDateTime.parse("2022-01-01T21:00:00"), true, false),
                Seat(3, "Creator Room", true, LocalDateTime.parse("2022-01-01T21:00:00"), LocalDateTime.parse("2022-01-01T21:00:00"), true, true),
                Seat(4, "Creator Room", false, LocalDateTime.parse("2022-01-01T21:00:00"), LocalDateTime.parse("2022-01-01T21:00:00"), true, true),
                Seat(5, "Creator Room", true, LocalDateTime.parse("2022-01-01T21:00:00"), LocalDateTime.parse("2022-01-01T21:00:00"), false, true),
                Seat(6, "Creator Room", true, LocalDateTime.parse("2022-01-01T21:00:00"), LocalDateTime.parse("2022-01-01T21:00:00"), true, true),
                Seat(7, "Creator Room", false, LocalDateTime.parse("2022-01-01T21:00:00"), LocalDateTime.parse("2022-01-01T21:00:00"), true, false),
                Seat(8, "Creator Room", true, LocalDateTime.parse("2022-01-01T21:00:00"), LocalDateTime.parse("2022-01-01T21:00:00"), true, true),
                Seat(9, "Creator Room", true, LocalDateTime.parse("2022-01-01T21:00:00"), LocalDateTime.parse("2022-01-01T21:00:00"), true, true),
                )
        ) {index, item ->
            ColItemCard(item)
        }
    }
}

@Composable
fun Seat1(
    id: Int,
    place: String,
    plugExistence: Boolean,
    startTime: LocalDateTime,
    endTime: LocalDateTime,
    canReserve: Boolean,
    favorite: Boolean
) {

}

@Composable
fun ColItemCard(data: Seat) {
    Card(
        modifier = Modifier
            .padding(end = 10.dp)
            .fillMaxWidth(),
        shape = MaterialTheme.shapes.small.copy(CornerSize(10.dp)),
        elevation = 10.dp
    ) {
        Surface(shape = MaterialTheme.shapes.small.copy(CornerSize(10.dp))) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                ItemText(data)
            }
        }
    }
    Spacer(modifier = Modifier.height(5.dp))

}

@Composable
fun ItemText(data: Seat) {
    Row(
        Modifier.padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Icon (
            modifier = Modifier
                .width(30.dp)
                .height(40.dp),
            tint = Color(0xFF428BC6),
            painter = painterResource(id = R.drawable.ellipse),
            contentDescription = null,
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = "00"+data.id.toString(), fontSize = 20.sp, color = Color.Black, modifier = Modifier.fillMaxHeight())
        Spacer(modifier = Modifier.width(180.dp))
        Row(
            Modifier.padding(5.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround

        ) {
            if (data.plugExistence) {
                Icon (
                    modifier = Modifier
                        .width(30.dp)
                        .height(40.dp),
                    painter = painterResource(id = R.drawable.ic_plug),
                    contentDescription = null,
                )
            }
            else {
                Spacer(modifier = Modifier.width(30.dp))
            }
            Spacer(modifier = Modifier.width(10.dp))
            Icon (
                modifier = Modifier
                    .width(30.dp)
                    .height(40.dp),
                painter = painterResource(id = R.drawable.ic_heart),
                contentDescription = null,
            )
        }
    }
}