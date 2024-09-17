package com.example.assingment2greetingsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.assingment2greetingsapp.ui.theme.Assingment2GreetingsAppTheme
import java.time.LocalTime

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Assingment2GreetingsAppTheme {
                // Call GreetingScreen composable function inside setContent
                GreetingScreen()
            }
        }
    }
}

@Composable
fun GreetingScreen() {
    var name by remember { mutableStateOf("") }
    var greeting by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Enter your name") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { greeting = generateGreeting(name) }) {
            Text("Get Greeting")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = greeting,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(16.dp)
        )
    }
}

fun generateGreeting(name: String): String {
    val currentHour = LocalTime.now().hour
    val timeOfDayGreeting = when {
        currentHour in 0..5 -> "Good night"
        currentHour in 6..11 -> "Good morning"
        currentHour in 12..17 -> "Good afternoon"
        else -> "Good evening"
    }
    return "$timeOfDayGreeting $name!"
}

@Preview(showBackground = true)
@Composable
fun GreetingScreenPreview() {
    Assingment2GreetingsAppTheme {
        GreetingScreen()
    }
}
