package com.example.jetprofile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetprofile.components.CompanySection
import com.example.jetprofile.components.DetailSection
import com.example.jetprofile.ui.theme.JetProfileTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetProfileTheme {
                // ステータスバーの色を変える
                val systemUiController = rememberSystemUiController()
                var darkTheme = isSystemInDarkTheme()
                SideEffect {
                    systemUiController.setSystemBarsColor(
                        color = if (darkTheme) Color.Black else Color.White,
                        darkIcons = !darkTheme,
                    )
                }

                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    MainContent()
                }

            }
        }
    }
}

@Composable
fun MainContent() {
    var isShowDetail by remember {
        mutableStateOf(false)
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(20.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_profile),
            contentDescription = "プロフィール画像",
            modifier = Modifier
                .size(100.dp)
                .clip(RoundedCornerShape(10.dp)),
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Hiiisan",
            color = Color.Gray,
            fontSize = 16.sp,
            fontWeight = FontWeight.ExtraBold,
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "職業：Flutterエンジニア",
            color = Color.Gray,
            fontSize = 16.sp,
            fontWeight = FontWeight.ExtraBold,
        )
        Spacer(modifier = Modifier.height(20.dp))
        CompanySection()
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF85F6A)),
            onClick = { isShowDetail = !isShowDetail },
        ) {
            Text(text = "詳細を表示", color = Color.White)
        }
        Spacer(modifier = Modifier.height(16.dp))
        if (isShowDetail) {
            DetailSection()
        }
    }

}







