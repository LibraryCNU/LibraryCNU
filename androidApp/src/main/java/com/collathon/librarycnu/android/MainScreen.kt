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
import com.collathon.librarycnu.android.ui.ReserveSeatScreen
import com.collathon.librarycnu.android.ui.MyLibraryScreen
import com.collathon.librarycnu.android.ui.RenewBooksScreen
import com.collathon.librarycnu.android.ui.BookServiceScreen
import com.collathon.librarycnu.android.ui.FindBooksScreen
import com.collathon.librarycnu.shared.SDKForAndroid


// todo : fill the Screen Class
enum class LibScreens(val title: String) {
    Home(title= "home"),
    ReserveSeat(title= "reserveSeat"),
    BookService(title = "BookService"),
    RenewBooks(title = "renewBooks"),
    FindBooks(title = "findBooks"),
    MyLibrary(title = "myLibrary")
}


@Composable
fun MainApp(
    sdk : SDKForAndroid,
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
                HomeScreen (navController = navController, sdk = sdk)
            }
            composable(LibScreens.ReserveSeat.title) {
                ReserveSeatScreen(
                    sdk = sdk
                    //navController = navController
                )
            }
            composable(LibScreens.BookService.title) {
                BookServiceScreen(
                    sdk = sdk
                    //navController = navController
                )
            }
            composable(LibScreens.RenewBooks.title) {
                RenewBooksScreen(
                    //navController = navController
                )
            }
            composable(LibScreens.FindBooks.title) {
                FindBooksScreen(
                    //navController = navController
                )
            }
            composable(LibScreens.MyLibrary.title) {
                MyLibraryScreen(
                    //navController = navController
                )
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
                Text("??????????????? ", fontSize = 20.sp, fontWeight = FontWeight.ExtraBold,)
                Text("?????????", fontSize = 20.sp, fontWeight = FontWeight.Normal)
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

