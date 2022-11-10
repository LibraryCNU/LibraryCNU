package com.collathon.librarycnu.android.ui

import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.collathon.librarycnu.android.R

/*
* 도서 서비스를 전체적으로 담당하는 ui
* */

enum class BookServiceScreen(val title: String) {
    NewBooks(title = "newBooks"),
    Bestsellers(title = "Bestsellers"),
    RecommendedBooks(title = "RecommendedBooks"),
}

data class BookInfoModel(
    val id: Int,
    val name: String,
    val author: String,
    val date: String
)

@Preview
@Composable
fun BookServiceScreen(
    modifier: Modifier = Modifier,
    verticalArrangement: Arrangement.HorizontalOrVertical = Arrangement.Center,
    horizontalAlignment: Alignment.Horizontal = Alignment.CenterHorizontally

) {
    val scrollState = rememberScrollState()
    val bookState = remember { mutableStateOf(BookServiceScreen.NewBooks) }
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFFE7EAF0))
        .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(modifier = Modifier
            .height(350.dp)
        ) {
            BackgroundGradation(bookState)
            BookPreView(bookState, boxModifier = Modifier
                .align(Alignment.BottomCenter))
        }
        FindBookButton()
        CheckoutService()
        Spacer(modifier = Modifier.height(50.dp))
    }
}

@Composable
fun BackgroundGradation(
    bookState: MutableState<BookServiceScreen>
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        Color(0xFF24B2C2),
                        Color(0xFF1771B6),
                        Color(0xFF1771B6)
                    )
                )
            )
            .padding(horizontal = 10.dp)
    ) {
        BookNav(bookState)
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BookPreView(
    bookState: MutableState<BookServiceScreen>,
    boxModifier: Modifier
) {
    val bookListState = remember { mutableStateOf(0) }

    val bookList = listOf(
        painterResource(R.drawable.learning_javascript),
        painterResource(R.drawable.sapiens)
    )

    Box(modifier = boxModifier) {
        val width = 96.dp
        val squareSize = 48.dp

        val swipeableState = rememberSwipeableState(0)
        val sizePx = with(LocalDensity.current) { squareSize.toPx() }
        val anchors = mapOf(0f to 0, sizePx to 1)
        Image(
            painter = bookList[bookListState.value],
            contentDescription = "learning_javascript",
            modifier = Modifier
                .size(250.dp)
                .align(Alignment.BottomCenter)
                .swipeable(
                    state = swipeableState,
                    anchors = anchors,
                    thresholds = { _, _ -> FractionalThreshold(0.3f) },
                    orientation = Orientation.Horizontal
                )
        )
    }
}

@Composable
fun BookNav(
    bookState: MutableState<BookServiceScreen>
) {
    Row(
        modifier = Modifier
            .height(50.dp)
            .fillMaxWidth()
            .padding(horizontal = 60.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        BookNavButton(bookState, BookServiceScreen.NewBooks, "신착 도서")
        Divider(color = Color.White, modifier = Modifier
            .height(15.dp)
            .width(0.4.dp))
        BookNavButton(bookState, BookServiceScreen.Bestsellers, "인기 도서")
        Divider(color = Color.White, modifier = Modifier
            .height(15.dp)
            .width(0.4.dp))
        BookNavButton(bookState, BookServiceScreen.RecommendedBooks, "추천 도서")
    }
}

@Composable
fun CheckoutService() {
    val scrollState = rememberScrollState()
    Column(modifier = Modifier
        .height(330.dp)
        .width(350.dp)
        .clip(shape = RoundedCornerShape(20.dp))
        .background(Color.White),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 15.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "대출 조회/연장",
                fontSize = 15.sp,
                fontWeight = FontWeight.ExtraBold
            )
            Text(
                text = "더 알아보기 >",
                color = Color.Gray
            )
        }
        Divider(
            color = Color.Gray,
            modifier = Modifier
                .height(0.4.dp)
                .fillMaxWidth()
        )
        LazyColumn {
            itemsIndexed(
                listOf(
                    BookInfoModel(1, "컴파일러", "박두순", "2022-10-17"),
                    BookInfoModel(2, "컴파일러", "박두순", "2022-10-17"),
                    BookInfoModel(3, "컴파일러", "박두순", "2022-10-17"),
                    BookInfoModel(4, "컴파일러", "박두순", "2022-10-17"),
                    BookInfoModel(5, "컴파일러", "박두순", "2022-10-17"),
                    BookInfoModel(6, "컴파일러", "박두순", "2022-10-17"),
                    BookInfoModel(7, "컴파일러", "박두순", "2022-10-17"),
                    BookInfoModel(8, "컴파일러", "박두순", "2022-10-17"),
                    BookInfoModel(9, "컴파일러", "박두순", "2022-10-17"),
                    BookInfoModel(10, "컴파일러", "박두순", "2022-10-17"),
                    BookInfoModel(11, "컴파일러", "박두순", "2022-10-17"),
                )
            ) { index, item ->
                BookInfo(item.id, item.name, item.author, item.date)
            }
        }
    }
}

@Composable
fun BookInfo(number: Int, bookName: String, author: String, date: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row() {
            CheckBoxDemo()
            Text(
                modifier = Modifier
                    .padding(vertical = 15.dp),
                text = number.toString(),
                fontWeight = FontWeight.ExtraBold
            )
        }
        Text(
            modifier = Modifier
                .padding(vertical = 15.dp),
            text = "$bookName/$author 지음",
            fontSize = 13.sp
        )
        Text(
            modifier = Modifier
                .padding(vertical = 15.dp),
            text = date,
            fontSize = 13.sp
        )
    }
}

@Composable
fun CheckBoxDemo() {
    val checkedState = remember { mutableStateOf(false) }
    Checkbox(
        checked = checkedState.value,
        onCheckedChange = { checkedState.value = it }
    )
}

@Composable
fun FindBookButton() {
    Surface(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 30.dp)
        .offset(x = 50.dp),
        color = Color.Transparent
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .height(85.dp)
            .clip(shape = RoundedCornerShape(50.dp))
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        Color(0xFF1771B6),
                        Color(0xFF1771B6),
                        Color(0xFF24B2C2)
                    )
                )
            ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_arrow),
                contentDescription = "Arrow Icon",
                tint = Color.White,
                modifier = Modifier.size(40.dp)
            )
            Column(modifier = Modifier
                .padding(horizontal = 40.dp)
            ) {
                Text(
                    text = "책 찾으러 가기",
                    color = Color.White,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.ExtraBold
                )
                Text(
                    text = "책을 검색하면 위치를 알려드립니다.",
                    color = Color.White
                )
            }
        }
    }
}

@Composable
fun BookNavButton(
    bookState: MutableState<BookServiceScreen>,
    bookServiceScreen: BookServiceScreen,
    text: String,
) {
    val alpha = if (bookState.value == bookServiceScreen) 0.3F else 0F

    Button(modifier = Modifier.height(32.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White.copy(
                alpha = alpha,
            )
        ),
        elevation = null,
        shape = RoundedCornerShape(7.dp),
        onClick = {
            bookState.value = bookServiceScreen
        }) {
        Text(text = text, color = Color.White, fontSize = 16.sp)
    }
}
