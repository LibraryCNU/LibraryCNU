package com.collathon.librarycnu.android.ui.components

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.collathon.librarycnu.shared.SDKForAndroid
import com.collathon.librarycnu.shared.domain.entity.Student
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun StudentInfoBar(
    modifier: Modifier,
    sdk : SDKForAndroid
) {

    // get Student
    val composableScope = rememberCoroutineScope()
    var student : Student = Student("", "", "", "", "", "", "")
    var studentState = remember { mutableStateOf(student) }
    val getStudent: () -> Unit = {
        composableScope.launch {
            student = sdk.getStudentInfoUseCase().execute("chung")
            studentState.value = student
        }
    }

    getStudent()

    Row (modifier) {
        Box(
            modifier
                .padding(horizontal = 30.dp, vertical = 15.dp)
        ) {
            StudentInfoField(Modifier.align(Alignment.TopStart), studentState)
            StudentStatusBar(Modifier.align(Alignment.TopEnd), studentState)
        }
    }
}

// todo : student info import
@Composable
fun StudentInfoField(
    modifier: Modifier,
    studentState : MutableState<Student>
) {
    Column(modifier) {
        Row {
            TitleText(contents = studentState.value.name , Color.Black)
            Spacer(modifier = Modifier.width(10.dp))
            SubTitleText(contents = "Kim Chungnam", Color(0xFF777777))
        }
        Spacer(modifier = Modifier.height(2.dp))
        SubTitleText(contents = studentState.value.studentId , Color(0xFF777777))
        Spacer(modifier = Modifier.height(2.dp))
        SubTitleText(contents = studentState.value.department, Color(0xFF777777))
    }
}



@Composable
fun StudentStatusBar(
    modifier: Modifier,
    studentState : MutableState<Student>
) {
    val isAttending = if (studentState.value.isAttending == "true") "재학중" else "휴학"
    Card(
        shape = RoundedCornerShape(20.dp),
        elevation = 0.dp,
        backgroundColor = Color(0xFFE7EAF0),
        modifier = modifier,
        border = BorderStroke(0.4.dp, Color.LightGray),
    )
    {
        Text(text = isAttending,
            modifier = Modifier.padding(horizontal = 22.dp, vertical = 8.dp),
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF777777))
    }
}