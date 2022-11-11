package com.collathon.librarycnu.android

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.collathon.librarycnu.android.ui.HomeScreen




// todo : fill the Screen Class
enum class LibScreens(val title: String) {
    Home(title= "home"),
    ReserveSeat(title= "reserveSeat"),
    BookService(title = "BookService"),
    RenewBooks(title = "renewBooks"),
    FindBooks(title = "findBooks"),
    MyLibrary(title = "myLibrary")
}


@Preview
@Composable
fun MainApp(
    modifier: Modifier = Modifier.fillMaxSize()
) {
    var navController = rememberNavController()
    Scaffold(
        topBar = { MyTopBar(navController) }
    ) {innerPadding ->
        NavHost(
            navController = navController,
            startDestination = LibScreens.Home.title,
            modifier = modifier.padding(innerPadding)
        ) {
            // todo : fill the composable
            composable(LibScreens.Home.title) {
                HomeScreen()
            }
            composable(LibScreens.ReserveSeat.title) {
                HomeScreen()
            }
            composable(LibScreens.BookService.title) {
                HomeScreen()
            }
            composable(LibScreens.RenewBooks.title) {
                HomeScreen()
            }
            composable(LibScreens.FindBooks.title) {
                HomeScreen()
            }
            composable(LibScreens.MyLibrary.title) {
                HomeScreen()
            }

        }
        
    }
}



@Composable
fun MyTopBar(navController: NavHostController) {
    TopAppBar(
        contentColor = Color(0xFF000D4F),
        backgroundColor = Color.White,
        title = {
            Row() {
                Text("충남대학교 ", fontSize = 20.sp, fontWeight = FontWeight.ExtraBold,)
                Text("도서관", fontSize = 20.sp, fontWeight = FontWeight.Normal)
            } },
        navigationIcon = {
            IconButton(onClick = { navController.navigate(LibScreens.Home.title) }) {
                Image(
                    painter = painterResource(id = R.drawable.ic_logo),
                    contentDescription = "logo" ,
                    modifier = Modifier.size(45.dp)
                )
            }
        },
        actions = {
            IconButton(onClick = { /*TODO : Show modal with all menu */ }) {
                Icon(
                    imageVector = Icons.Rounded.Menu,
                    contentDescription = "Menu",
                    tint = Color(0xFF000D4F)
                )
            }
        }
    )
}

