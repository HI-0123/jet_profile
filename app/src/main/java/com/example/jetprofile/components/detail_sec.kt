package com.example.jetprofile.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun DetailSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(
                Color.LightGray.copy(alpha = 0.3f),
            )
            .padding(16.dp)
    ) {
        Label(
            icon = Icons.Default.Favorite,
            text = "テニス、投資",
            color = Color.Gray,
        )
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        Label(
            icon = Icons.Default.LocationOn,
            text = "居住地：東京都〇〇区",
            color = Color.Gray,
        )


    }
}