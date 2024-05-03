package com.example.loginscreenui

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginscreenui.ui.theme.LoginScreenUiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginScreenUiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginScreen()
                }
            }
        }
    }

    private fun logged(userName: String, password: String) {
        if (userName == "tajammal" && password == "1234") {
            Toast.makeText(this, "Successfully Login", Toast.LENGTH_SHORT).show()

        } else {
            Toast.makeText(this, "Wrong Enter UserName or Password", Toast.LENGTH_SHORT).show()
        }
    }

    @Composable
    private fun LoginScreen() {
        val userName = rememberSaveable {
            mutableStateOf("")
        }

        val password = rememberSaveable {
            mutableStateOf("")
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Hello Again",
                color = Color.Black,
                fontSize = 25.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 8.dp)
            )
            Text(
                text = "Welcome",
                color = Color.Black,
                fontSize = 25.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 8.dp)
            )
            Text(
                text = "Back",
                color = Color.Black,
                fontSize = 25.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 8.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(
                value = userName.value,
                label = { Text(text = "UserName") },
                placeholder = { Text(text = "UserName") },
                modifier = Modifier.fillMaxWidth(),
                leadingIcon = {
                    Icon(
                        Icons.Filled.Person,
                        contentDescription = "UserName"
                    )
                },
                onValueChange = {
                    userName.value = it.trim()
                })

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = password.value,
                label = { Text(text = "Password") },
                placeholder = { Text(text = "Password") },
                leadingIcon = { Icon(Icons.Filled.Lock, contentDescription = "Password") },
                onValueChange = {
                    password.value = it
                }, modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    logged(userName.value, password.value)
                    userName.value = ""
                    password.value = ""
                }, shape = RoundedCornerShape(8.dp), colors = ButtonDefaults.buttonColors(Color.Gray),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp) // Adjust corner radius as needed

            ) {
                Text(text = "Login", fontSize = 20.sp, color = Color.Black, fontWeight = FontWeight(400))
            }
        }
    }


}

