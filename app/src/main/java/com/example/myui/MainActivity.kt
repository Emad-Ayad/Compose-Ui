package com.example.myui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myui.ui.theme.MyUiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var showDialog by remember { mutableStateOf(false) }
            var name by remember { mutableStateOf("") }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.loginpage),
                    contentDescription = null,
                    Modifier
                        .width(300.dp)
                        .height(300.dp)
                )
                Text(
                    text = "Hello",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 35.sp,
                    ),
                    modifier = Modifier.padding(top = 10.dp)
                )
                Text(
                    text = "Let’s get started and explore the world",
                    style = TextStyle(
                        fontSize = 15.sp,
                        color = Color.Gray
                    ),
                    modifier = Modifier.padding(top = 10.dp)
                )
                Text(
                    text = "all u need in one app ",
                    style = TextStyle(
                        fontSize = 15.sp,
                        color = Color.Gray
                    ),
                )

                if (showDialog) {
                    AlertDialog(
                        onDismissRequest = { showDialog = false },
                        confirmButton = {
                            Button(onClick = { /*TODO*/ }) {
                                Text(text = "OK")
                            }
                        },
                        dismissButton = {
                            Button(onClick = { showDialog = false }) {
                                Text(text = "Cancel")
                            }
                        },
                        title = { Text(text = "Title ") },
                        text = { Text(text = "Invalid username ") }
                    )
                }

                Button(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .width(250.dp)
                        .height(50.dp),
                    onClick = {
                        Toast.makeText(
                            this@MainActivity,
                            "You logged in successfully",
                            Toast.LENGTH_SHORT).show()
                    }) {
                    Text(
                        text = "Login"
                    )
                }
                OutlinedButton(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .width(250.dp)
                        .height(50.dp),
                    onClick = { showDialog=true }) {

                    Text(
                        text = "Sign Up",
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(modifier = Modifier.width(250.dp),
                    value = name, onValueChange = {
                    name = it
                })

                Spacer(modifier = Modifier.height(15.dp))
                Text(
                    text = "sign up using",
                    style = TextStyle(
                        fontSize = 15.sp,
                        color = Color.Gray
                    ),
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        modifier = Modifier
                            .width(50.dp)
                            .height(50.dp),
                        painter = painterResource(id = R.drawable.facebook),
                        contentDescription = ""
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Image(
                        modifier = Modifier
                            .width(50.dp)
                            .height(50.dp),
                        painter = painterResource(id = R.drawable.google),
                        contentDescription = ""
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Image(
                        modifier = Modifier
                            .width(35.dp)
                            .height(35.dp),
                        painter = painterResource(id = R.drawable.linkedin),
                        contentDescription = ""
                    )
                }
            }
        }
    }
}





