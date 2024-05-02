package com.example.toolbar

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.toolbar.ui.theme.ToolbarTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToolbarTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(text = "Demo App")
                            },
                            navigationIcon = {
                                IconButton(onClick = { /*TODO*/ }) {
                                    Icon(Icons.Filled.Menu, contentDescription = null)
                                }
                            },
                            actions = {
                                IconButton(onClick = { /*TODO*/ }) {
                                    Icon(Icons.Filled.Notifications, contentDescription = null)
                                }
                                IconButton(onClick = { /*TODO*/ }) {
                                    Icon(Icons.Filled.Search, contentDescription = null)
                                }
                            }
                        )
                    },
                    floatingActionButton = {
                        FloatingActionButton(onClick = { /*TODO*/ }) {
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(Icons.Filled.Add, contentDescription = null)

                            }
                        }
                    },
                    // by default floating position
//                    floatingActionButtonPosition = FabPosition.End
                ) {
                    Greeting(s = "Hello World")
                }
            }
        }
    }
}

@Composable
fun Greeting(s: String) {
    Column(modifier = Modifier
        .background(Color.Green)
        .fillMaxSize().padding(top = 70.dp)) {
        Text(text = "Hello world")
    }
}


