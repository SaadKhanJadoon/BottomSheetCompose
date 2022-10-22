package com.example.bottomsheetcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.bottomsheetcompose.components.ProfileImage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BottomSheetMyScreen()
        }
    }

    @OptIn(ExperimentalMaterialApi::class)
    @Composable
    fun BottomSheetMyScreen() {
        val modalBottomSheetState =
            rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
        val scope = rememberCoroutineScope()
        ModalBottomSheetLayout(
            sheetContent = { BottomSheetItem() },
            sheetState = modalBottomSheetState,
            sheetShape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
            sheetBackgroundColor = Color.White
        ) {
            MyScreen(
                scope = scope,
                state = modalBottomSheetState,
            )
        }
    }

    @OptIn(ExperimentalMaterialApi::class)
    @Composable
    fun MyScreen(scope: CoroutineScope, state: ModalBottomSheetState) {
        Column(modifier = Modifier.fillMaxWidth()) {
            MainRow(name = "Name 1", onClick = {
                scope.launch {
                    state.show()
                }
            })
            MainRow(name = "Name 2", onClick = {
                scope.launch {
                    state.show()
                }
            })
        }
    }

    @Composable
    fun MainRow(name: String, onClick: () -> Unit) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .clip(RoundedCornerShape(CornerSize(10.dp)))
                .clickable(indication = rememberRipple(bounded = true),
                    interactionSource = remember { MutableInteractionSource() }) {
                    onClick.invoke()
                },
            verticalAlignment = Alignment.CenterVertically,
        ) {
            ProfileImage()
            Text(
                text = name,
                modifier = Modifier.padding(10.dp, 0.dp, 0.dp, 0.dp),
                style = MaterialTheme.typography.h6
            )
        }
    }

    //Bottom Sheet Item
    @Composable
    fun BottomSheetItem() {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(60.dp, 6.dp)
                    .align(Alignment.CenterHorizontally)
                    .background(color = Color.Black, shape = CircleShape)
                    .fillMaxWidth()
            )

            Row(
                modifier = Modifier
                    .padding(0.dp, 10.dp, 0.dp, 10.dp)
                    .fillMaxWidth()
            ) {
                //Profile Image Card
                ProfileImage()

                //Item Row Layout
                Column(
                    modifier = Modifier
                        .padding(10.dp, 0.dp, 0.dp, 0.dp)
                        .weight(1f)
                        .align(Alignment.Bottom)
                ) {
                    Text(
                        text = "Saad Khan",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.h6
                    )
                    Row(
                        modifier = Modifier.align(Alignment.Start)
                    ) {
                        Text(
                            text = "Software Engineer ",
                            modifier = Modifier.align(Alignment.CenterVertically),
                            style = MaterialTheme.typography.body2
                        )
                        Text(
                            "||",
                            modifier = Modifier.align(Alignment.CenterVertically),
                            style = MaterialTheme.typography.h6
                        )
                        Text(
                            text = " Android",
                            modifier = Modifier.align(Alignment.CenterVertically),
                            style = MaterialTheme.typography.body2
                        )
                    }
                }
            }
        }
    }
}