package com.example.bottomsheetcompose.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.bottomsheetcompose.R

@Composable
fun ProfileImage(){
    Card(
        modifier = Modifier.size(70.dp),
        shape = CircleShape,
        elevation = 4.dp
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}