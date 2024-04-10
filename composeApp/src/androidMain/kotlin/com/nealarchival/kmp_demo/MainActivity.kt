package com.nealarchival.kmp_demo

import CounterManager
import CounterTextColor
import Greeting
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import kmpdemo.composeapp.generated.resources.Res
import kmpdemo.composeapp.generated.resources.compose_multiplatform

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CountView()
        }
    }
}

@Preview
@Composable
fun CountView() {
    var counterManager = remember { CounterManager() }
    var refresh by remember { mutableStateOf(false) }

    fun getColor(counterTextColor: CounterTextColor): Color {
        return when (counterTextColor) {
            CounterTextColor.BLACK ->
                return Color.Black
            CounterTextColor.GREEN ->
                return Color.Green
            CounterTextColor.RED ->
                return Color.Red
        }
    }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .run {
                if (refresh) {
                    refresh = false
                }
                this
            }
    ) {
        Row() {
            Text("Count:", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Text(" ${counterManager.count}", fontSize= 24.sp, fontWeight = FontWeight.Bold, color = getColor(counterTextColor = counterManager.color))
        }

        Row() {
            Button(onClick = {
                refresh = true
                counterManager.decrement()
            }) {
                Text("Decrement")
            }

            Spacer(modifier = Modifier.padding(8.dp))

            Button(onClick = {
                refresh = true
                counterManager.increment()
            }) {
                Text("Increment")
            }
        }

        Divider(modifier = Modifier.padding(12.dp))

        Text(Greeting().greet())
    }
}

@Preview
@Composable
fun CountViewPreview() {
    CountView()
}