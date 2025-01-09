package com.example.notepadapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.notepadapp.ui.theme.NotepadAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotepadAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NoteAppScreen()
                }
            }
        }
    }
}

@Composable
fun NoteAppScreen() {
    var inputText by remember { mutableStateOf("") }
    val notes = remember { mutableStateListOf<String>() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color(0xFFF5F5F5))
    ) {
        LazyColumn(
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(vertical = 8.dp)
        ) {
            items(notes.size) { index ->
                Text(
                    text = notes[index],
                    style = TextStyle(fontSize = 16.sp, color = Color.DarkGray),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                        .background(Color.White, shape = MaterialTheme.shapes.small)
                        .padding(12.dp)
                )
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            BasicTextField(
                value = inputText,
                onValueChange = { inputText = it },
                textStyle = TextStyle(fontSize = 14.sp, color = Color.Black),
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp)
                    .background(Color.White, shape = MaterialTheme.shapes.small)
                    .padding(horizontal = 12.dp, vertical = 8.dp)
            )
            FloatingActionButton(
                onClick = {
                    if (inputText.isNotBlank()) {
                        notes.add(0, inputText)
                        inputText = ""
                    }
                },
                modifier = Modifier.padding(8.dp),
                containerColor = Color(0xFF6200EE)
            ) {
                Text("+", color = Color.White, fontSize = 24.sp)
            }
        }
    }
}
